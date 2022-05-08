package com.example.kdtspringorder4.domain.voucher;

import java.util.UUID;

public class FixedAmountVoucher extends Voucher {

	private static final int MIN_VALUE = 0;

	private FixedAmountVoucher(UUID voucherId, long amount) {
		super(voucherId, amount, VoucherType.FIXED);
	}

	public static FixedAmountVoucher of(final UUID voucherId, final long amount) {
		return new FixedAmountVoucher(voucherId, amount);
	}

	@Override
	public long discount(final long originAmount) {
		final long resultAmount = originAmount - super.getAmount();
		return resultAmount > MIN_VALUE ? resultAmount : MIN_VALUE;
	}
}
