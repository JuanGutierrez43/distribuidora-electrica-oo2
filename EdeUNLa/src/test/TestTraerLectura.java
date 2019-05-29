package test;

import negocio.LecturaABM;

public class TestTraerLectura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LecturaABM abm = LecturaABM.getInstance();
		System.out.println(abm.traer(2));
	}
}