package test;

import negocio.ZonaABM;

public class TestAgregarZona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			ZonaABM abm = ZonaABM.getInstance();
			abm.agregarZona("Buenos Aires");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}