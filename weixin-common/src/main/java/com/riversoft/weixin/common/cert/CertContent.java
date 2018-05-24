package com.riversoft.weixin.common.cert;

import java.io.IOException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * 
 * title: CertContent.java 
 * 证书内容加载
 *
 * @author rplees
 * @email rplees.i.ly@gmail.com
 * @version 1.0  
 * @created May 21, 2018 11:39:02 PM
 */
public interface CertContent {
	void load(KeyStore keyStore, String certPassword) throws CertificateException, NoSuchAlgorithmException, IOException;
}
