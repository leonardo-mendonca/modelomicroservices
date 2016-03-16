package br.gov.rj.seplag.gau.status.sistema.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Named
@Path("/")
public class StatusSistemaRest {

	private static List<StatusSistema> statusSistemas = new ArrayList<StatusSistema>();

	static {

		StatusSistema statusSistema1 = new StatusSistema();
		statusSistema1.setId(1);
		statusSistema1.setNome("Status 1");
		
		StatusSistema statusSistema2 = new StatusSistema();
		statusSistema2.setId(2);
		statusSistema2.setNome("Status 2");

		StatusSistema statusSistema3 = new StatusSistema();
		statusSistema3.setId(3);
		statusSistema3.setNome("Status 3");
		
		StatusSistema statusSistema4 = new StatusSistema();
		statusSistema4.setId(4);
		statusSistema4.setNome("Status 4");
		
		StatusSistema statusSistema5 = new StatusSistema();
		statusSistema5.setId(5);
		statusSistema5.setNome("Status 5");

		statusSistemas.add(statusSistema1);
		statusSistemas.add(statusSistema2);
		statusSistemas.add(statusSistema3);
		statusSistemas.add(statusSistema4);
		statusSistemas.add(statusSistema5);
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<StatusSistema> getStatusSistemas() {
		return statusSistemas;
	}

	@GET
	@Path("statussistema")
	@Produces(MediaType.APPLICATION_JSON)
	public StatusSistema getStatusSistema(@QueryParam("id") long id) {

		StatusSistema ss = null;

		for (StatusSistema s : statusSistemas) {

			if (s.getId() == id)
				ss = s;

		}

		return ss;
	}
}
