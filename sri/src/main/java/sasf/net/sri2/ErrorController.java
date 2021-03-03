package sasf.net.sri2;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ErrorController {
	


  private final ErrorRepository repository;
  private final ComprobanteRepository repository2;
  private final PuntoEmisionRepository repository3;
  private final ImpuestoRepository repository4;
  private final ImpuestoTarifaRepository repository5;
  private final RetencionFuenteRepository repository6;
  private final RetencionFuentePorcentajeRepository repository7;

  ErrorController(ErrorRepository repository, ComprobanteRepository repository2,
		  PuntoEmisionRepository repository3, ImpuestoRepository repository4,
		  ImpuestoTarifaRepository repository5, RetencionFuenteRepository repository6
		  , RetencionFuentePorcentajeRepository repository7) {
    this.repository = repository;
    this.repository2 = repository2;
    this.repository3 = repository3;
    this.repository4 = repository4;
    this.repository5 = repository5;
    this.repository6 = repository6;
    this.repository7 = repository7;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/employees")
  List<ErrorDetail> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/employees")
  ErrorDetail newEmployee(@RequestBody ErrorDetail newEmployee) {
    return repository.save(newEmployee);
  }

  // Single item
  
  @GetMapping("/employees/{id}")
  ErrorDetail one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new ErrorNotFoundException(id));
  }
  
  @GetMapping("/sri")
  List<ErrorDetail> getErrorPorEstados(@RequestParam(required = false) Long codigo, 
		  @RequestParam(required = false) String descripcion,
		  @RequestParam(required = false) String posibleSolucion) {
	  List<ErrorDetail> listado=repository.findAll();
	  List<ErrorDetail> listado2=new ArrayList<ErrorDetail>();
	  for(ErrorDetail error:listado) {
		  if("A".equals(error.getEstado())||"I".equals(error.getEstado())) {
			  listado2.add(error);
		  }
	  }
	  
	  Sri2Application.Log.info("Codigo recibido: "+codigo);
	  
	  if(codigo!=null) {
		  listado=listado2;
		  listado2=new ArrayList<ErrorDetail>();
		  
		  for(ErrorDetail error:listado) {
			  Sri2Application.Log.info("Codigo analizado: "+error.getCodigo());
			  if(codigo==(error.getCodigo())) {
				  listado2.add(error);
			  }
		  }
	  }
	  
	  Sri2Application.Log.info("Descripcion recibida: "+descripcion);
	  if(descripcion!=null) {
		  listado=listado2;
		  listado2=new ArrayList<ErrorDetail>();
		  for(ErrorDetail error:listado) {
			  Sri2Application.Log.info("descripcion analizada: "+error.getDescripcion());
			  if(descripcion.equals(error.getDescripcion())) {
				  listado2.add(error);
			  }
		  }
	  }
	  
	  Sri2Application.Log.info("posibleSolucion recibida: "+posibleSolucion);
	  if(posibleSolucion!=null) {
		  listado=listado2;
		  listado2=new ArrayList<ErrorDetail>();
		  for(ErrorDetail error:listado) {
			  Sri2Application.Log.info("descripcion analizada: "+error.getPosibleSolucion());
			  if(posibleSolucion.equals(error.getPosibleSolucion())) {
				  listado2.add(error);
			  }
		  }
	  }
	  
	  return listado2;
      
  }
  
  @PostMapping("/sri")
  public void newErrorDetail(@RequestBody ErrorDetail newError) {
	  Sri2Application.Log.info("Error recibido: "+newError);
	  if(newError.getDescripcion()!=null && newError.getDescripcion()!=""
			  && newError.getPosibleSolucion()!=null && newError.getPosibleSolucion()!=""
			  && ("S".equals(newError.getTieneReenvio())||"N".equals(newError.getTieneReenvio()))) {
		  repository.save(newError);
	  }
    
  }
  @PostMapping("/varios")
  public void newErrorDetailVarios(@RequestBody List<ErrorDetail> listado) {
	  for(ErrorDetail newError: listado) {
		  Sri2Application.Log.info("Error recibido: "+newError);
		  if(newError.getDescripcion()!=null && newError.getDescripcion()!=""
				  && newError.getPosibleSolucion()!=null && newError.getPosibleSolucion()!=""
				  && ("S".equals(newError.getTieneReenvio())||"N".equals(newError.getTieneReenvio()))) {
			  repository.save(newError);
		  }
	  }
	  
    
  }
  
  @PutMapping("/sri")
  public void ReplaceErrorDetail(@RequestBody ErrorDetail newError) {
	  ErrorDetail error = repository.findById(newError.getCodigo())
      .orElseThrow(() -> new ErrorNotFoundException(newError.getCodigo()));
	  //desc posible sol tiene envio tiempo envio estado fecha estado tiempo estado obs estado
	  error.setDescripcion(newError.getDescripcion());
	  error.setPosibleSolucion(newError.getPosibleSolucion());
	  error.setTieneReenvio(newError.getTieneReenvio());
	  error.setTiempoReenvio(newError.getTiempoReenvio());
	  error.setFechaEstado(newError.getFechaEstado());
	  error.setEstado(newError.getEstado());
	  error.setObservacionEstado(newError.getObservacionEstado());
	  repository.save(error);

    
  }
  
  @PutMapping("/varios")
  public void ReplaceVariosErrorDetail(@RequestBody List<ErrorDetail> listado) {
	  for(ErrorDetail newError: listado) {
		  ErrorDetail error = repository.findById(newError.getCodigo())
			      .orElseThrow(() -> new ErrorNotFoundException(newError.getCodigo()));
				  //desc posible sol tiene envio tiempo envio estado fecha estado tiempo estado obs estado
		  error.setDescripcion(newError.getDescripcion());
		  error.setPosibleSolucion(newError.getPosibleSolucion());
		  error.setTieneReenvio(newError.getTieneReenvio());
		  error.setTiempoReenvio(newError.getTiempoReenvio());
		  error.setFechaEstado(newError.getFechaEstado());
		  error.setEstado(newError.getEstado());
		  error.setObservacionEstado(newError.getObservacionEstado());
		  repository.save(error);
	  }
  }
  
  @GetMapping("/tipoComprobante")
  List<TipoComprobante> getComprobantePorEstados(@RequestParam(required = false) Integer codigo, 
		  @RequestParam(required = false) Integer codigoInstitucionControl,
		  @RequestParam(required = false) String descripcion) {
	  List<TipoComprobante> listado=repository2.findAll();
	  List<TipoComprobante> listado2=new ArrayList<TipoComprobante>();
	  for(TipoComprobante error:listado) {
		  if("A".equals(error.getEstado())||"I".equals(error.getEstado())) {
			  listado2.add(error);
		  }
	  }
	  
	  Sri2Application.Log.info("comprobante recibido: "+codigo);
	  
	  if(codigo!=null) {
		  listado=listado2;
		  listado2=new ArrayList<TipoComprobante>();
		  
		  for(TipoComprobante error:listado) {
			  Sri2Application.Log.info("Codigo analizado: "+error.getCodigo());
			  if(codigo==(error.getCodigo())) {
				  listado2.add(error);
			  }
		  }
	  }
	  
	  Sri2Application.Log.info("Descripcion recibida: "+descripcion);
	  if(descripcion!=null) {
		  listado=listado2;
		  listado2=new ArrayList<TipoComprobante>();
		  for(TipoComprobante error:listado) {
			  Sri2Application.Log.info("descripcion analizada: "+error.getDescripcion());
			  if(descripcion.equals(error.getDescripcion())) {
				  listado2.add(error);
			  }
		  }
	  }
	  
	  Sri2Application.Log.info("posibleSolucion recibida: "+codigoInstitucionControl);
	  if(codigoInstitucionControl!=null) {
		  listado=listado2;
		  listado2=new ArrayList<TipoComprobante>();
		  for(TipoComprobante error:listado) {
			  Sri2Application.Log.info("cod insitut analizada: "+error.getCodigoInstitucionControl());
			  if(codigoInstitucionControl.equals(error.getCodigoInstitucionControl())) {
				  listado2.add(error);
			  }
		  }
	  }
	  
	  return listado2;
      
  }
  
  @PostMapping("/tipoComprobante")
  public void newTipoComprobante(@RequestBody TipoComprobante newComprobante) {
	  Sri2Application.Log.info("Comprobante recibido: "+newComprobante);
	  if(newComprobante.getDescripcion()!=null && newComprobante.getDescripcion()!=""
			  && newComprobante.getCodigoInstitucionControl()!=0
			  ) {
		  repository2.save(newComprobante);
	  }
    
  }
  
  @PostMapping("/tipoComprobante/varios")
  public void newComprobantesVarios(@RequestBody List<TipoComprobante> listado) {
	  for(TipoComprobante newComprobante: listado) {
		  Sri2Application.Log.info("Comprobante recibido: "+newComprobante);
		  if(newComprobante.getDescripcion()!=null && newComprobante.getDescripcion()!=""
				  && newComprobante.getCodigoInstitucionControl()!=0
				  ) {
			  repository2.save(newComprobante);
		  }
	  }
	  
    
  }
  
  
  @PutMapping("/tipoComprobante")
  public void ReplaceComprobante(@RequestBody TipoComprobante newComprobante) {
	  TipoComprobante tipoComprobante = repository2.findById(newComprobante.getCodigo())
      .orElseThrow(() -> new ComprobanteNotFoundException(newComprobante.getCodigo()));
	  tipoComprobante.setDescripcion(newComprobante.getDescripcion());
	  tipoComprobante.setCodigoInstitucionControl(newComprobante.getCodigoInstitucionControl());
	  tipoComprobante.setObservacionEstado(newComprobante.getObservacionEstado());
	  tipoComprobante.setFechaEstado(newComprobante.getFechaEstado());
	  tipoComprobante.setEstado(newComprobante.getEstado());
	  tipoComprobante.setObservacionEstado(newComprobante.getObservacionEstado());
	  repository2.save(tipoComprobante);

    
  }
  
  @PutMapping("/tipoComprobante/varios")
  public void ReplaceVariosComprobante(@RequestBody List<TipoComprobante> listado) {
	  for(TipoComprobante newComprobante: listado) {
		  TipoComprobante comprobante = repository2.findById(newComprobante.getCodigo())
			      .orElseThrow(() -> new ComprobanteNotFoundException(newComprobante.getCodigo()));
		  comprobante.setDescripcion(newComprobante.getDescripcion());
		  comprobante.setCodigoInstitucionControl(newComprobante.getCodigoInstitucionControl());
		  comprobante.setObservacionEstado(newComprobante.getObservacionEstado());
		  comprobante.setFechaEstado(newComprobante.getFechaEstado());
		  comprobante.setEstado(newComprobante.getEstado());
		  comprobante.setObservacionEstado(newComprobante.getObservacionEstado());
		  repository2.save(comprobante);
	  }
  }
  
  @GetMapping("/ptoEmisionTipoComprobante")
  List<PuntoEmisionTipoComprobante> getPtoEmisionPorEstados(@RequestParam(required = false) Integer sriTipCoCodigo, 
		  @RequestParam(required = false) Integer agePunEmCodigo,
		  @RequestParam(required = false) Integer agePunEmAgeSucursCodigo) {
	  List<PuntoEmisionTipoComprobante> listado=repository3.findAll();
	  List<PuntoEmisionTipoComprobante> listado2=new ArrayList<PuntoEmisionTipoComprobante>();
	  for(PuntoEmisionTipoComprobante error:listado) {
		  if("A".equals(error.getEstado())||"I".equals(error.getEstado())) {
			  listado2.add(error);
		  }
	  }
	  
	  Sri2Application.Log.info("tipo codigo recibido: "+sriTipCoCodigo);
	  
	  if(sriTipCoCodigo!=null) {
		  listado=listado2;
		  listado2=new ArrayList<PuntoEmisionTipoComprobante>();
		  
		  for(PuntoEmisionTipoComprobante error:listado) {
			  Sri2Application.Log.info("Codigo analizado: "+error.getSriTipCoCodigo());
			  if(sriTipCoCodigo==(error.getSriTipCoCodigo())) {
				  listado2.add(error);
			  }
		  }
	  }
	  
	  Sri2Application.Log.info("punto de emision recibido: "+agePunEmCodigo);
	  if(agePunEmCodigo!=null) {
		  listado=listado2;
		  listado2=new ArrayList<PuntoEmisionTipoComprobante>();
		  for(PuntoEmisionTipoComprobante error:listado) {
			  Sri2Application.Log.info("descripcion analizada: "+error.getAgePunEmCodigo());
			  if(agePunEmCodigo.equals(error.getAgePunEmCodigo())) {
				  listado2.add(error);
			  }
		  }
	  }
	  
	  Sri2Application.Log.info("posibleSolucion recibida: "+agePunEmAgeSucursCodigo);
	  if(agePunEmAgeSucursCodigo!=null) {
		  listado=listado2;
		  listado2=new ArrayList<PuntoEmisionTipoComprobante>();
		  for(PuntoEmisionTipoComprobante error:listado) {
			  Sri2Application.Log.info("cod insitut analizada: "+error.getAgePunEmAgeSucursCodigo());
			  if(agePunEmAgeSucursCodigo.equals(error.getAgePunEmAgeSucursCodigo())) {
				  listado2.add(error);
			  }
		  }
	  }
	  
	  return listado2;
      
  }
  
  @PostMapping("/ptoEmisionTipoComprobante")
  public void newPtoEmision(@RequestBody PuntoEmisionTipoComprobante newPtoEmision) {
	  
	  //tienen que estan invocados los age?
	  //validar los nulos, por ahora estan como ceros
	  
	  Sri2Application.Log.info("Comprobante recibido: "+newPtoEmision);
	  List<TipoComprobante> tiposComprobantes=repository2.findAll();
	  Set<Integer> existentes = new HashSet<Integer>();
	  for(TipoComprobante item:tiposComprobantes) {
		  existentes.add(item.getCodigo());
	  }
	  if(newPtoEmision.getSriTipCoCodigo()!=0 && existentes.contains(newPtoEmision.getSriTipCoCodigo()) &&
			  ("S".equals(newPtoEmision.getSecuenciaCiclica())||"N".equals(newPtoEmision.getSecuenciaCiclica()))
			  && newPtoEmision.getSecuenciaValorInicial()!=0
			  && newPtoEmision.getSecuenciaIncremento()!=0
			  && newPtoEmision.getSecuenciaValorActual()!=0
			  && newPtoEmision.getAgePunEmAgeLicencCodigo()!=0
			  && newPtoEmision.getAgePunEmAgeSucursCodigo()!=0
			  && newPtoEmision.getAgePunEmCodigo()!=0
			  ) {
		  repository3.save(newPtoEmision);
	  }
    
  }
  
  @PostMapping("/ptoEmisionTipoComprobante/varios")
  public void newPtoEmisionVarios(@RequestBody List<PuntoEmisionTipoComprobante> listado) {
	  
	  //tienen que estan invocados los age?
	  //validar los nulos, por ahora estan como ceros
	  
	  List<TipoComprobante> tiposComprobantes=repository2.findAll();
	  Set<Integer> existentes = new HashSet<Integer>();
	  for(TipoComprobante item:tiposComprobantes) {
		  existentes.add(item.getCodigo());
	  }
	  for(PuntoEmisionTipoComprobante newComprobante: listado) {
		  Sri2Application.Log.info("Comprobante recibido: "+newComprobante);
		  if(newComprobante.getSriTipCoCodigo()!=0 && existentes.contains(newComprobante.getSriTipCoCodigo()) &&
				  ("S".equals(newComprobante.getSecuenciaCiclica())||"N".equals(newComprobante.getSecuenciaCiclica()))
				  && newComprobante.getSecuenciaValorInicial()!=0
				  && newComprobante.getSecuenciaIncremento()!=0
				  && newComprobante.getSecuenciaValorActual()!=0
				  && newComprobante.getAgePunEmAgeLicencCodigo()!=0
				  && newComprobante.getAgePunEmAgeSucursCodigo()!=0
				  && newComprobante.getAgePunEmCodigo()!=0
				  ) {
			  repository3.save(newComprobante);
		  }
	  }
  }
  
  @PutMapping("/ptoEmisionTipoComprobante")
  public void ReplacePtoEmision(@RequestBody PuntoEmisionTipoComprobante newPtoEmision) {
	  PuntoEmisionTipoComprobante ptoComprobante = repository3.findById(newPtoEmision.getAgePunEmCodigo())
      .orElseThrow(() -> new PuntoEmisionNotFoundException(newPtoEmision.getAgePunEmCodigo()));
	  ptoComprobante.setSecuenciaIncremento(newPtoEmision.getSecuenciaIncremento());
	  
	  //validar s o n
	  ptoComprobante.setSecuenciaCiclica(newPtoEmision.getSecuenciaCiclica());
	  
	  ptoComprobante.setEstado(newPtoEmision.getEstado());
	  ptoComprobante.setFechaEstado(newPtoEmision.getFechaEstado());
	  ptoComprobante.setObservacionEstado(newPtoEmision.getObservacionEstado());
	  repository3.save(ptoComprobante);
    
  }
  
  @PutMapping("/ptoEmisionTipoComprobante/varios")
  public void ReplacePtoEmisionVarios(@RequestBody List<PuntoEmisionTipoComprobante> listado) {
	  for(PuntoEmisionTipoComprobante newPtoEmision: listado) {
		  PuntoEmisionTipoComprobante ptoComprobante = repository3.findById(newPtoEmision.getAgePunEmCodigo())
			      .orElseThrow(() -> new PuntoEmisionNotFoundException(newPtoEmision.getAgePunEmCodigo()));
				  ptoComprobante.setSecuenciaIncremento(newPtoEmision.getSecuenciaIncremento());
				  
				  //validar s o n
				  ptoComprobante.setSecuenciaCiclica(newPtoEmision.getSecuenciaCiclica());
				  
				  ptoComprobante.setEstado(newPtoEmision.getEstado());
				  ptoComprobante.setFechaEstado(newPtoEmision.getFechaEstado());
				  ptoComprobante.setObservacionEstado(newPtoEmision.getObservacionEstado());
				  repository3.save(ptoComprobante);
	  }
	  
  }

  
@GetMapping("/impuesto")
  List<Impuesto> getImpuestoPorEstados(@RequestParam(required = false) Integer codigo, 
		  @RequestParam(required = false) Integer codigoInstitucionControl,
		  @RequestParam(required = false) String descripcion) {
	  List<Impuesto> listado=repository4.findAll();
	  List<Impuesto> listado2=new ArrayList<Impuesto>();
	  for(Impuesto impuesto:listado) {
		  if("A".equals(impuesto.getEstado())||"I".equals(impuesto.getEstado())) {
			  listado2.add(impuesto);
		  }
	  }
	  
	  Sri2Application.Log.info("impuesto recibido: "+codigo);
	  
	  if(codigo!=null) {
		  listado=listado2;
		  listado2=new ArrayList<Impuesto>();
		  
		  for(Impuesto impuesto:listado) {
			  Sri2Application.Log.info("Codigo analizado: "+impuesto.getCodigo());
			  if(codigo==(impuesto.getCodigo())) {
				  listado2.add(impuesto);
			  }
		  }
	  }
	  
	  Sri2Application.Log.info("Descripcion recibida: "+descripcion);
	  if(descripcion!=null) {
		  listado=listado2;
		  listado2=new ArrayList<Impuesto>();
		  for(Impuesto impuesto:listado) {
			  Sri2Application.Log.info("descripcion analizada: "+impuesto.getDescripcion());
			  if(descripcion.equals(impuesto.getDescripcion())) {
				  listado2.add(impuesto);
			  }
		  }
	  }
	  
	  Sri2Application.Log.info("institucion recibida: "+codigoInstitucionControl);
	  if(codigoInstitucionControl!=null) {
		  listado=listado2;
		  listado2=new ArrayList<Impuesto>();
		  for(Impuesto impuesto:listado) {
			  Sri2Application.Log.info("cod insitut analizada: "+impuesto.getCodigoInstitucionControl());
			  if(codigoInstitucionControl.equals(impuesto.getCodigoInstitucionControl())) {
				  listado2.add(impuesto);
			  }
		  }
	  }
	  
	  return listado2;
      
  }
  
  @PostMapping("/impuesto")
  public void newImpuesto(@RequestBody Impuesto newImpuesto) {
	  Sri2Application.Log.info("Comprobante recibido: "+newImpuesto);
	  if(newImpuesto.getDescripcion()!=null && newImpuesto.getDescripcion()!=""
			  && newImpuesto.getCodigoInstitucionControl()!=0
			  ) {
		  repository4.save(newImpuesto);
	  }
  }
  
  @PostMapping("/impuesto/varios")
  public void newImpuestoVarios(@RequestBody List<Impuesto> listado) {
	  for(Impuesto newComprobante: listado) {
		  Sri2Application.Log.info("Comprobante recibido: "+newComprobante);
		  if(newComprobante.getDescripcion()!=null && newComprobante.getDescripcion()!=""
				  && newComprobante.getCodigoInstitucionControl()!=0
				  ) {
			  repository4.save(newComprobante);
		  }
	  }
	  
    
  }
  
  
  @PutMapping("/impuesto")
  public void ReplaceImpuesto(@RequestBody Impuesto newImpuesto) {
	  Impuesto impueto = repository4.findById(newImpuesto.getCodigo())
      .orElseThrow(() -> new ImpuestoNotFoundException(newImpuesto.getCodigo()));
	  impueto.setDescripcion(newImpuesto.getDescripcion());
	  impueto.setCodigoInstitucionControl(newImpuesto.getCodigoInstitucionControl());
	  impueto.setObservacionEstado(newImpuesto.getObservacionEstado());
	  impueto.setFechaEstado(newImpuesto.getFechaEstado());
	  impueto.setEstado(newImpuesto.getEstado());
	  repository4.save(impueto);

    
  }
  
  @PutMapping("/impuesto/varios")
  public void ReplaceVariosImpuesto(@RequestBody List<Impuesto> listado) {
	  for(Impuesto newImpuesto: listado) {
		  Impuesto comprobante = repository4.findById(newImpuesto.getCodigo())
			      .orElseThrow(() -> new ImpuestoNotFoundException(newImpuesto.getCodigo()));
		  comprobante.setDescripcion(newImpuesto.getDescripcion());
		  comprobante.setCodigoInstitucionControl(newImpuesto.getCodigoInstitucionControl());
		  comprobante.setObservacionEstado(newImpuesto.getObservacionEstado());
		  comprobante.setFechaEstado(newImpuesto.getFechaEstado());
		  comprobante.setEstado(newImpuesto.getEstado());
		  comprobante.setObservacionEstado(newImpuesto.getObservacionEstado());
		  repository4.save(comprobante);
	  }
  }
  @GetMapping("/impuestoTarifa/{codigoImpuesto}/{fecha}")
  List<ImpuestoTarifa> getImpuestoTarifaPorEstados(@RequestParam(required = false) Integer codigo, 
		  @RequestParam(required = false) Integer codigoInstitucionControl,
		  @RequestParam(required = false) String descripcion,
		  @PathVariable int codigoImpuesto) {
	  List<ImpuestoTarifa> listado=repository5.findAll();
	  List<ImpuestoTarifa> listado2=new ArrayList<ImpuestoTarifa>();
	  for(ImpuestoTarifa impuestoTarifa:listado) {
		  if("A".equals(impuestoTarifa.getEstado())||"I".equals(impuestoTarifa.getEstado())) {
			  listado2.add(impuestoTarifa);
		  }
	  }
	  
	  Sri2Application.Log.info("codigo impuesto recibido: "+codigoImpuesto);
	  
	  if(codigoImpuesto!=0) {
		  listado=listado2;
		  listado2=new ArrayList<ImpuestoTarifa>();
		  
		  for(ImpuestoTarifa impuestoTarifa:listado) {
			  Sri2Application.Log.info("Codigo analizado: "+impuestoTarifa.getSriImpuesCodigo());
			  if(codigoImpuesto==(impuestoTarifa.getSriImpuesCodigo())) {
				  listado2.add(impuestoTarifa);
			  }
		  }
	  }
	  
	  Sri2Application.Log.info("impuesto recibido: "+codigo);
	  
	  if(codigo!=null) {
		  listado=listado2;
		  listado2=new ArrayList<ImpuestoTarifa>();
		  
		  for(ImpuestoTarifa impuestoTarifa:listado) {
			  Sri2Application.Log.info("Codigo analizado: "+impuestoTarifa.getCodigo());
			  if(codigo==(impuestoTarifa.getCodigo())) {
				  listado2.add(impuestoTarifa);
			  }
		  }
	  }
	  
	  Sri2Application.Log.info("Descripcion recibida: "+descripcion);
	  if(descripcion!=null) {
		  listado=listado2;
		  listado2=new ArrayList<ImpuestoTarifa>();
		  for(ImpuestoTarifa impuestoTarifa:listado) {
			  Sri2Application.Log.info("descripcion analizada: "+impuestoTarifa.getDescripcion());
			  if(descripcion.equals(impuestoTarifa.getDescripcion())) {
				  listado2.add(impuestoTarifa);
			  }
		  }
	  }
	  
	  Sri2Application.Log.info("institucion recibida: "+codigoInstitucionControl);
	  if(codigoInstitucionControl!=null) {
		  listado=listado2;
		  listado2=new ArrayList<ImpuestoTarifa>();
		  for(ImpuestoTarifa impuestoTarifa:listado) {
			  Sri2Application.Log.info("cod insitut analizada: "+impuestoTarifa.getCodigoInstitucionControl());
			  if(codigoInstitucionControl.equals(impuestoTarifa.getCodigoInstitucionControl())) {
				  listado2.add(impuestoTarifa);
			  }
		  }
	  }
	  
	  return listado2;
      
  }
  
  @PostMapping("/impuestoTarifa")
  public List<ImpuestoTarifa> newImpuestoTarifa(@RequestBody ImpuestoTarifa newImpuestoTarifa) {
	  //validar fecha, sri codimp, porcentaje, ce cada, valor, fecha desde, hasta
	  Sri2Application.Log.info("Impuesto tarifa recibido: "+newImpuestoTarifa);
	  List<ImpuestoTarifa> listado=repository5.findAll();
	  Date refSuperior,refInferior;
	  
	  boolean aceptado=true;
	  if(newImpuestoTarifa.getFechaDesde()!=null &&
			  newImpuestoTarifa.getFechaHasta()!=null) {
		  for (int i = 0; i<listado.size(); i=i+1) {
			  refSuperior=listado.get(i).getFechaHasta();
			  refInferior=listado.get(i).getFechaDesde();
			  aceptado=aceptado&& ((newImpuestoTarifa.getFechaDesde()).compareTo(refInferior)*
					  (newImpuestoTarifa.getFechaDesde()).compareTo(refSuperior)>0) &&
					  ((newImpuestoTarifa.getFechaHasta()).compareTo(refInferior)*
							  (newImpuestoTarifa.getFechaHasta()).compareTo(refSuperior)>0);
		  }
	  }
	  
	  
	  if(newImpuestoTarifa.getDescripcion()!=null && newImpuestoTarifa.getDescripcion()!=""
			  && newImpuestoTarifa.getCodigoInstitucionControl()!=0 &&
			  newImpuestoTarifa.getFechaDesde()!=null &&
			  newImpuestoTarifa.getFechaHasta()!=null &&
			  newImpuestoTarifa.getValor()!=0 &&
			  newImpuestoTarifa.getDeCada()!=0 &&
			  newImpuestoTarifa.getPorcentaje()!=0 &&
			  newImpuestoTarifa.getSriImpuesCodigo()!=0 &&
			  aceptado
			  ) {
		  
		  repository5.save(newImpuestoTarifa);
	  }
	  return repository5.findAll();
  }
  
  @PostMapping("/impuestoTarifa/varios")
  public List<ImpuestoTarifa> newImpuestoTarifa(@RequestBody List<ImpuestoTarifa> lista) {
	  //validar fecha, sri codimp, porcentaje, ce cada, valor, fecha desde, hasta
	  List<ImpuestoTarifa> listado;
	  for(ImpuestoTarifa newImpuestoTarifa:lista) {
		  Sri2Application.Log.info("Impuesto tarifa recibido: "+newImpuestoTarifa);
		  listado=repository5.findAll();
		  Date refSuperior,refInferior;
		  
		  boolean aceptado=true;
		  if(newImpuestoTarifa.getFechaDesde()!=null &&
				  newImpuestoTarifa.getFechaHasta()!=null) {
			  for (int i = 0; i<listado.size(); i=i+1) {
				  refSuperior=listado.get(i).getFechaHasta();
				  refInferior=listado.get(i).getFechaDesde();
				  aceptado=aceptado&& ((newImpuestoTarifa.getFechaDesde()).compareTo(refInferior)*
						  (newImpuestoTarifa.getFechaDesde()).compareTo(refSuperior)>0) &&
						  ((newImpuestoTarifa.getFechaHasta()).compareTo(refInferior)*
								  (newImpuestoTarifa.getFechaHasta()).compareTo(refSuperior)>0);
			  }
		  }
		  
		  
		  if(newImpuestoTarifa.getDescripcion()!=null && newImpuestoTarifa.getDescripcion()!=""
				  && newImpuestoTarifa.getCodigoInstitucionControl()!=0 &&
				  newImpuestoTarifa.getFechaDesde()!=null &&
				  newImpuestoTarifa.getFechaHasta()!=null &&
				  newImpuestoTarifa.getValor()!=0 &&
				  newImpuestoTarifa.getDeCada()!=0 &&
				  newImpuestoTarifa.getPorcentaje()!=0 &&
				  newImpuestoTarifa.getSriImpuesCodigo()!=0 &&
				  aceptado
				  ) {
			  
			  repository5.save(newImpuestoTarifa);
		  }
	  }
	  
	  return repository5.findAll();
  }
  
  @PutMapping("/impuestoTarifa")
  public void ReplaceImpuestoTarifa(@RequestBody ImpuestoTarifa newImpuestoTarifa) {
	  ImpuestoTarifa impuestoTarifa = repository5.findById(newImpuestoTarifa.getCodigo())
      .orElseThrow(() -> new ImpuestoTarifaNotFoundException(newImpuestoTarifa.getCodigo()));
	  impuestoTarifa.setDescripcion(newImpuestoTarifa.getDescripcion());
	  impuestoTarifa.setCodigoInstitucionControl(newImpuestoTarifa.getCodigoInstitucionControl());
	  impuestoTarifa.setObservacionEstado(newImpuestoTarifa.getObservacionEstado());
	  impuestoTarifa.setFechaEstado(newImpuestoTarifa.getFechaEstado());
	  impuestoTarifa.setEstado(newImpuestoTarifa.getEstado());
	  impuestoTarifa.setFechaHasta(newImpuestoTarifa.getFechaHasta());
	  repository5.save(impuestoTarifa);
    
  }
  
  @PutMapping("/impuestoTarifa/varios")
  public void ReplaceImpuestoTarifaVarios(@RequestBody List<ImpuestoTarifa> listado) {
	  for(ImpuestoTarifa newImpuestoTarifa:listado) {
		  ImpuestoTarifa impuestoTarifa = repository5.findById(newImpuestoTarifa.getCodigo())
			      .orElseThrow(() -> new ImpuestoTarifaNotFoundException(newImpuestoTarifa.getCodigo()));
				  impuestoTarifa.setDescripcion(newImpuestoTarifa.getDescripcion());
				  impuestoTarifa.setCodigoInstitucionControl(newImpuestoTarifa.getCodigoInstitucionControl());
				  impuestoTarifa.setObservacionEstado(newImpuestoTarifa.getObservacionEstado());
				  impuestoTarifa.setFechaEstado(newImpuestoTarifa.getFechaEstado());
				  impuestoTarifa.setEstado(newImpuestoTarifa.getEstado());
				  impuestoTarifa.setFechaHasta(newImpuestoTarifa.getFechaHasta());
				  repository5.save(impuestoTarifa);
	  }
	      
  }
  
  @GetMapping("/retencionFuente")
  List<RetencionFuente> getretencionFuentePorEstados(@RequestParam(required = false) Integer codigo, 
		  @RequestParam(required = false) Integer codigoInstitucionControl,
		  @RequestParam(required = false) String descripcion) {
	  List<RetencionFuente> listado=repository6.findAll();
	  List<RetencionFuente> listado2=new ArrayList<RetencionFuente>();
	  for(RetencionFuente retencion:listado) {
		  if("A".equals(retencion.getEstado())||"I".equals(retencion.getEstado())) {
			  listado2.add(retencion);
		  }
	  }
	  
	  Sri2Application.Log.info("impuesto recibido: "+codigo);
	  
	  if(codigo!=null) {
		  listado=listado2;
		  listado2=new ArrayList<RetencionFuente>();
		  
		  for(RetencionFuente retencion:listado) {
			  Sri2Application.Log.info("Codigo analizado: "+retencion.getCodigo());
			  if(codigo==(retencion.getCodigo())) {
				  listado2.add(retencion);
			  }
		  }
	  }
	  
	  Sri2Application.Log.info("Descripcion recibida: "+descripcion);
	  if(descripcion!=null) {
		  listado=listado2;
		  listado2=new ArrayList<RetencionFuente>();
		  for(RetencionFuente retencion:listado) {
			  Sri2Application.Log.info("descripcion analizada: "+retencion.getDescripcion());
			  if(descripcion.equals(retencion.getDescripcion())) {
				  listado2.add(retencion);
			  }
		  }
	  }
	  
	  Sri2Application.Log.info("institucion recibida: "+codigoInstitucionControl);
	  if(codigoInstitucionControl!=null) {
		  listado=listado2;
		  listado2=new ArrayList<RetencionFuente>();
		  for(RetencionFuente retencion:listado) {
			  Sri2Application.Log.info("cod insitut analizada: "+retencion.getCodigoInstitucionControl());
			  if(codigoInstitucionControl.equals(retencion.getCodigoInstitucionControl())) {
				  listado2.add(retencion);
			  }
		  }
	  }
	  
	  return listado2;
      
  }
  
  
  
  @PostMapping("/retencionFuente")
  public void newRetencionFuente(@RequestBody RetencionFuente newRetencionFuente) {
	  Sri2Application.Log.info("retencion recibida: "+newRetencionFuente);
	  if(newRetencionFuente.getDescripcion()!=null && newRetencionFuente.getDescripcion()!=""
			  && newRetencionFuente.getCodigoInstitucionControl()!=0
			  ) {
		  repository6.save(newRetencionFuente);
	  }
  }
  
  @PostMapping("/retencionFuente/varios")
  public void newRetencionFuenteVarios(@RequestBody List<RetencionFuente> listado) {
	  for(RetencionFuente newRetencionFuente: listado) {
		  Sri2Application.Log.info("retencion recibida: "+newRetencionFuente);
		  if(newRetencionFuente.getDescripcion()!=null && newRetencionFuente.getDescripcion()!=""
				  && newRetencionFuente.getCodigoInstitucionControl()!=0
				  ) {
			  repository6.save(newRetencionFuente);
		  }
	  }
	  
  }
  
  @PutMapping("/retencionFuente")
  public void ReplaceRetencionFuente(@RequestBody RetencionFuente newRetencionFuente) {
	  RetencionFuente retencion = repository6.findById(newRetencionFuente.getCodigo())
      .orElseThrow(() -> new RetencionFuenteNotFoundException(newRetencionFuente.getCodigo()));
	  retencion.setDescripcion(newRetencionFuente.getDescripcion());
	  retencion.setCodigoInstitucionControl(newRetencionFuente.getCodigoInstitucionControl());
	  retencion.setObservacionEstado(newRetencionFuente.getObservacionEstado());
	  retencion.setFechaEstado(newRetencionFuente.getFechaEstado());
	  retencion.setEstado(newRetencionFuente.getEstado());
	  repository6.save(retencion);

    
  }
  
  @PutMapping("/retencionFuente/varios")
  public void ReplaceRetencionFuenteVarios(@RequestBody List<RetencionFuente> listado) {
	  for(RetencionFuente newRetencionFuente: listado) {
		  RetencionFuente retencion = repository6.findById(newRetencionFuente.getCodigo())
			      .orElseThrow(() -> new RetencionFuenteNotFoundException(newRetencionFuente.getCodigo()));
				  retencion.setDescripcion(newRetencionFuente.getDescripcion());
				  retencion.setCodigoInstitucionControl(newRetencionFuente.getCodigoInstitucionControl());
				  retencion.setObservacionEstado(newRetencionFuente.getObservacionEstado());
				  retencion.setFechaEstado(newRetencionFuente.getFechaEstado());
				  retencion.setEstado(newRetencionFuente.getEstado());
				  repository6.save(retencion);
	  }
    
  }
  
  @GetMapping("/retencionFuentePorcentaje")
  List<RetencionFuentePorcentaje> getretencionFuentePorcentajesPorEstados(@RequestParam(required = false) Integer codigo, 
		  @RequestParam(required = false) Integer codigoInstitucionControl,
		  @RequestParam(required = false) String descripcion) {
	  List<RetencionFuentePorcentaje> listado=repository7.findAll();
	  List<RetencionFuentePorcentaje> listado2=new ArrayList<RetencionFuentePorcentaje>();
	  for(RetencionFuentePorcentaje retencion:listado) {
		  if("A".equals(retencion.getEstado())||"I".equals(retencion.getEstado())) {
			  listado2.add(retencion);
		  }
	  }
	  
	  Sri2Application.Log.info("impuesto recibido: "+codigo);
	  
	  if(codigo!=null) {
		  listado=listado2;
		  listado2=new ArrayList<RetencionFuentePorcentaje>();
		  
		  for(RetencionFuentePorcentaje retencion:listado) {
			  Sri2Application.Log.info("Codigo analizado: "+retencion.getCodigo());
			  if(codigo==(retencion.getCodigo())) {
				  listado2.add(retencion);
			  }
		  }
	  }
	  
	  Sri2Application.Log.info("Descripcion recibida: "+descripcion);
	  if(descripcion!=null) {
		  listado=listado2;
		  listado2=new ArrayList<RetencionFuentePorcentaje>();
		  for(RetencionFuentePorcentaje retencion:listado) {
			  Sri2Application.Log.info("descripcion analizada: "+retencion.getDescripcion());
			  if(descripcion.equals(retencion.getDescripcion())) {
				  listado2.add(retencion);
			  }
		  }
	  }
	  
	  Sri2Application.Log.info("institucion recibida: "+codigoInstitucionControl);
	  if(codigoInstitucionControl!=null) {
		  listado=listado2;
		  listado2=new ArrayList<RetencionFuentePorcentaje>();
		  for(RetencionFuentePorcentaje retencion:listado) {
			  Sri2Application.Log.info("cod insitut analizada: "+retencion.getCodigoInstitucionControl());
			  if(codigoInstitucionControl.equals(retencion.getCodigoInstitucionControl())) {
				  listado2.add(retencion);
			  }
		  }
	  }
	  
	  return listado2;
      
  }
  
  @PostMapping("/retencionFuentePorcentaje")
  public List<RetencionFuentePorcentaje> newRetencionFuentePorcentaje(@RequestBody RetencionFuentePorcentaje newRetencionFuentePorcentaje) {
	  Sri2Application.Log.info("Retencion Fuente Porcentaje recibido: "+newRetencionFuentePorcentaje);
	  List<RetencionFuentePorcentaje> listado=repository7.findAll();
	  Date refSuperior,refInferior;
	  
	  boolean aceptado=true;
	  if(newRetencionFuentePorcentaje.getFechaDesde()!=null &&
			  newRetencionFuentePorcentaje.getFechaHasta()!=null) {
		  for (int i = 0; i<listado.size(); i=i+1) {
			  refSuperior=listado.get(i).getFechaHasta();
			  refInferior=listado.get(i).getFechaDesde();
			  aceptado=aceptado&& ((newRetencionFuentePorcentaje.getFechaDesde()).compareTo(refInferior)*
					  (newRetencionFuentePorcentaje.getFechaDesde()).compareTo(refSuperior)>0) &&
					  ((newRetencionFuentePorcentaje.getFechaHasta()).compareTo(refInferior)*
							  (newRetencionFuentePorcentaje.getFechaHasta()).compareTo(refSuperior)>0);
		  }
	  }
	  
	  
	  if(newRetencionFuentePorcentaje.getDescripcion()!=null && newRetencionFuentePorcentaje.getDescripcion()!=""
			  && newRetencionFuentePorcentaje.getCodigoInstitucionControl()!=0 &&
					  newRetencionFuentePorcentaje.getFechaDesde()!=null &&
						newRetencionFuentePorcentaje.getFechaHasta()!=null &&
					  newRetencionFuentePorcentaje.getValor()!=0 &&
						newRetencionFuentePorcentaje.getDeCada()!=0 &&
						newRetencionFuentePorcentaje.getPorcentaje()!=0 &&
						newRetencionFuentePorcentaje.getSriRetFuCodigo()!=0 &&
			  aceptado
			  ) {
		  
		  repository7.save(newRetencionFuentePorcentaje);
	  }
	  return repository7.findAll();
  }
  
  @PostMapping("/retencionFuentePorcentaje/varios")
  public List<RetencionFuentePorcentaje> newRetencionFuentePorcentajeVarios(@RequestBody List<RetencionFuentePorcentaje> lista) {
	  for (RetencionFuentePorcentaje newRetencionFuentePorcentaje:lista) {
		  Sri2Application.Log.info("Retencion Fuente Porcentaje recibido: "+newRetencionFuentePorcentaje);
		  List<RetencionFuentePorcentaje> listado=repository7.findAll();
		  Date refSuperior,refInferior;
		  
		  boolean aceptado=true;
		  if(newRetencionFuentePorcentaje.getFechaDesde()!=null &&
				  newRetencionFuentePorcentaje.getFechaHasta()!=null) {
			  for (int i = 0; i<listado.size(); i=i+1) {
				  refSuperior=listado.get(i).getFechaHasta();
				  refInferior=listado.get(i).getFechaDesde();
				  aceptado=aceptado&& ((newRetencionFuentePorcentaje.getFechaDesde()).compareTo(refInferior)*
						  (newRetencionFuentePorcentaje.getFechaDesde()).compareTo(refSuperior)>0) &&
						  ((newRetencionFuentePorcentaje.getFechaHasta()).compareTo(refInferior)*
								  (newRetencionFuentePorcentaje.getFechaHasta()).compareTo(refSuperior)>0);
			  }
		  }
		  
		  
		  if(newRetencionFuentePorcentaje.getDescripcion()!=null && newRetencionFuentePorcentaje.getDescripcion()!=""
				  && newRetencionFuentePorcentaje.getCodigoInstitucionControl()!=0 &&
						  newRetencionFuentePorcentaje.getFechaDesde()!=null &&
							newRetencionFuentePorcentaje.getFechaHasta()!=null &&
						  newRetencionFuentePorcentaje.getValor()!=0 &&
							newRetencionFuentePorcentaje.getDeCada()!=0 &&
							newRetencionFuentePorcentaje.getPorcentaje()!=0 &&
							newRetencionFuentePorcentaje.getSriRetFuCodigo()!=0 &&
				  aceptado
				  ) {
			  
			  repository7.save(newRetencionFuentePorcentaje);
		  }
	  }
	  
	  return repository7.findAll();
  }
  
  @PutMapping("/retencionFuentePorcentaje")
  public void ReplaceRetencionFuentePorcentaje(@RequestBody RetencionFuentePorcentaje newRetencionFuentePorcentaje) {
	  RetencionFuentePorcentaje retencionTarifaPorcentaje = repository7.findById(newRetencionFuentePorcentaje.getCodigo())
      .orElseThrow(() -> new ImpuestoTarifaNotFoundException(newRetencionFuentePorcentaje.getCodigo()));
	  retencionTarifaPorcentaje.setDescripcion(newRetencionFuentePorcentaje.getDescripcion());
	  retencionTarifaPorcentaje.setCodigoInstitucionControl(newRetencionFuentePorcentaje.getCodigoInstitucionControl());
	  retencionTarifaPorcentaje.setObservacionEstado(newRetencionFuentePorcentaje.getObservacionEstado());
	  retencionTarifaPorcentaje.setFechaEstado(newRetencionFuentePorcentaje.getFechaEstado());
	  retencionTarifaPorcentaje.setEstado(newRetencionFuentePorcentaje.getEstado());
	  repository7.save(retencionTarifaPorcentaje);
    
  }
  
  @PutMapping("/retencionFuentePorcentaje/varios")
  public void ReplaceRetencionFuentePorcentajeVarios(@RequestBody List<RetencionFuentePorcentaje> lista) {
	  for(RetencionFuentePorcentaje newRetencionFuentePorcentaje:lista) {
		  RetencionFuentePorcentaje retencionTarifaPorcentaje = repository7.findById(newRetencionFuentePorcentaje.getCodigo())
			      .orElseThrow(() -> new ImpuestoTarifaNotFoundException(newRetencionFuentePorcentaje.getCodigo()));
				  retencionTarifaPorcentaje.setDescripcion(newRetencionFuentePorcentaje.getDescripcion());
				  retencionTarifaPorcentaje.setCodigoInstitucionControl(newRetencionFuentePorcentaje.getCodigoInstitucionControl());
				  retencionTarifaPorcentaje.setObservacionEstado(newRetencionFuentePorcentaje.getObservacionEstado());
				  retencionTarifaPorcentaje.setFechaEstado(newRetencionFuentePorcentaje.getFechaEstado());
				  retencionTarifaPorcentaje.setEstado(newRetencionFuentePorcentaje.getEstado());
				  repository7.save(retencionTarifaPorcentaje);
	  }
	  
    
  }
  
  @PutMapping("/employees/{id}")
  ErrorDetail replaceEmployee(@RequestBody ErrorDetail newEmployee, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(employee -> {
        employee.setName(newEmployee.getName());
        employee.setRole(newEmployee.getRole());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return repository.save(newEmployee);
      });
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}