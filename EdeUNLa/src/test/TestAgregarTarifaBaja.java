package test;

import negocio.TarifaABM;

public class TestAgregarTarifaBaja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			TarifaABM abm = TarifaABM.getInstance();
			abm.agregarTarifaBaja("Baja demanda");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}