package sasf.net.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sasf.net.sri.model.TipoComprobante;

public interface ComprobanteRepository extends JpaRepository<TipoComprobante, Integer> {
	@Query("SELECT a FROM TipoComprobante a "
			+ "where a.estado=:A "
			+ "or a.estado=:I ")
	public List<TipoComprobante> encontrarPorEstado();
}