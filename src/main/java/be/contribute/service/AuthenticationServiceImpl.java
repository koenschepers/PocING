package be.contribute.service;

import be.fedict.eid.applet.service.spi.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.security.cert.X509Certificate;
import java.util.List;

/**
 * Created by kschepers on 1/13/14.
 */
@Component(value = "AuthenticationServiceImpl")
public class AuthenticationServiceImpl implements AuthenticationService, Serializable {
	@Override
	public void validateCertificateChain(List<X509Certificate> certificateChain) throws ExpiredCertificateSecurityException, RevokedCertificateSecurityException, TrustCertificateSecurityException, CertificateSecurityException, SecurityException {

	}
}
