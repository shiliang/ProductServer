package com.product.server.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "consume_msg")
public class ConsumerMsg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_msg")
    private String order_msg;
}
