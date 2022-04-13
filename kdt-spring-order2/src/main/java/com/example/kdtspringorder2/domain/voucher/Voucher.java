package com.example.kdtspringorder2.domain.voucher;

import java.util.UUID;

public interface Voucher {

	UUID getVoucherId();

	long discount(long originAmount);

}
