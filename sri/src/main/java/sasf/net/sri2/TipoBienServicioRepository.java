package sasf.net.sri2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface TipoBienServicioRepository extends JpaRepository<TipoBienServicio, Integer> {
	@Query("SELECT a FROM TipoBienServicio a "
			+ "where a.estado=:A "
			+ "or a.estado=:I ")
	public List<TipoBienServicio> encontrarPorEstado();
}