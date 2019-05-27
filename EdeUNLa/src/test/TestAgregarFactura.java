package test;

import java.time.LocalDate;

import negocio.ClienteABM;
import negocio.FacturaABM;
import negocio.LecturaABM;;

public class TestAgregarFactura {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		try {

			ClienteABM abmCliente = ClienteABM.getInstance();
			FacturaABM abmFactura = FacturaABM.getInstance();
			long idFactura = 0;
			idFactura = abmFactura.agregar(abmCliente.traer(1).datosCliente() + " ", LocalDate.now(), "Ninguna");
			
			LecturaABM abmLectura = LecturaABM.getInstance();
			
			// abmFactura.agregarItemFactura(idFactura,abmLectura.traer(2)); ¡en proceso de construcción
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
