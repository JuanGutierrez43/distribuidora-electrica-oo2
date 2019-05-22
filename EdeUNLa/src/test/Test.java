package test;

import java.time.LocalDate;

import datos.Cliente;
import datos.Inspector;
import datos.Medidor;
import datos.TarifaBaja;
import datos.Zona;
import negocio.ClienteABM;
import negocio.DetalleBajaABM;
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

		// test2
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

		// test4
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

		// test7
		try {
			InspectorABM abm = InspectorABM.getInstance();
			abm.agregarInspector("Juan", "Gutierrez", 4014785, 114785632);
		} catch (Exception e) {
			System.out.println(e);
		}

		// test8
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

		// test9
		try {
			TarifaABM abm = TarifaABM.getInstance();
			abm.agregarTarifaAlta("BT<300kW", "BT", 300);
		} catch (Exception e) {
			System.out.println(e);
		}

		// test10
		try {
			LecturaABM abm = LecturaABM.getInstance();
			InspectorABM abmInspector = InspectorABM.getInstance();
			Inspector i = abmInspector.traer(1);
			MedidorABM abmMedidor = MedidorABM.getInstance();
			Medidor m = abmMedidor.traer(1);
			abm.agregarLecturaAltaDemanda(LocalDate.now(), i, m, 100, 200, 300);
		} catch (Exception e) {
			System.out.println(e);
		}

		// test11
		try {
			LecturaABM abm = LecturaABM.getInstance();
			InspectorABM abmInspector = InspectorABM.getInstance();
			Inspector i = abmInspector.traer(1);
			MedidorABM abmMedidor = MedidorABM.getInstance();
			Medidor m = abmMedidor.traer(1);
			abm.agregarLecturaBajaDemanda(LocalDate.now(), i, m, 500);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
