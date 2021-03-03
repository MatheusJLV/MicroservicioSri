package sasf.net.sri2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface ImpuestoRepository extends JpaRepository<Impuesto, Integer> {
	@Query("SELECT a FROM Impuesto a "
			+ "where a.estado=:A "
			+ "or a.estado=:I ")
	public List<Impuesto> encontrarPorEstado();
}