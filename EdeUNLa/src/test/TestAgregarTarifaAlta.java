package test;

import negocio.TarifaABM;

public class TestAgregarTarifaAlta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			TarifaABM abm = TarifaABM.getInstance();
			abm.agregarTarifaAlta("BT<300kW", "BT", 300);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}