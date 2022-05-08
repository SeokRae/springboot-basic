package com.example.kdtspringorder4.domain.voucher;

import java.util.UUID;

public abstract class Voucher implements Discountable {

	private final UUID voucherId;
	private final long amount;
	private final VoucherType voucherType;

	protected Voucher(UUID voucherId, long amount, VoucherType voucherType) {
		this.voucherId = voucherId;
		this.amount = amount;
		this.voucherType = voucherType;
	}

	public long getAmount() {
		return amount;
	}

	public UUID getVoucherId() {
		return voucherId;
	}

	public VoucherType getVoucherType() {
		return voucherType;
	}

	@Override
	public String toString() {
		return "Voucher{" +
				"voucherId=" + voucherId +
				", amount=" + amount +
				", voucherType=" + voucherType +
				'}';
	}
}
