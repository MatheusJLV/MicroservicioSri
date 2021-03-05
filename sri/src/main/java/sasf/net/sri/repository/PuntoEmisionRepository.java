package sasf.net.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sasf.net.sri.model.PuntoEmisionTipoComprobante;

public interface PuntoEmisionRepository extends JpaRepository<PuntoEmisionTipoComprobante, Integer> {
	@Query("SELECT a FROM PuntoEmisionTipoComprobante a "
			+ "where a.estado=:A "
			+ "or a.estado=:I ")
	public List<PuntoEmisionTipoComprobante> encontrarPorEstado();
}