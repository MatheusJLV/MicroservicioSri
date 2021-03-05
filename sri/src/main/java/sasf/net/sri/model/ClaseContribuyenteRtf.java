package sasf.net.sri.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClaseContribuyenteRtf {
	public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
	
	private @Id @GeneratedValue int codigo;
	
	@NotNull
	private int sriImpuesCodigo;
	@NotNull
	private int sriTipBsCodigo;
	@NotNull
	@NotBlank
	private String retiene;
	
	@NotNull
	private int porcentaje;
	@NotNull
	private int deCada;

	
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
	private int ageCkaCoRetenerDeCodigo;
	@NotNull
	private int ageCkaCoRetenerACodigo;
	
	
	
	public ClaseContribuyenteRtf(String observacionEstado) {
		super();
		this.observacionEstado = observacionEstado;
		this.estado="A";
		this.fechaIngreso=new Date();
		this.retiene="S";
		this.ageCkaCoRetenerACodigo=0;
		this.ageCkaCoRetenerACodigo=0;
	}
	public ClaseContribuyenteRtf() {
		super();
	}
	public ClaseContribuyenteRtf(int sriImpuesCodigo, int sriTipBaCodigo, String retiene, int porcentaje, int deCada,
			String estado, Date fechaEstado, String observacionEstado, int usuarioIngreso, Date fechaIngreso,
			String ubicacionIngreso, int usuarioModificacion, Date fechaModificacion, String ubicacionModificacion,
			int ageCkaCoRetenerDeCodigo, int ageCkaCoRetenerACodigo) {
		super();
		this.sriImpuesCodigo = sriImpuesCodigo;
		this.sriTipBsCodigo = sriTipBaCodigo;
		this.retiene = retiene;
		this.porcentaje = porcentaje;
		this.deCada = deCada;
		this.estado = estado;
		this.fechaEstado = fechaEstado;
		this.observacionEstado = observacionEstado;
		this.usuarioIngreso = usuarioIngreso;
		this.fechaIngreso = fechaIngreso;
		this.ubicacionIngreso = ubicacionIngreso;
		this.usuarioModificacion = usuarioModificacion;
		this.fechaModificacion = fechaModificacion;
		this.ubicacionModificacion = ubicacionModificacion;
		this.ageCkaCoRetenerDeCodigo = ageCkaCoRetenerDeCodigo;
		this.ageCkaCoRetenerACodigo = ageCkaCoRetenerACodigo;
	}
	@Override
	public String toString() {
		return "ClaseContribuyenteRtf [sriImpuesCodigo=" + sriImpuesCodigo + ", sriTipBaCodigo=" + sriTipBsCodigo
				+ ", retiene=" + retiene + ", porcentaje=" + porcentaje + ", deCada=" + deCada + ", estado=" + estado
				+ ", fechaEstado=" + fechaEstado + ", observacionEstado=" + observacionEstado + ", usuarioIngreso="
				+ usuarioIngreso + ", fechaIngreso=" + fechaIngreso + ", ubicacionIngreso=" + ubicacionIngreso
				+ ", usuarioModificacion=" + usuarioModificacion + ", fechaModificacion=" + fechaModificacion
				+ ", ubicacionModificacion=" + ubicacionModificacion + ", ageCkaCoRetenerDeCodigo="
				+ ageCkaCoRetenerDeCodigo + ", ageCkaCoRetenerACodigo=" + ageCkaCoRetenerACodigo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ageCkaCoRetenerACodigo;
		result = prime * result + ageCkaCoRetenerDeCodigo;
		result = prime * result + deCada;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaEstado == null) ? 0 : fechaEstado.hashCode());
		result = prime * result + ((fechaIngreso == null) ? 0 : fechaIngreso.hashCode());
		result = prime * result + ((fechaModificacion == null) ? 0 : fechaModificacion.hashCode());
		result = prime * result + ((observacionEstado == null) ? 0 : observacionEstado.hashCode());
		result = prime * result + porcentaje;
		result = prime * result + ((retiene == null) ? 0 : retiene.hashCode());
		result = prime * result + sriImpuesCodigo;
		result = prime * result + sriTipBsCodigo;
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
		ClaseContribuyenteRtf other = (ClaseContribuyenteRtf) obj;
		if (ageCkaCoRetenerACodigo != other.ageCkaCoRetenerACodigo)
			return false;
		if (ageCkaCoRetenerDeCodigo != other.ageCkaCoRetenerDeCodigo)
			return false;
		if (deCada != other.deCada)
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
		if (porcentaje != other.porcentaje)
			return false;
		if (retiene == null) {
			if (other.retiene != null)
				return false;
		} else if (!retiene.equals(other.retiene))
			return false;
		if (sriImpuesCodigo != other.sriImpuesCodigo)
			return false;
		if (sriTipBsCodigo != other.sriTipBsCodigo)
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
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public static SimpleDateFormat getFormatter() {
		return formatter;
	}
	public static void setFormatter(SimpleDateFormat formatter) {
		ClaseContribuyenteRtf.formatter = formatter;
	}
	public int getSriImpuesCodigo() {
		return sriImpuesCodigo;
	}
	public void setSriImpuesCodigo(int sriImpuesCodigo) {
		this.sriImpuesCodigo = sriImpuesCodigo;
	}
	public int getSriTipBsCodigo() {
		return sriTipBsCodigo;
	}
	public void setSriTipBsCodigo(int sriTipBaCodigo) {
		this.sriTipBsCodigo = sriTipBaCodigo;
	}
	public String getRetiene() {
		return retiene;
	}
	public void setRetiene(String retiene) {
		this.retiene = retiene;
	}
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	public int getDeCada() {
		return deCada;
	}
	public void setDeCada(int deCada) {
		this.deCada = deCada;
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
	public int getAgeCkaCoRetenerDeCodigo() {
		return ageCkaCoRetenerDeCodigo;
	}
	public void setAgeCkaCoRetenerDeCodigo(int ageCkaCoRetenerDeCodigo) {
		this.ageCkaCoRetenerDeCodigo = ageCkaCoRetenerDeCodigo;
	}
	public int getAgeCkaCoRetenerACodigo() {
		return ageCkaCoRetenerACodigo;
	}
	public void setAgeCkaCoRetenerACodigo(int ageCkaCoRetenerACodigo) {
		this.ageCkaCoRetenerACodigo = ageCkaCoRetenerACodigo;
	}
	
	
}
