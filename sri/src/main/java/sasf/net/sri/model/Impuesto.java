package sasf.net.sri.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Impuesto {
	private @Id @GeneratedValue int codigo;
	@NotNull
	private int codigoInstitucionControl;
	@NotNull
	@NotBlank
	private String descripcion;
	private String estado;
	private Date fechaEstado;
	private String observacionEstado;
	
	private int usuarioIngreso;
	private Date fechaIngreso;
	private String ubicacionIngreso;
	private int usuarioModificacion;
	private Date fechaModificacion;
	private String ubicacionModificacion;
	
	
	
	public Impuesto( String descripcion) {
		super();
		this.descripcion = descripcion;
		this.estado="A";
	}

	public Impuesto() {
		super();
	}
	
	public Impuesto(int codigo, int codigoInstitucionControl, String descripcion, String estado, Date fechaEstado,
			String observacionEstado, int usuarioIngreso, Date fechaIngreso, String ubicacionIngreso,
			int usuarioModificacion, Date fechaModificacion, String ubicacionModificacion) {
		super();
		this.codigo = codigo;
		this.codigoInstitucionControl = codigoInstitucionControl;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaEstado = fechaEstado;
		this.observacionEstado = observacionEstado;
		this.usuarioIngreso = usuarioIngreso;
		this.fechaIngreso = fechaIngreso;
		this.ubicacionIngreso = ubicacionIngreso;
		this.usuarioModificacion = usuarioModificacion;
		this.fechaModificacion = fechaModificacion;
		this.ubicacionModificacion = ubicacionModificacion;
	}
	@Override
	public String toString() {
		return "Impuestos [codigo=" + codigo + ", codigoInstitucionControl=" + codigoInstitucionControl
				+ ", descripcion=" + descripcion + ", estado=" + estado + ", fechaEstado=" + fechaEstado
				+ ", observacionEstado=" + observacionEstado + ", usuarioIngreso=" + usuarioIngreso + ", fechaIngreso="
				+ fechaIngreso + ", ubicacionIngreso=" + ubicacionIngreso + ", usuarioModificacion="
				+ usuarioModificacion + ", fechaModificacion=" + fechaModificacion + ", ubicacionModificacion="
				+ ubicacionModificacion + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + codigoInstitucionControl;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaEstado == null) ? 0 : fechaEstado.hashCode());
		result = prime * result + ((fechaIngreso == null) ? 0 : fechaIngreso.hashCode());
		result = prime * result + ((fechaModificacion == null) ? 0 : fechaModificacion.hashCode());
		result = prime * result + ((observacionEstado == null) ? 0 : observacionEstado.hashCode());
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
		Impuesto other = (Impuesto) obj;
		if (codigo != other.codigo)
			return false;
		if (codigoInstitucionControl != other.codigoInstitucionControl)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
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
	public int getCodigoInstitucionControl() {
		return codigoInstitucionControl;
	}
	public void setCodigoInstitucionControl(int codigoInstitucionControl) {
		this.codigoInstitucionControl = codigoInstitucionControl;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	
	
}
