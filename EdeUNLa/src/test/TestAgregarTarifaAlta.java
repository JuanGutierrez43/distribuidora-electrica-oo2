package test;

import negocio.TarifaABM;

public class TestAgregarTarifaAlta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			TarifaABM abm = TarifaABM.getInstance();
			abm.agregarTarifaAlta("BT<300kW", "BT", 300);
			abm.agregarTarifaAlta("BT>300kW", "BT", 999999999);
			abm.agregarTarifaAlta("MT<300kW", "MT", 300);
			abm.agregarTarifaAlta("MT>300kW", "MT", 999999999);
			abm.agregarTarifaAlta("AT<300kW", "AT", 300);
			abm.agregarTarifaAlta("AT>300kW", "AT", 999999999);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}