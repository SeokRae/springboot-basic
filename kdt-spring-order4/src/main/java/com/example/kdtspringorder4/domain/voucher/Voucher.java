package com.example.kdtspringorder4.domain.voucher;

import java.util.UUID;

public abstract class Voucher implements Discountable {

	protected final UUID voucherId;
	protected final long amount;

	protected Voucher(UUID voucherId, long amount) {
		this.voucherId = voucherId;
		this.amount = amount;
	}

	public long getAmount() {
		return amount;
	}

	public UUID getVoucherId() {
		return voucherId;
	}
}
