package com.example.kdtspringorder2.service;

import com.example.kdtspringorder2.domain.voucher.Voucher;
import com.example.kdtspringorder2.repository.VoucherRepository;

import java.text.MessageFormat;
import java.util.UUID;

public class VoucherService {
	private final VoucherRepository voucherRepository;

	public VoucherService(VoucherRepository voucherRepository) {
		this.voucherRepository = voucherRepository;
	}

	public Voucher getVoucher(UUID voucherId) {
		return voucherRepository
				.findById(voucherId)
				.orElseThrow(() -> new RuntimeException(MessageFormat.format("Can not find a voucher for {0}", voucherId)));
	}

	public void useVoucher(Voucher voucher) {

	}
}
