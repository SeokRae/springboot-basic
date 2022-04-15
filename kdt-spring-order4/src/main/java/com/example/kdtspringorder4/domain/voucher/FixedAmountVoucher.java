package com.example.kdtspringorder4.domain.voucher;

import com.example.kdtspringorder4.exception.RangeAmountException;

import java.util.UUID;

public class FixedAmountVoucher implements Voucher {

	private final UUID voucherId;
	private final long amount;

	public FixedAmountVoucher(UUID voucherId, long amount) {
		isValidAmount(amount);
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

	private void isValidAmount(long amount) {
		if (!isPositiveAmount(amount)) {
			throw new RangeAmountException();
		}
	}

	private boolean isPositiveAmount(long amount) {
		return amount > 0 && amount < Long.MAX_VALUE;
	}
}
