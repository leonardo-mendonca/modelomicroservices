package br.com.leonardo.rest;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hsqldb.error.Error;
import org.springframework.web.client.RestTemplate;

@Named
@Path("/")
public class VendaRest {

	private static long id = 1;

	@Inject
	private RestTemplate restTemplate;

	@GET
	@Path("venda")
	@Produces(MediaType.APPLICATION_JSON)
	public Venda submitOrder(@QueryParam("idCustomer") long idCustomer,
			@QueryParam("idProduct") long idProduct,
			@QueryParam("amount") long amount) {

		Venda venda = new Venda();

		try {
			Cliente cliente = restTemplate.getForObject("http://localhost:8081/cliente?id={id}", Cliente.class, idCustomer);
			Produto produto = restTemplate.getForObject("http://localhost:8080/produto?id={id}", Produto.class, idProduct);

			venda.setCustomer(cliente);
			venda.setProduct(produto);
			venda.setId(id);
			venda.setAmount(amount);
			venda.setOrderDate(new Date());

			id++;

			
		} catch (Exception e) {
			venda.setMessage("Um ou mais dos serviços envolvidos não está(ão) disponível(is)!");
			System.out.println("Um ou mais dos serviços envolvidos não está(ão) disponível(is)!");
		}
		
		return venda;
		
	}
}
