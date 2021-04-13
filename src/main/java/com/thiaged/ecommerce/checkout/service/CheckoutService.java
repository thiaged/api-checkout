package com.thiaged.ecommerce.checkout.service;

import com.thiaged.ecommerce.checkout.entity.CheckoutEntity;
import com.thiaged.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.thiaged.ecommerce.checkout.interfaces.CheckoutRepositoryInterface;
import com.thiaged.ecommerce.checkout.interfaces.CheckoutServiceInterface;
import com.thiaged.ecommerce.checkout.resource.CheckoutRequest;
import com.thiaged.ecommerce.checkout.streaming.CheckoutCreatedSource;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutService implements CheckoutServiceInterface {

    private final CheckoutRepositoryInterface checkoutRepository;
    private final CheckoutCreatedSource checkoutCreatedSource;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .status(CheckoutEntity.Status.CREATED)
                .build();

        final CheckoutEntity savedEntity = checkoutRepository.save(checkoutEntity);

        final CheckoutCreatedEvent event = CheckoutCreatedEvent.newBuilder()
                .setCheckoutCode(savedEntity.getCode())
                .setCheckoutStatus(savedEntity.getStatus().name())
                .build();

        checkoutCreatedSource.output().send(MessageBuilder.withPayload(event).build());

        return Optional.of(savedEntity);
    }
}
