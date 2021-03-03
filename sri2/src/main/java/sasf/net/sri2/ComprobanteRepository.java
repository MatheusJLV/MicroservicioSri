package sasf.net.sri2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface ComprobanteRepository extends JpaRepository<TipoComprobante, Integer> {
	@Query("SELECT a FROM TipoComprobante a "
			+ "where a.estado=:A "
			+ "or a.estado=:I ")
	public List<TipoComprobante> encontrarPorEstado();
}