package com.example.kdtspringorder2.domain.voucher;

import java.util.UUID;

public class FixedAmountVoucher implements Voucher {
	private final UUID voucherId;
	private final long amount;

	public FixedAmountVoucher(UUID voucherId, long amount) {
		this.voucherId = voucherId;
		this.amount = amount;
	}

	@Override
	public UUID getVoucherId() {
		return voucherId;
	}

	public long discount(long originAmount) {
		return originAmount - amount;
	}
}
