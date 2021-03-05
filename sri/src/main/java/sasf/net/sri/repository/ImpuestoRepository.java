package sasf.net.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sasf.net.sri.model.Impuesto;

public interface ImpuestoRepository extends JpaRepository<Impuesto, Integer> {
	@Query("SELECT a FROM Impuesto a "
			+ "where a.estado=:A "
			+ "or a.estado=:I ")
	public List<Impuesto> encontrarPorEstado();
}