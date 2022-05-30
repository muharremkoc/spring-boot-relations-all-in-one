package com.spring.threerelationsinone.repositories;

import com.spring.threerelationsinone.domain.CreditCard;
import com.spring.threerelationsinone.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

public interface CreditCardRepository extends JpaRepository<CreditCard,String> {

    @Modifying
    @Transactional
    CreditCard findCreditCardsByPerson(Person person);

    List<CreditCard> findAllByPerson(Person person);

}
