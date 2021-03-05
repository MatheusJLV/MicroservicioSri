package sasf.net.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sasf.net.sri.model.TipoBienServicio;

public interface TipoBienServicioRepository extends JpaRepository<TipoBienServicio, Integer> {
	@Query("SELECT a FROM TipoBienServicio a "
			+ "where a.estado=:A "
			+ "or a.estado=:I ")
	public List<TipoBienServicio> encontrarPorEstado();
}