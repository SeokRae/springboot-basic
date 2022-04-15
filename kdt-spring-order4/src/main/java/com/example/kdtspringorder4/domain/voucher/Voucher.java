package com.example.kdtspringorder4.domain.voucher;

import java.util.UUID;

public interface Voucher {

	UUID getVoucherId();

	long discount(long originAmount);

}
