package com.thiaged.ecommerce.checkout.resource;

import com.thiaged.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.thiaged.ecommerce.checkout.interfaces.CheckoutServiceInterface;
import com.thiaged.ecommerce.checkout.streaming.CheckoutCreatedSource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
public class CheckoutResource {

    private final CheckoutServiceInterface checkoutService;
    private final CheckoutCreatedSource checkoutCreatedSource;

    @PostMapping("/")
    public ResponseEntity<Void> create(CheckoutRequest checkoutRequest) {
        checkoutService.create(checkoutRequest);
        return ResponseEntity.ok().build();
    }
}
