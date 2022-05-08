package com.example.kdtspringorder4.domain.voucher;

import com.example.kdtspringorder4.exception.RangeAmountException;

import java.util.UUID;

public class FixedAmountVoucher extends Voucher {

	public FixedAmountVoucher(UUID voucherId, long amount) {
		super(voucherId, amount);
		isValidAmount(amount);
	}

	@Override
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
