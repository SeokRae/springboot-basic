package com.example.kdtspringorder4.domain.voucher;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultAmountVoucherTest {

	@DisplayName("Voucher 없이 주문 시 가격 확인 테스트")
	@Test
	void testCase1() {
		Voucher voucher = new DefaultAmountVoucher();
		long actual = voucher.discount(1000);

		assertThat(voucher).isInstanceOf(DefaultAmountVoucher.class);
		assertThat(actual).isEqualTo(1000);
	}
}