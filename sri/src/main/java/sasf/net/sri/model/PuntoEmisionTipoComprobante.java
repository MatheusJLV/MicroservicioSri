package sasf.net.sri.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class PuntoEmisionTipoComprobante {
	private @Id @GeneratedValue int id;
	@NotNull
	private int sriTipCoCodigo;
	@NotNull
	private int secuenciaValorInicial;
	@NotNull
	private int secuenciaIncremento;
	@NotNull
	@NotBlank
	private String secuenciaCiclica;
	private int secuenciaValorActual;
	
	private String estado;
	private Date fechaEstado;
	private String observacionEstado;
	
	private int usuarioIngreso;
	private Date fechaIngreso;
	private String ubicacionIngreso;
	private int usuarioModificacion;
	private Date fechaModificacion;
	private String ubicacionModificacion;
	@NotNull
	private int agePunEmAgeLicencCodigo;
	@NotNull
	private int agePunEmAgeSucursCodigo;
	@NotNull
	private  int agePunEmCodigo;
	
	
	
	public PuntoEmisionTipoComprobante() {
		super();
	}

	public PuntoEmisionTipoComprobante(int sriTipCoCodigo, String observacionEstado) {
		super();
		this.sriTipCoCodigo = sriTipCoCodigo;
		this.observacionEstado = observacionEstado;
		this.estado="A";
		this.secuenciaCiclica="S";
	}

	public PuntoEmisionTipoComprobante(int sriTipCoCodigo, int secuenciaValorInicial, int secuenciaIncremento,
			String secuenciaCiclica, int secuenciaValorActual, String estado, Date fechaEstado,
			String observacionEstado, int usuarioIngreso, Date fechaIngreso, String ubicacionIngreso,
			int usuarioModificacion, Date fechaModificacion, String ubicacionModificacion, int agePunEmAgeLicencCodigo,
			int agePunEmAgeSucursCodigo, int agePunEmCodigo) {
		super();
		this.sriTipCoCodigo = sriTipCoCodigo;
		this.secuenciaValorInicial = secuenciaValorInicial;
		this.secuenciaIncremento = secuenciaIncremento;
		this.secuenciaCiclica = secuenciaCiclica;
		this.secuenciaValorActual = secuenciaValorActual;
		this.estado = estado;
		this.fechaEstado = fechaEstado;
		this.observacionEstado = observacionEstado;
		this.usuarioIngreso = usuarioIngreso;
		this.fechaIngreso = fechaIngreso;
		this.ubicacionIngreso = ubicacionIngreso;
		this.usuarioModificacion = usuarioModificacion;
		this.fechaModificacion = fechaModificacion;
		this.ubicacionModificacion = ubicacionModificacion;
		this.agePunEmAgeLicencCodigo = agePunEmAgeLicencCodigo;
		this.agePunEmAgeSucursCodigo = agePunEmAgeSucursCodigo;
		this.agePunEmCodigo = agePunEmCodigo;
	}

	public int getSriTipCoCodigo() {
		return sriTipCoCodigo;
	}

	public void setSriTipCoCodigo(int sriTipCoCodigo) {
		this.sriTipCoCodigo = sriTipCoCodigo;
	}

	public int getSecuenciaValorInicial() {
		return secuenciaValorInicial;
	}

	public void setSecuenciaValorInicial(int secuenciaValorInicial) {
		this.secuenciaValorInicial = secuenciaValorInicial;
	}

	public int getSecuenciaIncremento() {
		return secuenciaIncremento;
	}

	public void setSecuenciaIncremento(int secuenciaIncremento) {
		this.secuenciaIncremento = secuenciaIncremento;
	}

	public String getSecuenciaCiclica() {
		return secuenciaCiclica;
	}

	public void setSecuenciaCiclica(String secuenciaCiclica) {
		this.secuenciaCiclica = secuenciaCiclica;
	}

	public int getSecuenciaValorActual() {
		return secuenciaValorActual;
	}

	public void setSecuenciaValorActual(int secuenciaValorActual) {
		this.secuenciaValorActual = secuenciaValorActual;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaEstado() {
		return fechaEstado;
	}

	public void setFechaEstado(Date fechaEstado) {
		this.fechaEstado = fechaEstado;
	}

	public String getObservacionEstado() {
		return observacionEstado;
	}

	public void setObservacionEstado(String observacionEstado) {
		this.observacionEstado = observacionEstado;
	}

	public int getUsuarioIngreso() {
		return usuarioIngreso;
	}

	public void setUsuarioIngreso(int usuarioIngreso) {
		this.usuarioIngreso = usuarioIngreso;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getUbicacionIngreso() {
		return ubicacionIngreso;
	}

	public void setUbicacionIngreso(String ubicacionIngreso) {
		this.ubicacionIngreso = ubicacionIngreso;
	}

	public int getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(int usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUbicacionModificacion() {
		return ubicacionModificacion;
	}

	public void setUbicacionModificacion(String ubicacionModificacion) {
		this.ubicacionModificacion = ubicacionModificacion;
	}

	public int getAgePunEmAgeLicencCodigo() {
		return agePunEmAgeLicencCodigo;
	}

	public void setAgePunEmAgeLicencCodigo(int agePunEmAgeLicencCodigo) {
		this.agePunEmAgeLicencCodigo = agePunEmAgeLicencCodigo;
	}

	public int getAgePunEmAgeSucursCodigo() {
		return agePunEmAgeSucursCodigo;
	}

	public void setAgePunEmAgeSucursCodigo(int agePunEmAgeSucursCodigo) {
		this.agePunEmAgeSucursCodigo = agePunEmAgeSucursCodigo;
	}

	public int getAgePunEmCodigo() {
		return agePunEmCodigo;
	}

	public void setAgePunEmCodigo(int agePunEmCodigo) {
		this.agePunEmCodigo = agePunEmCodigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agePunEmAgeLicencCodigo;
		result = prime * result + agePunEmAgeSucursCodigo;
		result = prime * result + agePunEmCodigo;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaEstado == null) ? 0 : fechaEstado.hashCode());
		result = prime * result + ((fechaIngreso == null) ? 0 : fechaIngreso.hashCode());
		result = prime * result + ((fechaModificacion == null) ? 0 : fechaModificacion.hashCode());
		result = prime * result + ((observacionEstado == null) ? 0 : observacionEstado.hashCode());
		result = prime * result + ((secuenciaCiclica == null) ? 0 : secuenciaCiclica.hashCode());
		result = prime * result + secuenciaIncremento;
		result = prime * result + secuenciaValorActual;
		result = prime * result + secuenciaValorInicial;
		result = prime * result + sriTipCoCodigo;
		result = prime * result + ((ubicacionIngreso == null) ? 0 : ubicacionIngreso.hashCode());
		result = prime * result + ((ubicacionModificacion == null) ? 0 : ubicacionModificacion.hashCode());
		result = prime * result + usuarioIngreso;
		result = prime * result + usuarioModificacion;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PuntoEmisionTipoComprobante other = (PuntoEmisionTipoComprobante) obj;
		if (agePunEmAgeLicencCodigo != other.agePunEmAgeLicencCodigo)
			return false;
		if (agePunEmAgeSucursCodigo != other.agePunEmAgeSucursCodigo)
			return false;
		if (agePunEmCodigo != other.agePunEmCodigo)
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fechaEstado == null) {
			if (other.fechaEstado != null)
				return false;
		} else if (!fechaEstado.equals(other.fechaEstado))
			return false;
		if (fechaIngreso == null) {
			if (other.fechaIngreso != null)
				return false;
		} else if (!fechaIngreso.equals(other.fechaIngreso))
			return false;
		if (fechaModificacion == null) {
			if (other.fechaModificacion != null)
				return false;
		} else if (!fechaModificacion.equals(other.fechaModificacion))
			return false;
		if (observacionEstado == null) {
			if (other.observacionEstado != null)
				return false;
		} else if (!observacionEstado.equals(other.observacionEstado))
			return false;
		if (secuenciaCiclica == null) {
			if (other.secuenciaCiclica != null)
				return false;
		} else if (!secuenciaCiclica.equals(other.secuenciaCiclica))
			return false;
		if (secuenciaIncremento != other.secuenciaIncremento)
			return false;
		if (secuenciaValorActual != other.secuenciaValorActual)
			return false;
		if (secuenciaValorInicial != other.secuenciaValorInicial)
			return false;
		if (sriTipCoCodigo != other.sriTipCoCodigo)
			return false;
		if (ubicacionIngreso == null) {
			if (other.ubicacionIngreso != null)
				return false;
		} else if (!ubicacionIngreso.equals(other.ubicacionIngreso))
			return false;
		if (ubicacionModificacion == null) {
			if (other.ubicacionModificacion != null)
				return false;
		} else if (!ubicacionModificacion.equals(other.ubicacionModificacion))
			return false;
		if (usuarioIngreso != other.usuarioIngreso)
			return false;
		if (usuarioModificacion != other.usuarioModificacion)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PuntoEmisionTipoComprobante [sriTipCoCodigo=" + sriTipCoCodigo + ", secuenciaValorInicial="
				+ secuenciaValorInicial + ", secuenciaIncremento=" + secuenciaIncremento + ", secuenciaCiclica="
				+ secuenciaCiclica + ", secuenciaValorActual=" + secuenciaValorActual + ", estado=" + estado
				+ ", fechaEstado=" + fechaEstado + ", observacionEstado=" + observacionEstado + ", usuarioIngreso="
				+ usuarioIngreso + ", fechaIngreso=" + fechaIngreso + ", ubicacionIngreso=" + ubicacionIngreso
				+ ", usuarioModificacion=" + usuarioModificacion + ", fechaModificacion=" + fechaModificacion
				+ ", ubicacionModificacion=" + ubicacionModificacion + ", agePunEmAgeLicencCodigo="
				+ agePunEmAgeLicencCodigo + ", agePunEmAgeSucursCodigo=" + agePunEmAgeSucursCodigo + ", agePunEmCodigo="
				+ agePunEmCodigo + "]";
	}
	
	
}
