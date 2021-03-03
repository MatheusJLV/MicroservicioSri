package sasf.net.sri2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface PuntoEmisionRepository extends JpaRepository<PuntoEmisionTipoComprobante, Integer> {
	@Query("SELECT a FROM PuntoEmisionTipoComprobante a "
			+ "where a.estado=:A "
			+ "or a.estado=:I ")
	public List<PuntoEmisionTipoComprobante> encontrarPorEstado();
}