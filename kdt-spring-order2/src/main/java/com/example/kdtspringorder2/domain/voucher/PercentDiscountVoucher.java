package com.example.kdtspringorder2.domain.voucher;

import java.util.Objects;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PercentDiscountVoucher that = (PercentDiscountVoucher) o;
		return percent == that.percent && Objects.equals(voucherId, that.voucherId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(voucherId, percent);
	}
}
