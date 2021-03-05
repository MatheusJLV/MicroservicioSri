package sasf.net.sri.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sasf.net.sri.model.ClaseContribuyenteRtf;
import sasf.net.sri.model.ErrorDetail;
import sasf.net.sri.model.Impuesto;
import sasf.net.sri.model.ImpuestoTarifa;
import sasf.net.sri.model.PuntoEmisionTipoComprobante;
import sasf.net.sri.model.RetencionFuente;
import sasf.net.sri.model.RetencionFuentePorcentaje;
import sasf.net.sri.model.TipoBienServicio;
import sasf.net.sri.model.TipoComprobante;
import sasf.net.sri.repository.ClaseContribuyenteRtfRepository;
import sasf.net.sri.repository.ComprobanteRepository;
import sasf.net.sri.repository.ErrorRepository;
import sasf.net.sri.repository.ImpuestoRepository;
import sasf.net.sri.repository.ImpuestoTarifaRepository;
import sasf.net.sri.repository.PuntoEmisionRepository;
import sasf.net.sri.repository.RetencionFuentePorcentajeRepository;
import sasf.net.sri.repository.RetencionFuenteRepository;
import sasf.net.sri.repository.TipoBienServicioRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(ErrorRepository repository,ComprobanteRepository repository2
		  ,PuntoEmisionRepository repository3,ImpuestoRepository repository4
		  ,ImpuestoTarifaRepository repository5,RetencionFuenteRepository repository6
		  ,RetencionFuentePorcentajeRepository repository7
		  ,TipoBienServicioRepository repository8, ClaseContribuyenteRtfRepository repository9
		  ) {

    return args -> {
      log.info("Preloading " + repository.save(new ErrorDetail("Bilbo Baggins", "burglar")));
      log.info("Preloading " + repository.save(new ErrorDetail("Frodo Baggins", "thief")));
      log.info("Preloading 2 " + repository2.save(new TipoComprobante(1,123,"compa 1")));
      log.info("Preloading 2 " + repository2.save(new TipoComprobante(2,1234,"compa 2")));
      log.info("Preloading 3 " + repository3.save(new PuntoEmisionTipoComprobante(1,"obs 1")));
      log.info("Preloading 3 " + repository3.save(new PuntoEmisionTipoComprobante(2,"obs 2")));
      log.info("Preloading 4 " + repository4.save(new Impuesto("imp 1")));
      log.info("Preloading 4 " + repository4.save(new Impuesto("imp 2")));
      log.info("Preloading 5 " + repository5.save(new ImpuestoTarifa(1,"imp tarif 1")));
      log.info("Preloading 5 " + repository5.save(new ImpuestoTarifa(2,"imp tarif 2")));
      log.info("Preloading 6 " + repository6.save(new RetencionFuente(1,"retencion 1")));
      log.info("Preloading 6 " + repository6.save(new RetencionFuente(2,"retencion 2")));
      log.info("Preloading 7 " + repository7.save(new RetencionFuentePorcentaje("retencion porcentaje 1")));
      log.info("Preloading 7 " + repository7.save(new RetencionFuentePorcentaje("retencion porcentaje 2")));
      log.info("Preloading 8 " + repository8.save(new TipoBienServicio("bien servicio 1")));
      log.info("Preloading 8 " + repository8.save(new TipoBienServicio("bien servicio 2")));
      log.info("Preloading 9 " + repository9.save(new ClaseContribuyenteRtf("ClaseContribuyenteRtf 1")));
      log.info("Preloading 9 " + repository9.save(new ClaseContribuyenteRtf("ClaseContribuyenteRtf 2")));
    };
  }
}