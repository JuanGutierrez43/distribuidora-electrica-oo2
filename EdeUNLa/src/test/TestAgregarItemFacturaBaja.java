package test;

import java.util.List;

import datos.AltaDemanda;
import datos.BajaDemanda;
import datos.DetalleBaja;
import datos.Lectura;
import datos.TarifaBaja;
import negocio.DetalleBajaABM;
//import negocio.ItemFacturaABM;
import negocio.LecturaABM;
import negocio.MedidorABM;
import negocio.TarifaABM;

public class TestAgregarItemFacturaBaja {

	public static void main(String[] args) {
		// Este TestAgregarItemFacturaBaja no funciona a propósito por Victor pero sirve para saber dónde sacar los datos de itemFactura 
		try {

			// ItemFacturaABM abm = ItemFacturaABM.getInstance(); ¡en proceso de
			// construcción

			LecturaABM abmLectura = LecturaABM.getInstance();
			//Lectura lectura = abmLectura.traer(3);
			List <Lectura> lstLectura = abmLectura.traer();

			//System.out.println(lstLectura);
			
			MedidorABM abmMedidor = MedidorABM.getInstance();
			Lectura lectura = abmLectura.traer(abmMedidor.traer(1),7,2019);
			
			
			TarifaABM abmTarifa = TarifaABM.getInstance();

			if (lectura instanceof BajaDemanda) {
				BajaDemanda lecturaBaja = (BajaDemanda) lectura;

				System.out.println(lecturaBaja);
				System.out.println(((TarifaBaja) abmTarifa.traer(lecturaBaja).get(0)).getLstDetalle());
				System.out.println();
				float total = 0;
				double precioUnitario = 0;
				int cantidad = 0;
				String unidad = null;
				cantidad = lecturaBaja.getConsumo();//-abmLectura.traerLecturaAnterior(lecturaBaja).getConsumo();
				
				for (DetalleBaja db : ((TarifaBaja) abmTarifa.traer(lecturaBaja).get(0)).getLstDetalle()) {
					if (db.getDetalleConcepto().equalsIgnoreCase("Cargo Fijo")) {
						total += db.getValor();
						unidad = db.getUnidad();
					} else {
						total += db.getValor() * (cantidad - db.getDesde());
						//- lectura anterior
						precioUnitario = db.getValor();
					}
//					System.out.println("subT : " + total);
				}

				// itemFactura
				System.out.println("Detalle: fecha " + lecturaBaja.getFecha() + ", Localizado en: "
						+ lecturaBaja.getMedidor().getDomicilioMedidor());
				System.out.println("Total: " + total);
				System.out.println("precioUnitario: " + precioUnitario);
				System.out.println("cantidad: " + cantidad);
				System.out.println("unidad: " + unidad);
				System.out.println("nroMedidor: " + lecturaBaja.getMedidor().getNroSerie());
				System.out.println("Tarifa -> " + abmTarifa.traer(lecturaBaja));
				System.out.println("Lectura -> " + lecturaBaja);

			}

			if (lectura instanceof AltaDemanda) {
				AltaDemanda lecturaAlta = (AltaDemanda) lectura;
				int consumo = lecturaAlta.getConsumoHorasPico();

				// System.out.println(consumo + " ");
				System.out.println(lecturaAlta);

				System.out.println(abmTarifa.traer(lecturaAlta));
			}

			// abm.agregarItemFactura(precioUnitario, consumo, "$/mes", lectura);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}