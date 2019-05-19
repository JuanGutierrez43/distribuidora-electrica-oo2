package test;

import java.time.LocalDate;

import datos.Inspector;
import datos.Medidor;
import negocio.InspectorABM;
import negocio.LecturaABM;
import negocio.MedidorABM;

public class TestAgregarLecturaAltaDemanda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			LecturaABM abm = LecturaABM.getInstance();
			InspectorABM abmInspector = InspectorABM.getInstance();
			Inspector i = abmInspector.traer(1);
			MedidorABM abmMedidor = MedidorABM.getInstance();
			Medidor m = abmMedidor.traer(1);
			abm.agregarLecturaAltaDemanda(LocalDate.now(), i, m, 100, 200, 300);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}