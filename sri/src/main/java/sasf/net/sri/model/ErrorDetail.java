package sasf.net.sri.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class ErrorDetail {


	  private @Id @GeneratedValue int codigo;

	  
	  @NotNull
	  @NotBlank
	  private String descripcion;
	  @NotNull
	  @NotBlank
	  private String posibleSolucion;
	  private String tieneReenvio;
	  private int tiempoReenvio;
	  private String estado;
	  private Date fechaEstado;
	  private String observacionEstado;
	  private int usuarioIngreso;
	  private Date fechaIngreso;
	  private String ubicacionIngreso;
	  private int usuarioModificacion;
	  private Date fechaModificacion;
	  private String ubicacionModificacion;
	
	  ErrorDetail() {}
	
	  public ErrorDetail(String descripcion, String posibleSolucion) {
	
	    this.descripcion = descripcion;
	    this.posibleSolucion = posibleSolucion;
	    this.estado="A";
	    this.fechaIngreso=new Date();
	  }
	
	  public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getPosibleSolucion() {
		return posibleSolucion;
	}
	
	public void setPosibleSolucion(String posibleSolucion) {
		this.posibleSolucion = posibleSolucion;
	}
	
	public String getTieneReenvio() {
		return tieneReenvio;
	}
	
	public void setTieneReenvio(String tieneReenvio) {
		this.tieneReenvio = tieneReenvio;
	}
	
	public int getTiempoReenvio() {
		return tiempoReenvio;
	}
	
	public void setTiempoReenvio(int tiempoReenvio) {
		this.tiempoReenvio = tiempoReenvio;
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
	
	public int getId() {
	    return this.codigo;
	  }
	

	

	
	  public void setId(int id) {
	    this.codigo = id;
	  }
	
	
	  @Override
	  public boolean equals(Object o) {
	
	    if (this == o)
	      return true;
	    if (!(o instanceof ErrorDetail))
	      return false;
	    ErrorDetail employee = (ErrorDetail) o;
	    return Objects.equals(this.codigo, employee.codigo);
	  }
	
	  @Override
	  public int hashCode() {
	    return Objects.hash(this.codigo);
	  }
	
	@Override
	public String toString() {
		return "ErrorDetail [codigo=" + codigo +  ", descripcion=" + descripcion
				+ ", posibleSolucion=" + posibleSolucion + ", tieneReenvio=" + tieneReenvio + ", tiempoReenvio="
				+ tiempoReenvio + ", estado=" + estado + ", fechaEstado=" + fechaEstado + ", observacionEstado="
				+ observacionEstado + ", usuarioIngreso=" + usuarioIngreso + ", fechaIngreso=" + fechaIngreso
				+ ", ubicacionIngreso=" + ubicacionIngreso + ", usuarioModificacion=" + usuarioModificacion
				+ ", fechaModificacion=" + fechaModificacion + ", ubicacionModificacion=" + ubicacionModificacion + "]";
	}

  
}