package test;

import datos.AltaDemanda;
import datos.BajaDemanda;
import datos.Lectura;
import negocio.DetalleBajaABM;
//import negocio.ItemFacturaABM;
import negocio.LecturaABM;
import negocio.TarifaABM;

public class TestAgregarItemFacturaBaja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			// ItemFacturaABM abm = ItemFacturaABM.getInstance(); ¡en proceso de
			// construcción

			LecturaABM abmLectura = LecturaABM.getInstance();
			Lectura lectura = abmLectura.traer(2);

			System.out.println(lectura);
			if (lectura instanceof AltaDemanda) {
				// casteamos
				AltaDemanda lecturaBaja = (AltaDemanda) lectura;
				int consumo = lecturaBaja.getConsumoHorasPico();
				System.out.println(consumo + " ");

			}

			if (lectura instanceof BajaDemanda) {
				BajaDemanda lecturaBaja = (BajaDemanda) lectura;
				int consumo = lecturaBaja.getConsumo();

				System.out.println(consumo + " ");

				DetalleBajaABM abmBaja = DetalleBajaABM.getInstance();

				double precioUnitario = abmBaja.traer(1).getValor();

				System.out.println(precioUnitario + "$/mes" + abmBaja.traer(1));

			}
			TarifaABM abmTarifa = TarifaABM.getInstance();

			System.out.println(abmTarifa.traer());

			// abm.agregarItemFactura(precioUnitario, consumo, "$/mes", lectura);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}