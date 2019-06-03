package test;

import datos.Factura;
import negocio.FacturaABM;
import negocio.MedidorABM;;

public class TestAgregarFactura {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		try {

			FacturaABM abmFactura = FacturaABM.getInstance();

//			Medidor medidor : medidor que tiene los datos del cliente para buscar
//			int mes : mes del 1 al 12 que requiere para la busqueda de lectura , tambien sirve para trae la lectura de 2 mes atras
//			int anio : año que requiere para la busqueda de lectura
			Factura factura = abmFactura.generarFactura(MedidorABM.getInstance().traer(2), 2, 2019);
			System.out.println(factura);
			abmFactura.alta(factura);
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
