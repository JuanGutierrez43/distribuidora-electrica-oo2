package test;

import negocio.TarifaABM;

public class TestAgregarTarifaBaja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			TarifaABM abm = TarifaABM.getInstance();
			abm.agregarTarifaBaja("T1 - R1 0-150"); 
			abm.agregarTarifaBaja("T1 - R2 151-325"); 
			abm.agregarTarifaBaja("T1 - R3 326-400");
			abm.agregarTarifaBaja("T1 - R4 401-450");
			abm.agregarTarifaBaja("T1 - R5 451-500");
			abm.agregarTarifaBaja("T1 - R6 501-600");
			abm.agregarTarifaBaja("T1 - R7 601-700");
			abm.agregarTarifaBaja("T1 - R8 701-1400");
			abm.agregarTarifaBaja("T1 - R9 +1400");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}