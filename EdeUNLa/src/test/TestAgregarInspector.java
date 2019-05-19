package test;

import negocio.InspectorABM;

public class TestAgregarInspector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			InspectorABM abm = InspectorABM.getInstance();
			abm.agregarInspector("Juan", "Gutierrez", 4014785, 114785632);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}