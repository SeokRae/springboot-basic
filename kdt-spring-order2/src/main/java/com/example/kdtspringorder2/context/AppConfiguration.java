package com.example.kdtspringorder2.context;

import com.example.kdtspringorder2.domain.order.Order;
import com.example.kdtspringorder2.domain.voucher.Voucher;
import com.example.kdtspringorder2.repository.OrderRepository;
import com.example.kdtspringorder2.repository.VoucherRepository;
import com.example.kdtspringorder2.service.OrderService;
import com.example.kdtspringorder2.service.VoucherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.UUID;

/**
 * Bean을 정의한 Context
 */
@Configuration
public class AppConfiguration {

  @Bean
  public VoucherRepository voucherRepository() {
    return new VoucherRepository() {
      @Override
      public Optional<Voucher> findById(UUID voucherId) {
        return Optional.empty();
      }
    };
  }

  @Bean
  public OrderRepository orderRepository() {
    return new OrderRepository() {
      @Override
      public void insert(Order order) {
      }
    };
  }

  @Bean
  public VoucherService voucherService(VoucherRepository voucherRepository) {
    return new VoucherService(voucherRepository);
  }

  @Bean
  public OrderService orderService(VoucherService voucherService, OrderRepository orderRepository) {
    return new OrderService(voucherService, orderRepository);
  }

}
