package test;

import negocio.ClienteABM;

public class TestAgregarPersonaJuridica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			ClienteABM abm = ClienteABM.getInstance();
			abm.agregarPersonaJuridica("Pienovi 104", "andreani@hotmail.com", 428957, 113896547, "204257893", "Andreani");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}