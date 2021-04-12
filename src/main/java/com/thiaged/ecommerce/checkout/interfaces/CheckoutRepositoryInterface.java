package com.thiaged.ecommerce.checkout.interfaces;

import com.thiaged.ecommerce.checkout.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepositoryInterface extends JpaRepository<CheckoutEntity, Long> {
}
