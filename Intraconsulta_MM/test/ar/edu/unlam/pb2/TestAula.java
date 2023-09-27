package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAula {

	@Test
	public void test() {
		Integer cap = 1;
		Integer num = 1;
		
		Aula aula = new Aula(num, cap);
		
		assertNotNull(aula);
	}

}
