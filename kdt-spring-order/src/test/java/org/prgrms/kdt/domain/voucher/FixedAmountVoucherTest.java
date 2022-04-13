package org.prgrms.kdt.domain.voucher;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class FixedAmountVoucherTest {

	@DisplayName("고정 가격 할인 테스트")
	@Test
	void testCase1() {
		UUID voucherId = UUID.randomUUID();

		Voucher voucher = new FixedAmountVoucher(voucherId, 10L);
		long actual = voucher.discount(1000);

		assertThat(voucher).isInstanceOf(FixedAmountVoucher.class);
		assertThat(actual).isEqualTo(990L);
	}
}