package fr.in2p3.jsaga.adaptor.ourgrid.job;

import java.util.Map;

import org.ogf.saga.error.AuthenticationFailedException;
import org.ogf.saga.error.AuthorizationFailedException;
import org.ogf.saga.error.BadParameterException;
import org.ogf.saga.error.IncorrectStateException;
import org.ogf.saga.error.IncorrectURLException;
import org.ogf.saga.error.NoSuccessException;
import org.ogf.saga.error.NotImplementedException;
import org.ogf.saga.error.TimeoutException;

import fr.in2p3.jsaga.adaptor.ClientAdaptor;
import fr.in2p3.jsaga.adaptor.base.defaults.Default;
import fr.in2p3.jsaga.adaptor.base.usage.Usage;
import fr.in2p3.jsaga.adaptor.ourgrid.security.OurGridSecurityCredencial;
import fr.in2p3.jsaga.adaptor.security.SecurityCredential;

/* ***************************************************
 * ***  Distributed Systems Lab(LSD)-UFCG) ***
 * ***   http://www.lsd.ufcg.edu.br        ***
 * ***************************************************
 * File:   OurGridDataAdaptor
 * Author: Patricia Alanis (patriciaam@lsd.ufcg.edu.br)
 * Date:   August 2012
 * ***************************************************/

public abstract class OurGridAbstract implements ClientAdaptor {

	protected String m_account;
	protected String m_passPhrase;

	public Default[] getDefaults(Map attributes)throws IncorrectStateException {

		return null;
	}

	/**
	 * @return Returns the adaptor type
	 */
	public String getType() {

		return OurGridConstants.TYPE_ADAPTOR;
	}

	public String getM_account() {
		return m_account;
	}

	public void setM_account(String m_account) {
		this.m_account = m_account;
	}

	public String getM_passPhrase() {
		return m_passPhrase;
	}

	public void setM_passPhrase(String m_passPhrase) {
		this.m_passPhrase = m_passPhrase;
	}

	/**
	 * Get a data structure that describes how to use this adaptor. This data
	 * structure contains attribute names with usage constraints (and/or,
	 * required/optional, hidden...)
	 * */
	public Usage getUsage() {

		return null;
	}

	/**
	 * This method connect to the server and initialize the connection with the
	 * provided attributes
	 * 
	 * @param userInfo the user login
	 * @param host the server
	 * @param port the port
	 * @param basePath the base path
	 * @param attributes the provided attributes
	 */
	public void connect(String userInfo, String host, int port,	String basePath, Map attributes)
			throws NotImplementedException,	AuthenticationFailedException, AuthorizationFailedException, IncorrectURLException, BadParameterException, TimeoutException, NoSuccessException {


	}

	/**
	 * This method disconnect from the server
	 */
	public void disconnect() throws NoSuccessException {

	}

	/**
	 * @return Returns the port number
	 */
	public int getDefaultPort() {

		return OurGridConstants.PORT;

	}

	public Class[] getSupportedSecurityCredentialClasses() {

		return new Class[] { OurGridSecurityCredencial.class };
	}

	public void setSecurityCredential(SecurityCredential credential) {

		setM_account(((OurGridSecurityCredencial) credential).getUserID());
		setM_passPhrase(((OurGridSecurityCredencial) credential).getUserPass());

	}
}