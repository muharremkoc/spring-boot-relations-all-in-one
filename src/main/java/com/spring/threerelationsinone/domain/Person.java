package com.spring.threerelationsinone.domain;

import com.spring.threerelationsinone.enums.Gender;
import com.spring.threerelationsinone.enums.MarialStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "person")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "person_id")
    String personID;

    String firstName;

    String lastName;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Enumerated(EnumType.STRING)
    MarialStatus marialStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "residential_id", referencedColumnName = "residential_id")
   Residential residential;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="person")
  List<CreditCard> creditCard;


    @ManyToMany(mappedBy = "personList", cascade = CascadeType.ALL)
    List<Skills> skills=new ArrayList<>();

       public void addSkill(Skills skills1){
           this.skills.add(skills1);
           this.getSkills().stream().forEach(skills2 -> skills2.setPersonList(Arrays.asList(this)));
       }
    public void addCreditCard(List<CreditCard> creditCards){

        creditCards.stream().forEach(creditCard -> {
            creditCard.setPerson(this);
        });
        this.creditCard=creditCards;
    }

    public void removeCreditCard(CreditCard creditCards) {
        creditCard.remove(creditCards);
        creditCards.setPerson(null);
    }
}
