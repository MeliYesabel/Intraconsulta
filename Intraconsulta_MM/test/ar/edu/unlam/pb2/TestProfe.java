package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestProfe {

	@Test
	public void crearProfe() {
		String n = "a";
		Integer c = 111;
		
		Profesor test = new Profesor(n, c);
		
		assertNotNull(test);
		
	}

}
