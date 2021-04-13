package com.thiaged.ecommerce.checkout.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Builder
@Data
@Entity
public class CheckoutEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String code;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    public enum Status {
        CREATED,
        APROVED
    }
}
