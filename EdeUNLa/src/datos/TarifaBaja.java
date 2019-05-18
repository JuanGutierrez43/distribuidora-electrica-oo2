package datos;

import java.util.Set;

public class TarifaBaja extends Tarifa {

	private Set<DetalleBaja> lstDetalle;

	public TarifaBaja() {
	}

	public TarifaBaja(Set<DetalleBaja> lstDetalle) {
		super();
		this.lstDetalle = lstDetalle;
	}

	public Set<DetalleBaja> getLstDetalle() {
		return lstDetalle;
	}

	public void setLstDetalle(Set<DetalleBaja> lstDetalle) {
		this.lstDetalle = lstDetalle;
	}

	@Override
	public String toString() {
		return "TarifaBaja [lstDetalle=" + lstDetalle + "]";
	}

	
}
