package test;

import negocio.ClienteABM;

public class TestAgregarPersonaFisica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			ClienteABM abm = ClienteABM.getInstance();
			abm.agregarPersonaFisica("Antonio Mentruyt 1443", "leotta010@hotmail.com", 42883850, 1138819260, 40423033, "Ezequiel",
					"Leotta");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}