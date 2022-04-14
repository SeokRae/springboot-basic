package com.example.kdtspringorder3.repository;

import com.example.kdtspringorder3.domain.voucher.Voucher;

import java.util.Optional;
import java.util.UUID;

public interface VoucherRepository {
  Optional<Voucher> findById(UUID voucherId);
  Voucher insert(Voucher voucher);
}
