package com.thiaged.ecommerce.checkout.listener;

import com.thiaged.ecommerce.checkout.entity.CheckoutEntity;
import com.thiaged.ecommerce.checkout.event.PaymentCreatedEvent;
import com.thiaged.ecommerce.checkout.interfaces.CheckoutRepositoryInterface;
import com.thiaged.ecommerce.checkout.streaming.PaymentPaidSink;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutRepositoryInterface checkoutRepository;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent event) {
        final CheckoutEntity checkoutEntity = checkoutRepository.findByCode(event.getCheckoutCode().toString()).orElseThrow();
        checkoutEntity.setStatus(CheckoutEntity.Status.APROVED);
        checkoutRepository.save(checkoutEntity);
    }
}
