package sasf.net.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sasf.net.sri.model.ErrorDetail;

public interface ErrorRepository extends JpaRepository<ErrorDetail, Integer> {
	@Query("SELECT a FROM ErrorDetail a "
			+ "where a.estado=:A "
			+ "or a.estado=:I ")
	public List<ErrorDetail> encontrarPorEstado();
}