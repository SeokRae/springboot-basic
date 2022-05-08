package com.example.kdtspringorder4.domain.voucher;

import com.example.kdtspringorder4.exception.PercentOverException;

import java.util.UUID;

public class PercentDiscountVoucher extends Voucher {

	public static final int MIN_PERCENT = 0;
	public static final int MAX_PERCENT = 100;

	private PercentDiscountVoucher(UUID voucherId, long percent) {
		super(voucherId, percent, VoucherType.PERCENT);
	}

	public static PercentDiscountVoucher of(UUID voucherId, long percent) {
		validPercent(percent);
		return new PercentDiscountVoucher(voucherId, percent);
	}

	@Override
	public long discount(final long originAmount) {
		return originAmount - (long) (originAmount * (super.getAmount() / (double) 100));
	}

	private static void validPercent(final long percent) {
		if(isOutOfBoundsPercent(percent)) {
			throw new PercentOverException("퍼센테이지 값의 범위를 벗어납니다. : {}", percent);
		}
	}

	private static boolean isOutOfBoundsPercent(final long percent) {
		return percent < MIN_PERCENT || percent > MAX_PERCENT;
	}
}
