package com.thiaged.ecommerce.checkout.resource;

import com.thiaged.ecommerce.checkout.entity.CheckoutEntity;
import com.thiaged.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.thiaged.ecommerce.checkout.interfaces.CheckoutServiceInterface;
import com.thiaged.ecommerce.checkout.streaming.CheckoutCreatedSource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
public class CheckoutResource {

    private final CheckoutServiceInterface checkoutService;
    private final CheckoutCreatedSource checkoutCreatedSource;

    @PostMapping("/")
    public ResponseEntity<CheckoutResponse> create(@RequestBody CheckoutRequest checkoutRequest) {
        final CheckoutEntity entity = checkoutService.create(checkoutRequest).orElseThrow();
        final CheckoutResponse response = CheckoutResponse.builder()
                .code(entity.getCode())
                .status(entity.getStatus().toString())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
