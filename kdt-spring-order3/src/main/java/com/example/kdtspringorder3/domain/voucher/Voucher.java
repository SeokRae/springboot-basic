package com.example.kdtspringorder3.domain.voucher;

import java.util.UUID;

public interface Voucher {

	UUID getVoucherId();

	long discount(long originAmount);

}
