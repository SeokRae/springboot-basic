package com.example.kdtspringorder4.domain.voucher;

import java.util.UUID;

public class DefaultAmountVoucher extends Voucher {

	public DefaultAmountVoucher() {
		super(UUID.randomUUID(), 0, VoucherType.DEFAULT);
	}

	@Override
	public long discount(long originAmount) {
		return originAmount;
	}

}
