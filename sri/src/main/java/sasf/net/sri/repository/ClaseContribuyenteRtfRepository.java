package sasf.net.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sasf.net.sri.model.ClaseContribuyenteRtf;

public interface ClaseContribuyenteRtfRepository extends JpaRepository<ClaseContribuyenteRtf, Integer> {
	@Query("SELECT a FROM ClaseContribuyenteRtf a "
			+ "where a.estado=:A "
			+ "or a.estado=:I ")
	public List<ClaseContribuyenteRtf> encontrarPorEstado();
}