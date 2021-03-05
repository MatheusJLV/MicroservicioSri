package sasf.net.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sasf.net.sri.model.RetencionFuentePorcentaje;

public interface RetencionFuentePorcentajeRepository extends JpaRepository<RetencionFuentePorcentaje, Integer> {
	@Query("SELECT a FROM RetencionFuentePorcentaje a "
			+ "where a.estado=:A "
			+ "or a.estado=:I ")
	public List<RetencionFuentePorcentaje> encontrarPorEstado();
}