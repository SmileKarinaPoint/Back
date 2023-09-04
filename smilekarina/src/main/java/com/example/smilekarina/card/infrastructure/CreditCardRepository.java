package com.example.smilekarina.card.infrastructure;

import com.example.smilekarina.card.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    List<CreditCard> findByUserId(Long userId);

}
