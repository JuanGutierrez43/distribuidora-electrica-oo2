package test;

import datos.Cliente;
import datos.Zona;
import negocio.ClienteABM;
import negocio.MedidorABM;
import negocio.ZonaABM;

public class TestAgregarMedidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			MedidorABM abmMedidor = MedidorABM.getInstance();
			ClienteABM abmCliente = ClienteABM.getInstance();
			Cliente c = abmCliente.traer(1);
			ZonaABM abmZona = ZonaABM.getInstance();
			Zona z = abmZona.traer(1);
			abmMedidor.agregarMedidor(c, 1, "Antonio Mentruyt 1443", z);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}