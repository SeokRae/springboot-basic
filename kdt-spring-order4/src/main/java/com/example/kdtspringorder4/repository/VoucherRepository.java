package com.example.kdtspringorder4.repository;

import com.example.kdtspringorder4.domain.voucher.Voucher;

import java.util.Optional;
import java.util.UUID;

public interface VoucherRepository {
	Optional<Voucher> findById(UUID voucherId);

	Voucher insert(Voucher voucher);
}
