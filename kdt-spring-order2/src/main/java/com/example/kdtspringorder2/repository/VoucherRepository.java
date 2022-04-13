package com.example.kdtspringorder2.repository;

import com.example.kdtspringorder2.domain.voucher.Voucher;

import java.util.Optional;
import java.util.UUID;

public interface VoucherRepository {
	Optional<Voucher> findById(UUID voucherId);

}
