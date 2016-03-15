package br.com.leonardo.rest;

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
public class ProdutoRest {

	private static List<Produto> produtos = new ArrayList<Produto>();

	static {

		Produto product1 = new Produto();
		product1.setId(1);
		product1.setSku("abcd1");
		product1.setDescription("Produto1");

		Produto product2 = new Produto();
		product2.setId(2);
		product2.setSku("abcd2");
		product2.setDescription("Produto2");

		Produto product3 = new Produto();
		product3.setId(3);
		product3.setSku("abcd3");
		product3.setDescription("Produto3");

		Produto product4 = new Produto();
		product4.setId(4);
		product4.setSku("abcd4");
		product4.setDescription("Produto4");

		produtos.add(product1);
		produtos.add(product2);
		produtos.add(product3);
		produtos.add(product4);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> getProdutos() {
		return produtos;
	}

	@GET
	@Path("produto")
	@Produces(MediaType.APPLICATION_JSON)
	public Produto getProduto(@QueryParam("id") long id) {

		Produto prod = null;

		for (Produto p : produtos) {

			if (p.getId() == id)
				prod = p;

		}

		return prod;
	}

}
