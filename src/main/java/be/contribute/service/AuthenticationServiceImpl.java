package be.contribute.service;

import be.fedict.eid.applet.service.spi.*;
import be.fedict.trust.client.XKMS2Client;
import be.fedict.trust.client.exception.RevocationDataNotFoundException;
import be.fedict.trust.client.exception.TrustDomainNotFoundException;
import be.fedict.trust.client.exception.ValidationFailedException;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.List;

/**
 * Created by kschepers on 1/13/14.
 */
@Component
public class AuthenticationServiceImpl implements AuthenticationService, Serializable {
	@Override
	public void validateCertificateChain(List<X509Certificate> certificateChain) throws ExpiredCertificateSecurityException, RevokedCertificateSecurityException, TrustCertificateSecurityException, CertificateSecurityException, SecurityException {
		XKMS2Client client = new XKMS2Client("https://www.e-contract.be/eid-trust-service-ws/xkms2");
		try {
			client.validate(certificateChain);
		} catch (CertificateEncodingException e) {
			e.printStackTrace();
		} catch (TrustDomainNotFoundException e) {
			e.printStackTrace();
		} catch (RevocationDataNotFoundException e) {
			e.printStackTrace();
		} catch (ValidationFailedException e) {
			e.printStackTrace();
		}
	}
}
