package br.gov.rj.seplag.gau.tipo.sistema.rest;

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
public class TipoSistemaRest {

	private static List<TipoSistema> tiposSistemas = new ArrayList<TipoSistema>();

	static {

		TipoSistema tipoSistema1 = new TipoSistema();
		tipoSistema1.setId(1);
		tipoSistema1.setNome("Tipo 1");
		
		TipoSistema tipoSistema2 = new TipoSistema();
		tipoSistema2.setId(2);
		tipoSistema2.setNome("Tipo 2");
		
		TipoSistema tipoSistema3 = new TipoSistema();
		tipoSistema3.setId(3);
		tipoSistema3.setNome("Tipo 3");
		
		TipoSistema tipoSistema4 = new TipoSistema();
		tipoSistema4.setId(4);
		tipoSistema4.setNome("Tipo 4");
		
		TipoSistema tipoSistema5 = new TipoSistema();
		tipoSistema5.setId(5);
		tipoSistema5.setNome("Tipo 5");

		tiposSistemas.add(tipoSistema1);
		tiposSistemas.add(tipoSistema2);
		tiposSistemas.add(tipoSistema3);
		tiposSistemas.add(tipoSistema4);
		tiposSistemas.add(tipoSistema5);
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoSistema> getTiposSistemas() {
		return tiposSistemas;
	}

	@GET
	@Path("tiposistema")
	@Produces(MediaType.APPLICATION_JSON)
	public TipoSistema getTipoSistema(@QueryParam("id") long id) {

		TipoSistema ts = null;

		for (TipoSistema t : tiposSistemas) {

			if (t.getId() == id)
				ts = t;

		}

		return ts;
	}
}
