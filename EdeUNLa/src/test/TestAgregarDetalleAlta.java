package test;

import datos.TarifaAlta;
import negocio.DetalleAltaABM;
import negocio.DetalleBajaABM;
import negocio.TarifaABM;

public class TestAgregarDetalleAlta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	}
}