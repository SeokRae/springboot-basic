package com.example.kdtspringprofile.vouchers;

import java.util.Optional;
import java.util.UUID;

public interface VoucherRepository {
	Optional<Voucher> findById(UUID voucherId);

	Voucher insert(Voucher voucher);
}
