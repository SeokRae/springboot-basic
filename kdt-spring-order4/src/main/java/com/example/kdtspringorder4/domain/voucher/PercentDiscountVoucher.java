package com.example.kdtspringorder4.domain.voucher;

import java.util.UUID;

public class PercentDiscountVoucher extends Voucher {

	public PercentDiscountVoucher(UUID voucherId, long percent) {
		super(voucherId, percent);
	}

	@Override
	public long discount(long originAmount) {
		return originAmount - (long) (originAmount * (amount / (double) 100));
	}

	@Override
	public String toString() {
		return "PercentDiscountVoucher{" +
				"voucherId=" + voucherId +
				", percent=" + amount +
				'}';
	}
}
