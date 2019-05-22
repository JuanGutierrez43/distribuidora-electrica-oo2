package test;

import datos.TarifaBaja;
import negocio.DetalleBajaABM;
import negocio.TarifaABM;

public class TestAgregarDetalleBaja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			DetalleBajaABM abm = DetalleBajaABM.getInstance();
			TarifaABM abmTarifa = TarifaABM.getInstance();
			
			TarifaBaja t1r1 = (TarifaBaja)abmTarifa.traer(1);
			abm.agregarDetalleBaja(t1r1, "Cargo Fijo", "$/mes", 0, 150, 32.82);
			abm.agregarDetalleBaja(t1r1, "Cargo Variable", "$/kWh", 0, 150, 2.653);

			TarifaBaja t1r2 = (TarifaBaja)abmTarifa.traer(2);
			abm.agregarDetalleBaja(t1r2, "Cargo Fijo", "$/mes", 151, 325, 56.11);
			abm.agregarDetalleBaja(t1r2, "Cargo Variable", "$/kWh", 151, 325, 2.651);
			
			TarifaBaja t1r3 = (TarifaBaja)abmTarifa.traer(3);
			abm.agregarDetalleBaja(t1r3, "Cargo Fijo", "$/mes", 326, 400, 91.73);
			abm.agregarDetalleBaja(t1r3, "Cargo Variable", "$/kWh", 326, 400, 2.705);
			
			TarifaBaja t1r4 = (TarifaBaja)abmTarifa.traer(4);
			abm.agregarDetalleBaja(t1r4, "Cargo Fijo", "$/mes", 401, 450, 107.34);
			abm.agregarDetalleBaja(t1r4, "Cargo Variable", "$/kWh", 401, 450, 2.785);
			
			TarifaBaja t1r5 = (TarifaBaja)abmTarifa.traer(5);
			abm.agregarDetalleBaja(t1r5, "Cargo Fijo", "$/mes", 451, 500, 161.66);
			abm.agregarDetalleBaja(t1r5, "Cargo Variable", "$/kWh", 451, 500, 2.864);
			
			TarifaBaja t1r6 = (TarifaBaja)abmTarifa.traer(6);
			abm.agregarDetalleBaja(t1r6, "Cargo Fijo", "$/mes", 501, 600, 316.00);
			abm.agregarDetalleBaja(t1r6, "Cargo Variable", "$/kWh", 501, 600, 2.918);
			
			TarifaBaja t1r7 = (TarifaBaja)abmTarifa.traer(7);
			abm.agregarDetalleBaja(t1r7, "Cargo Fijo", "$/mes", 601, 700, 850.24);
			abm.agregarDetalleBaja(t1r7, "Cargo Variable", "$/kWh", 601, 700, 3.309);
			
			TarifaBaja t1r8 = (TarifaBaja)abmTarifa.traer(8);
			abm.agregarDetalleBaja(t1r8, "Cargo Fijo", "$/mes", 701, 1400, 1203.64);
			abm.agregarDetalleBaja(t1r8, "Cargo Variable", "$/kWh", 701, 1400, 3.411);
			
			TarifaBaja t1r9 = (TarifaBaja)abmTarifa.traer(9);
			abm.agregarDetalleBaja(t1r9, "Cargo Fijo", "$/mes", 1400, 999999999, 1442.88);
			abm.agregarDetalleBaja(t1r9, "Cargo Variable", "$/kWh", 1400, 999999999, 3.437);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}