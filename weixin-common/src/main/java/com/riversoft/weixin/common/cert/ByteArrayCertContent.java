package com.riversoft.weixin.common.cert;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class ByteArrayCertContent implements CertContent {
	private byte[] certBytes;

	public ByteArrayCertContent(byte[] certBytes) {
		this.certBytes = certBytes;
	}

	@Override
	public void load(KeyStore keyStore, String certPassword)
			throws CertificateException, NoSuchAlgorithmException, IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(this.certBytes);
		keyStore.load(bis, certPassword.toCharArray());
	}

}
