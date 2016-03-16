package br.gov.rj.seplag.gau.sistema.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.web.client.RestTemplate;

@Named
@Path("/")
public class SistemaRest {

	private static long id = 1;

	@Inject
	private RestTemplate restTemplate;

	@GET
	@Path("sistema")
	@Produces(MediaType.APPLICATION_JSON)
	public Sistema submitOrder(@QueryParam("idTipoSistema") long idTipoSistema,
			@QueryParam("idStatusSistema") long idStatusSistema,
			@QueryParam("nome") String nome) {

		Sistema sistema = new Sistema();

		try {
			TipoSistema tipoSistema = restTemplate.getForObject("http://localhost:8082/tiposistema?id={id}", TipoSistema.class, idTipoSistema);
			StatusSistema statusSistema = restTemplate.getForObject("http://localhost:8081/statussistema?id={id}", StatusSistema.class, idStatusSistema);

			
			sistema.setTipoSistema(tipoSistema);
			sistema.setStatusSistema(statusSistema);
			sistema.setId(id);
			sistema.setNome(nome);

			id++;

			
		} catch (Exception e) {
			sistema.setMessage("Um ou mais dos serviços envolvidos não está(ão) disponível(is)!");
			System.out.println("Um ou mais dos serviços envolvidos não está(ão) disponível(is)!");
		}
		
		return sistema;
		
	}
}
