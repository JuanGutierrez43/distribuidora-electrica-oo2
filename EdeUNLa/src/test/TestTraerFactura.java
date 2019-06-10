package test;

import negocio.FacturaABM;

public class TestTraerFactura {

	public static void main(String[] args) {

		System.out.println(FacturaABM.getInstance().traer(1));
		System.out.println("-------------");
		System.out.println(FacturaABM.getInstance().traer());
		
	}

}
