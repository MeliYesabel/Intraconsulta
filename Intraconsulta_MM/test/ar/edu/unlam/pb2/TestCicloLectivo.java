package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TestCicloLectivo {

	@Test
	public void test() {
		Integer id = 1;
		Date a = new Date (1111 - 11 -11);
		Date b = new Date (1112 - 11 -11);
		Date c = new Date (1113 - 11 -11);
		Date n = new Date (1114 - 11 - 11);
		
		CicloLectivo test = new CicloLectivo(id,a,b,c,n);
		
		assertNotNull(test);
	}

}
