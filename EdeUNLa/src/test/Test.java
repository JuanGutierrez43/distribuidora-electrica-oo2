package test;

import java.time.LocalDate;

import datos.Cliente;
import datos.Factura;
import datos.Inspector;
import datos.Medidor;
import datos.TarifaAlta;
import datos.TarifaBaja;
import datos.Zona;
import negocio.ClienteABM;
import negocio.DetalleAltaABM;
import negocio.DetalleBajaABM;
import negocio.FacturaABM;
import negocio.InspectorABM;
import negocio.LecturaABM;
import negocio.MedidorABM;
import negocio.TarifaABM;
import negocio.ZonaABM;

public class Test {
	// test de victor . test todo en uno
	public static void main(String[] args) {

		// test1
		try {
			ZonaABM abm = ZonaABM.getInstance();
			abm.agregarZona("Buenos Aires");
		} catch (Exception e) {
			System.out.println(e);
		}

		// test2.1
		try {
			ClienteABM abm = ClienteABM.getInstance();
			abm.agregarPersonaFisica("Antonio Mentruyt 1443", "leotta010@hotmail.com", 42883850, 1138819260, 40423033,
					"Ezequiel", "Leotta");
		} catch (Exception e) {
			System.out.println(e);
		}
				
		// test3
		try {
			ClienteABM abm = ClienteABM.getInstance();
			abm.agregarPersonaJuridica("Pienovi 104", "andreani@hotmail.com", 428957, 113896547, "204257893",
					"Andreani");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// test2.3 victor
		try {
			ClienteABM abm = ClienteABM.getInstance();
			abm.agregarPersonaFisica("C832", "josevictoribanez@hotmail.com", 42711936, 1141966105, 36068006, "Victor",
					"Ibañez");
		} catch (Exception e) {
			System.out.println(e);
		}

		// test4.1
		try {
			MedidorABM abmMedidor = MedidorABM.getInstance();
			ClienteABM abmCliente = ClienteABM.getInstance();
			Cliente c = abmCliente.traer(1);
			ZonaABM abmZona = ZonaABM.getInstance();
			Zona z = abmZona.traer(1);
			abmMedidor.agregarMedidor(c, 1, "Antonio Mentruyt 1443", z);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// test4.2
		try {
			MedidorABM abmMedidor = MedidorABM.getInstance();
			ClienteABM abmCliente = ClienteABM.getInstance();
			Cliente c = abmCliente.traer(2);
			ZonaABM abmZona = ZonaABM.getInstance();
			Zona z = abmZona.traer(1);
			abmMedidor.agregarMedidor(c, 2, "Antonio Mentruyt 1443", "AT", z);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// test4.3 victor
		try {
			MedidorABM abmMedidor = MedidorABM.getInstance();
			ClienteABM abmCliente = ClienteABM.getInstance();
			Cliente c = abmCliente.traer(3);
			ZonaABM abmZona = ZonaABM.getInstance();
			Zona z = abmZona.traer(1);
			abmMedidor.agregarMedidor(c, 3, "C832", z);
		} catch (Exception e) {
			System.out.println(e);
		}

		// test5 Juan
		try {
			InspectorABM abm = InspectorABM.getInstance();
			abm.agregarInspector("Juan", "Gutierrez", 4014785, 114785632);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// test6
		try {
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
		} catch (Exception e) {
			System.out.println(e);
		}

		// test6.2
		try {
			DetalleBajaABM abm = DetalleBajaABM.getInstance();
			TarifaABM abmTarifa = TarifaABM.getInstance();

			TarifaBaja t1r1 = (TarifaBaja) abmTarifa.traer(1);
			abm.agregarDetalleBaja(t1r1, "Cargo Fijo", "$/mes", 0, 150, 32.82);
			abm.agregarDetalleBaja(t1r1, "Cargo Variable", "$/kWh", 0, 150, 2.653);

			TarifaBaja t1r2 = (TarifaBaja) abmTarifa.traer(2);
			abm.agregarDetalleBaja(t1r2, "Cargo Fijo", "$/mes", 151, 325, 56.11);
			abm.agregarDetalleBaja(t1r2, "Cargo Variable", "$/kWh", 151, 325, 2.651);

			TarifaBaja t1r3 = (TarifaBaja) abmTarifa.traer(3);
			abm.agregarDetalleBaja(t1r3, "Cargo Fijo", "$/mes", 326, 400, 91.73);
			abm.agregarDetalleBaja(t1r3, "Cargo Variable", "$/kWh", 326, 400, 2.705);

			TarifaBaja t1r4 = (TarifaBaja) abmTarifa.traer(4);
			abm.agregarDetalleBaja(t1r4, "Cargo Fijo", "$/mes", 401, 450, 107.34);
			abm.agregarDetalleBaja(t1r4, "Cargo Variable", "$/kWh", 401, 450, 2.785);

			TarifaBaja t1r5 = (TarifaBaja) abmTarifa.traer(5);
			abm.agregarDetalleBaja(t1r5, "Cargo Fijo", "$/mes", 451, 500, 161.66);
			abm.agregarDetalleBaja(t1r5, "Cargo Variable", "$/kWh", 451, 500, 2.864);

			TarifaBaja t1r6 = (TarifaBaja) abmTarifa.traer(6);
			abm.agregarDetalleBaja(t1r6, "Cargo Fijo", "$/mes", 501, 600, 316.00);
			abm.agregarDetalleBaja(t1r6, "Cargo Variable", "$/kWh", 501, 600, 2.918);

			TarifaBaja t1r7 = (TarifaBaja) abmTarifa.traer(7);
			abm.agregarDetalleBaja(t1r7, "Cargo Fijo", "$/mes", 601, 700, 850.24);
			abm.agregarDetalleBaja(t1r7, "Cargo Variable", "$/kWh", 601, 700, 3.309);

			TarifaBaja t1r8 = (TarifaBaja) abmTarifa.traer(8);
			abm.agregarDetalleBaja(t1r8, "Cargo Fijo", "$/mes", 701, 1400, 1203.64);
			abm.agregarDetalleBaja(t1r8, "Cargo Variable", "$/kWh", 701, 1400, 3.411);

			TarifaBaja t1r9 = (TarifaBaja) abmTarifa.traer(9);
			abm.agregarDetalleBaja(t1r9, "Cargo Fijo", "$/mes", 1400, 999999999, 1442.88);
			abm.agregarDetalleBaja(t1r9, "Cargo Variable", "$/kWh", 1400, 999999999, 3.437);
		} catch (Exception e) {
			System.out.println(e);
		}

		// test7
		try {
			TarifaABM abm = TarifaABM.getInstance();
			abm.agregarTarifaAlta("BT<300kW", "BT", 300);
			abm.agregarTarifaAlta("BT>300kW", "BT", 999999999);
			abm.agregarTarifaAlta("MT<300kW", "MT", 300);
			abm.agregarTarifaAlta("MT>300kW", "MT", 999999999);
			abm.agregarTarifaAlta("AT<300kW", "AT", 300);
			abm.agregarTarifaAlta("AT>300kW", "AT", 999999999);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// test7.2
		try{
			DetalleAltaABM abm = DetalleAltaABM.getInstance();
			TarifaABM abmTarifa = TarifaABM.getInstance();
			
			TarifaAlta t1btMenor = (TarifaAlta)abmTarifa.traer(10);
			abm.agregarDetalleAlta(t1btMenor, "Cargo fijo", "$/mes", false, 3226.41);
			abm.agregarDetalleAlta(t1btMenor, "Cargo variable pico", "$/kWh", false, 2.260);
			abm.agregarDetalleAlta(t1btMenor, "Cargo variable resto", "$/kWh", false, 2.160);
			abm.agregarDetalleAlta(t1btMenor, "Cargo variable valle", "$/kWh", false, 2.061);
			
			TarifaAlta t1btMayor = (TarifaAlta)abmTarifa.traer(11);
			abm.agregarDetalleAlta(t1btMayor, "Cargo fijo", "$/mes", true, 3226.41);
			abm.agregarDetalleAlta(t1btMayor, "Cargo variable pico", "$/kWh", true, 3.286);
			abm.agregarDetalleAlta(t1btMayor, "Cargo variable resto", "$/kWh", true, 3.138);
			abm.agregarDetalleAlta(t1btMayor, "Cargo variable valle", "$/kWh", true, 2.990);
			
			TarifaAlta t1mtMenor = (TarifaAlta)abmTarifa.traer(12);
			abm.agregarDetalleAlta(t1mtMenor, "Cargo fijo", "$/mes", false, 3226.09);
			abm.agregarDetalleAlta(t1mtMenor, "Cargo variable pico", "$/kWh", false, 2.148);
			abm.agregarDetalleAlta(t1mtMenor, "Cargo variable resto", "$/kWh", false, 2.053);
			abm.agregarDetalleAlta(t1mtMenor, "Cargo variable valle", "$/kWh", false, 1.959);
			
			TarifaAlta t1mtMayor = (TarifaAlta)abmTarifa.traer(13);
			abm.agregarDetalleAlta(t1mtMayor, "Cargo fijo", "$/mes", true, 3226.09);
			abm.agregarDetalleAlta(t1mtMayor, "Cargo variable pico", "$/kWh", true, 3.123);
			abm.agregarDetalleAlta(t1mtMayor, "Cargo variable resto", "$/kWh", true, 2.983);
			abm.agregarDetalleAlta(t1mtMayor, "Cargo variable valle", "$/kWh", true, 2.841);
			
			TarifaAlta t1atMenor = (TarifaAlta)abmTarifa.traer(14);
			abm.agregarDetalleAlta(t1atMenor, "Cargo fijo", "$/mes", false, 3224.11);
			abm.agregarDetalleAlta(t1atMenor, "Cargo variable pico", "$/kWh", false, 2.060);
			abm.agregarDetalleAlta(t1atMenor, "Cargo variable resto", "$/kWh", false, 1.969);
			abm.agregarDetalleAlta(t1atMenor, "Cargo variable valle", "$/kWh", false, 1.879);
			
			TarifaAlta t1atMayor = (TarifaAlta)abmTarifa.traer(15);
			abm.agregarDetalleAlta(t1atMayor, "Cargo fijo", "$/mes", true, 3224.11);
			abm.agregarDetalleAlta(t1atMayor, "Cargo variable pico", "$/kWh", true, 2.995);
			abm.agregarDetalleAlta(t1atMayor, "Cargo variable resto", "$/kWh", true, 2.860);
			abm.agregarDetalleAlta(t1atMayor, "Cargo variable valle", "$/kWh", true, 2.725);
		}catch(Exception e){
			System.out.println(e);
		}

		
		// test10.1 eze2
		try {
			LecturaABM abm = LecturaABM.getInstance();
			InspectorABM abmInspector = InspectorABM.getInstance();
			Inspector i = abmInspector.traer(1);
			MedidorABM abmMedidor = MedidorABM.getInstance();
			Medidor m = abmMedidor.traer(2);
			abm.agregarLecturaAltaDemanda(LocalDate.of(2018, 10, 10), i, m, 100, 200, 300);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// test10.2 eze2
		try {
			LecturaABM abm = LecturaABM.getInstance();
			InspectorABM abmInspector = InspectorABM.getInstance();
			Inspector i = abmInspector.traer(1);
			MedidorABM abmMedidor = MedidorABM.getInstance();
			Medidor m = abmMedidor.traer(2);
			abm.agregarLecturaAltaDemanda(LocalDate.of(2018, 12, 10), i, m, 250, 400, 500);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// test10.3 eze2
		try {
			LecturaABM abm = LecturaABM.getInstance();
			InspectorABM abmInspector = InspectorABM.getInstance();
			Inspector i = abmInspector.traer(1);
			MedidorABM abmMedidor = MedidorABM.getInstance();
			Medidor m = abmMedidor.traer(2);
			abm.agregarLecturaAltaDemanda(LocalDate.of(2019, 2, 18), i, m, 400, 622, 759);
		} catch (Exception e) {
			System.out.println(e);
		}

		
		// test11.1 eze1
		try {
			LecturaABM abm = LecturaABM.getInstance();
			InspectorABM abmInspector = InspectorABM.getInstance();
			Inspector i = abmInspector.traer(1);
			MedidorABM abmMedidor = MedidorABM.getInstance();
			Medidor m = abmMedidor.traer(1);
			abm.agregarLecturaBajaDemanda(LocalDate.of(2018, 10, 10), i, m, 500);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// test11.2 eze1
		try {
			LecturaABM abm = LecturaABM.getInstance();
			InspectorABM abmInspector = InspectorABM.getInstance();
			Inspector i = abmInspector.traer(1);
			MedidorABM abmMedidor = MedidorABM.getInstance();
			Medidor m = abmMedidor.traer(1);
			abm.agregarLecturaBajaDemanda(LocalDate.of(2018, 12, 10), i, m, 950);
		} catch (Exception e) {
			System.out.println(e);
		}
			
		// test11.3 eze1
		try {
			LecturaABM abm = LecturaABM.getInstance();
			InspectorABM abmInspector = InspectorABM.getInstance();
			Inspector i = abmInspector.traer(1);
			MedidorABM abmMedidor = MedidorABM.getInstance();
			Medidor m = abmMedidor.traer(1);
			abm.agregarLecturaBajaDemanda(LocalDate.of(2019, 2, 10), i, m, 1610);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// test12.1 victor
		try {
			LecturaABM abm = LecturaABM.getInstance();
			InspectorABM abmInspector = InspectorABM.getInstance();
			Inspector i = abmInspector.traer(1);
			MedidorABM abmMedidor = MedidorABM.getInstance();
			Medidor m = abmMedidor.traer(3);
			abm.agregarLecturaBajaDemanda(LocalDate.of(2018, 12, 10), i, m, 200);
		} catch (Exception e) {
			System.out.println(e);
		}

		// test12.1 victor
		try {
			LecturaABM abm = LecturaABM.getInstance();
			InspectorABM abmInspector = InspectorABM.getInstance();
			Inspector i = abmInspector.traer(1);
			MedidorABM abmMedidor = MedidorABM.getInstance();
			Medidor m = abmMedidor.traer(3);
			abm.agregarLecturaBajaDemanda(LocalDate.of(2019, 2, 10), i, m, 515);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		

		
		// test21.1 Factura1 eze1
		try {
			FacturaABM abmFactura = FacturaABM.getInstance();
			Factura factura = abmFactura.generarFactura(MedidorABM.getInstance().traer(1), 10, 2018);
			abmFactura.alta(factura);
		} catch (Exception e) {
			System.out.println(e);
		}

		// test21.2 Factura2 eze1
		try {
			FacturaABM abmFactura = FacturaABM.getInstance();
			Factura factura = abmFactura.generarFactura(MedidorABM.getInstance().traer(1), 12, 2018);
			abmFactura.alta(factura);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		// test20.1 Factura1 victor
		try {
			FacturaABM abmFactura = FacturaABM.getInstance();
			Factura factura = abmFactura.generarFactura(MedidorABM.getInstance().traer(3), 12, 2018);
			abmFactura.alta(factura);
		} catch (Exception e) {
			System.out.println(e);
		}

		// test20.2 Factura2 victor
		try {
			FacturaABM abmFactura = FacturaABM.getInstance();
			Factura factura = abmFactura.generarFactura(MedidorABM.getInstance().traer(3), 2, 2019);
			abmFactura.alta(factura);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		// test21.2 Factura2 eze1
		try {
			FacturaABM abmFactura = FacturaABM.getInstance();
			Factura factura = abmFactura.generarFactura(MedidorABM.getInstance().traer(1), 2, 2019);
			abmFactura.alta(factura);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// test22.1 Factura1 eze2
		try {
			FacturaABM abmFactura = FacturaABM.getInstance();
			Factura factura = abmFactura.generarFactura(MedidorABM.getInstance().traer(2), 10, 2018);
			abmFactura.alta(factura);
		} catch (Exception e) {
			System.out.println(e);
		}
		// test22.2 Factura2 eze2
		try {
			FacturaABM abmFactura = FacturaABM.getInstance();
			Factura factura = abmFactura.generarFactura(MedidorABM.getInstance().traer(2), 12, 2018);
			abmFactura.alta(factura);
		} catch (Exception e) {
			System.out.println(e);
		}
		// test22.3 Factura3 eze2
		try {
			FacturaABM abmFactura = FacturaABM.getInstance();
			Factura factura = abmFactura.generarFactura(MedidorABM.getInstance().traer(2), 2, 2019);
			abmFactura.alta(factura);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
