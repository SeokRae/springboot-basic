package com.example.kdtspringorder4.service;

import com.example.kdtspringorder4.domain.voucher.Voucher;
import com.example.kdtspringorder4.repository.VoucherRepository;
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
		return voucherRepository.findById(voucherId)
				.orElseThrow(() -> new RuntimeException(MessageFormat.format("Can not find a voucher for {}", voucherId)));
	}

	public void useVoucher(Voucher voucher) {
	}
}
