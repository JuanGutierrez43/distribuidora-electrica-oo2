package datos;

import java.util.Set;

public class TarifaAlta extends Tarifa {

	private String tensionContratada;
	private int limite;
	private Set<DetalleAlta> lstDetalle;

	public TarifaAlta() {
	}

	public TarifaAlta(String tensionContratada, int limite, Set<DetalleAlta> lstDetalle) {
		super();
		this.tensionContratada = tensionContratada;
		this.limite = limite;
		this.lstDetalle = lstDetalle;
	}

	public String getTensionContratada() {
		return tensionContratada;
	}

	public void setTensionContratada(String tensionContratada) {
		this.tensionContratada = tensionContratada;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public Set<DetalleAlta> getLstDetalle() {
		return lstDetalle;
	}

	public void setLstDetalle(Set<DetalleAlta> lstDetalle) {
		this.lstDetalle = lstDetalle;
	}

	@Override
	public String toString() {
		return "TarifaAlta [tensionContratada=" + tensionContratada + ", limite=" + limite + ", lstDetalle="
				+ lstDetalle + "]";
	}

	
}
