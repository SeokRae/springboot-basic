package com.example.kdtspringorder4.domain.voucher;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class PercentDiscountVoucherTest {

	@DisplayName("비율 가격 할인 테스트")
	@Test
	void testCase1() {
		UUID voucherId = UUID.randomUUID();

		Voucher voucher = PercentDiscountVoucher.of(voucherId, 10L);
		long actual = voucher.discount(2000L);

		assertThat(voucher).isInstanceOf(PercentDiscountVoucher.class);
		assertThat(voucher.getVoucherId()).isEqualTo(voucherId);
		assertThat(actual).isEqualTo(1800L);
	}
}