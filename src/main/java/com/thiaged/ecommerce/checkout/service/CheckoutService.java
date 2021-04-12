package com.thiaged.ecommerce.checkout.service;

import com.thiaged.ecommerce.checkout.entity.CheckoutEntity;
import com.thiaged.ecommerce.checkout.interfaces.CheckoutRepositoryInterface;
import com.thiaged.ecommerce.checkout.interfaces.CheckoutServiceInterface;
import com.thiaged.ecommerce.checkout.resource.CheckoutRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutService implements CheckoutServiceInterface {

    private final CheckoutRepositoryInterface checkoutRepository;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .build();

        return Optional.of(checkoutRepository.save(checkoutEntity));
    }
}
