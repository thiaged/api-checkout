package com.thiaged.ecommerce.checkout.config;

import com.thiaged.ecommerce.checkout.streaming.CheckoutCreatedSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = {
        CheckoutCreatedSource.class,
//        PaymentPaidSink.class
})
public class StreamingConfig {
}
