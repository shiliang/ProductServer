package com.product.server.repository;

import com.product.server.entity.ConsumerMsg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<ConsumerMsg, Integer> {
}
