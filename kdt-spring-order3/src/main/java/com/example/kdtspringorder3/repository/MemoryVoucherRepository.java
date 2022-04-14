package com.example.kdtspringorder3.repository;

import com.example.kdtspringorder3.domain.voucher.Voucher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryVoucherRepository implements VoucherRepository {

  private final Map<UUID, Voucher> storage = new ConcurrentHashMap<>();

  @Override
  public Optional<Voucher> findById(UUID voucherId) {
    return Optional.ofNullable(storage.get(voucherId));
  }

  @Override
  public Voucher insert(Voucher voucher) {
    storage.put(voucher.getVoucherId(), voucher);
    return voucher;
  }

}
