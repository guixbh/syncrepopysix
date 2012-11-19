package com.tenacity.pysix.asterisk.connection;

import org.apache.commons.lang3.StringUtils;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Guilherme Henrique(guilhermbh@gmail.com)
 * 
 *         Classe que representa uma conexao ao servidor asterisk
 */
public class AsteriskConnectionBean {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Adress of the asterisk server
	 */
	private String asteriskAddress = "127.0.0.1";
	/**
	 * AMI port on asterisk server
	 */
	private int managerPort = 5038;
	/**
	 * AMI User
	 */
	private String managerLogin = "admin";
	/**
	 * AMI Password
	 */
	private String managerPassword = "@dvah*310755";
	
	/**
	 * Connection to asterisk server
	 */
	private ManagerConnection managerConnection = null;

	public String getAsteriskAddress() {
		return asteriskAddress;
	}

	/**
	 * Sets the value of asterisk server, in case of invalid value, defaults to
	 * 127.0.0.1
	 * 
	 * @param asteriskAddress
	 *            - Adress of the Asterisk Server
	 */
	public void setAsteriskAddress(String asteriskAddress) {
		// verifica se o nome do servidor esta vazio ou se existem espaços no
		// nome do servidor
		if (StringUtils.isEmpty(asteriskAddress)
				|| StringUtils.containsAny(asteriskAddress, ' ')) {
			logger.error("Endereco do servidor asterisk invalido, verifique a configuracao no arquivo asterisk-connection.xml");
			logger.debug("Setando default asteriskAddress = " + asteriskAddress);
		} else {
			logger.debug("Setando asteriskAddress = " + asteriskAddress);
			this.asteriskAddress = asteriskAddress;
		}
	}

	public int getManagerPort() {
		return managerPort;
	}

	
	public void setManagerPort(int managerPort) {
		// verificase a porta esta dentro do range de portas validas
		if (managerPort <= 0 || managerPort > 65535) {
			logger.error("Manager port do asterisk invalido, verifique a configuracao no arquivo asterisk-connection.xml");
			logger.debug("Setando default managerPort = " + managerPort);
		} else {
			logger.debug("Setando managerPort = " + managerPort);
			this.managerPort = managerPort;
		}

	}

	public String getManagerLogin() {
		return managerLogin;
	}

	public void setManagerLogin(String managerLogin) {
		// verifica se o nome do login esta vazio ou se existem espaços no
		// nome do login
		if (StringUtils.isEmpty(managerLogin)
				|| StringUtils.containsAny(managerLogin, ' ')) {
			logger.error("Login do Manager do servidor asterisk invalido, verifique a configuracao no arquivo asterisk-connection.xml");
			logger.debug("Setando default Login do Manager = " + managerLogin);
		} else {
			logger.debug("Setando Login do Manager = " + managerLogin);
			this.managerLogin = managerLogin;
		}
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		// verifica se o password do login esta vazio ou se existem espaços no
		// password do login
		if (StringUtils.isEmpty(managerPassword)
				|| StringUtils.containsAny(managerPassword, ' ')) {
			logger.error("Password do Manager do servidor asterisk invalido, verifique a configuracao no arquivo asterisk-connection.xml");
			logger.debug("Setando default Password do Manager = " + managerPassword);
		} else {
			logger.debug("Setando Password do Manager = " + managerPassword);
			this.managerLogin = managerPassword;
		}
	}
	
	/**
	 * Connects to the Asterisk server
	 */
	public void connect(){
		ManagerConnectionFactory managerConnectionFactory = new ManagerConnectionFactory(asteriskAddress, managerLogin, managerPassword);
		
	}
	
	
}
