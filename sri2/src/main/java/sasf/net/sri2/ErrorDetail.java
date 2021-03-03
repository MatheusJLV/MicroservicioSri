package sasf.net.sri2;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class ErrorDetail {

  private @Id @GeneratedValue Long codigo;
  private String name;
  private String role;
  
  private String descripcion;
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

  ErrorDetail(String name, String role) {

    this.name = name;
    this.role = role;
    this.estado="A";
  }

  public Long getCodigo() {
	return codigo;
}

public void setCodigo(Long codigo) {
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

public Long getId() {
    return this.codigo;
  }

  public String getName() {
    return this.name;
  }

  public String getRole() {
    return this.role;
  }

  public void setId(Long id) {
    this.codigo = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof ErrorDetail))
      return false;
    ErrorDetail employee = (ErrorDetail) o;
    return Objects.equals(this.codigo, employee.codigo) && Objects.equals(this.name, employee.name)
        && Objects.equals(this.role, employee.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.codigo, this.name, this.role);
  }

@Override
public String toString() {
	return "ErrorDetail [codigo=" + codigo + ", name=" + name + ", role=" + role + ", descripcion=" + descripcion
			+ ", posibleSolucion=" + posibleSolucion + ", tieneReenvio=" + tieneReenvio + ", tiempoReenvio="
			+ tiempoReenvio + ", estado=" + estado + ", fechaEstado=" + fechaEstado + ", observacionEstado="
			+ observacionEstado + ", usuarioIngreso=" + usuarioIngreso + ", fechaIngreso=" + fechaIngreso
			+ ", ubicacionIngreso=" + ubicacionIngreso + ", usuarioModificacion=" + usuarioModificacion
			+ ", fechaModificacion=" + fechaModificacion + ", ubicacionModificacion=" + ubicacionModificacion + "]";
}

  
}