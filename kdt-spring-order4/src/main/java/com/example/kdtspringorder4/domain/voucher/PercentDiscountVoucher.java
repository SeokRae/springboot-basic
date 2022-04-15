package com.example.kdtspringorder4.domain.voucher;

import java.util.UUID;

public class PercentDiscountVoucher implements Voucher {

	private final UUID voucherId;
	private final long percent;

	public PercentDiscountVoucher(UUID voucherId, long percent) {
		this.voucherId = voucherId;
		this.percent = percent;
	}

	@Override
	public UUID getVoucherId() {
		return voucherId;
	}

	@Override
	public long discount(long originAmount) {
		return originAmount - (long) (originAmount * (percent / (double) 100));
	}

	@Override
	public String toString() {
		return "PercentDiscountVoucher{" +
				"voucherId=" + voucherId +
				", percent=" + percent +
				'}';
	}
}
