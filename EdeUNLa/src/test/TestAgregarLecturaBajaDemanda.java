package test;

import java.time.LocalDate;

import datos.Inspector;
import datos.Medidor;
import negocio.InspectorABM;
import negocio.LecturaABM;
import negocio.MedidorABM;

public class TestAgregarLecturaBajaDemanda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			LecturaABM abm = LecturaABM.getInstance();
			InspectorABM abmInspector = InspectorABM.getInstance();
			Inspector i = abmInspector.traer(1);
			MedidorABM abmMedidor = MedidorABM.getInstance();
			Medidor m = abmMedidor.traer(1);
			abm.agregarLecturaBajaDemanda(LocalDate.now(), i, m, 500);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}