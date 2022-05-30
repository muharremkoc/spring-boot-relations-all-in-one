package com.spring.threerelationsinone.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.threerelationsinone.enums.Skill;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "skills")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Skills {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "skill_id")
    String skillID;

    @Enumerated(EnumType.STRING)
    Skill skill;

   @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    @JsonIgnore
    @JoinTable(name = "skilled_persons",
            joinColumns = {
                    @JoinColumn(name = "skill_id", referencedColumnName = "skill_id",
                            nullable = true, updatable = true)},
            inverseJoinColumns = {
                    @JoinColumn(name = "person_id", referencedColumnName = "person_id",
                            nullable = true, updatable = true)})
    List<Person> personList=new ArrayList<>();

    public void addPerson(Person person) {
        this.personList.add(person);
        this.getPersonList().stream().forEach(person1 -> person1.setSkills(Arrays.asList(this)));
    }
}
