package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNota {

	@Test
	public void test() {
		Integer v = 1;
		Instancia i = Instancia.FINAL; 

		Nota nota = new Nota(v, i);
		
		assertNotNull(nota);
	}

}
