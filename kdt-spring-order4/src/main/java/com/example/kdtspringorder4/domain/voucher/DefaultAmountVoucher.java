package com.example.kdtspringorder4.domain.voucher;

import java.util.UUID;

public class DefaultAmountVoucher implements Voucher {

	@Override
	public UUID getVoucherId() {
		return UUID.randomUUID();
	}

	@Override
	public long discount(long originAmount) {
		return originAmount;
	}

}
