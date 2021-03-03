package sasf.net.sri2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface ErrorRepository extends JpaRepository<ErrorDetail, Long> {
	@Query("SELECT a FROM ErrorDetail a "
			+ "where a.estado=:A "
			+ "or a.estado=:I ")
	public List<ErrorDetail> encontrarPorEstado();
}