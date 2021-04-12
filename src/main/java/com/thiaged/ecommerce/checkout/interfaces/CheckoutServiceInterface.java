package com.thiaged.ecommerce.checkout.interfaces;

import com.thiaged.ecommerce.checkout.entity.CheckoutEntity;
import com.thiaged.ecommerce.checkout.resource.CheckoutRequest;

import java.util.Optional;

public interface CheckoutServiceInterface {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);
}
