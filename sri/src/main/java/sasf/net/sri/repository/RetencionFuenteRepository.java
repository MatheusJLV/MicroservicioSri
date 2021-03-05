package sasf.net.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sasf.net.sri.model.RetencionFuente;

public interface RetencionFuenteRepository extends JpaRepository<RetencionFuente, Integer> {
	@Query("SELECT a FROM RetencionFuente a "
			+ "where a.estado=:A "
			+ "or a.estado=:I ")
	public List<RetencionFuente> encontrarPorEstado();
}