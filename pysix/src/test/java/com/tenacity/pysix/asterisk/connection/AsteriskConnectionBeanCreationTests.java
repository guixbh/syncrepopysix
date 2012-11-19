package com.tenacity.pysix.asterisk.connection;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Classe que testa as configuracoes de conexao ao asterisk
 * 
 * @author Guilherme Henrique(guilhermbh@gmail.com)
 * 
 */
public class AsteriskConnectionBeanCreationTests {

	@Test
	public void DefaultValuesTest() {
		AsteriskConnectionBean asteriskConnectionBean = new AsteriskConnectionBean();
		// verifica se os beans tem o valor padrao
		assertEquals("127.0.0.1", asteriskConnectionBean.getAsteriskAddress());
		assertEquals(5038, asteriskConnectionBean.getManagerPort());
		assertEquals("admin", asteriskConnectionBean.getManagerLogin());
		assertEquals("@dvah*310755",
				asteriskConnectionBean.getManagerPassword());
	}

	@Test
	public void IncorretValueTest() {
		AsteriskConnectionBean asteriskConnectionBean = new AsteriskConnectionBean();
		// verifica se os beans tem o valor padrao
		// testa endereco com espacos
		asteriskConnectionBean.setAsteriskAddress("endereco testes");
		assertEquals("127.0.0.1", asteriskConnectionBean.getAsteriskAddress());
		// testa endereco vazio
		asteriskConnectionBean.setAsteriskAddress("");
		assertEquals("127.0.0.1", asteriskConnectionBean.getAsteriskAddress());
		// testa endereco apenas espacos
		asteriskConnectionBean.setAsteriskAddress("   ");
		assertEquals("127.0.0.1", asteriskConnectionBean.getAsteriskAddress());
		// testa uma porta acima do range
		asteriskConnectionBean.setManagerPort(90000);
		assertEquals(5038, asteriskConnectionBean.getManagerPort());
		// testa uma porta negativa
		asteriskConnectionBean.setManagerPort(-10000);
		assertEquals(5038, asteriskConnectionBean.getManagerPort());
		// testa uma porta igual a zero
		asteriskConnectionBean.setManagerPort(-10000);
		assertEquals(5038, asteriskConnectionBean.getManagerPort());
		// testa login com espacos
		asteriskConnectionBean.setManagerLogin("endereco testes");
		assertEquals("admin", asteriskConnectionBean.getManagerLogin());
		// testa endereco vazio
		asteriskConnectionBean.setManagerLogin("");
		assertEquals("admin", asteriskConnectionBean.getManagerLogin());
		// testa endereco apenas espacos
		asteriskConnectionBean.setManagerLogin("   ");
		assertEquals("admin", asteriskConnectionBean.getManagerLogin());
		// testa password com espacos
		asteriskConnectionBean.setManagerPassword("endereco testes");
		assertEquals("@dvah*310755", asteriskConnectionBean.getManagerPassword());
		// testa endereco vazio
		asteriskConnectionBean.setManagerPassword("");
		assertEquals("@dvah*310755", asteriskConnectionBean.getManagerPassword());
		// testa endereco apenas espacos
		asteriskConnectionBean.setManagerPassword("   ");
		assertEquals("@dvah*310755", asteriskConnectionBean.getManagerPassword());
	}

}
