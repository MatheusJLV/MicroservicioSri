package sasf.net.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sasf.net.sri.model.ImpuestoTarifa;

public interface ImpuestoTarifaRepository extends JpaRepository<ImpuestoTarifa, Integer> {
	@Query("SELECT a FROM ImpuestoTarifa a "
			+ "where a.estado=:A "
			+ "or a.estado=:I ")
	public List<ImpuestoTarifa> encontrarPorEstado();
}