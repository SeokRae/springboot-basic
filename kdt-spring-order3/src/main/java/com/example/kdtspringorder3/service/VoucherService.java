package com.example.kdtspringorder3.service;

import com.example.kdtspringorder3.domain.voucher.Voucher;
import com.example.kdtspringorder3.repository.VoucherRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.UUID;

@Service
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
