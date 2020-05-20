package br.com.loja.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.loja.business.ClienteBusiness;
import br.com.loja.entity.Cliente;

@Path("/clientes")
public class ClienteFacade {
	
	@Inject
	private ClienteBusiness clienteBusiness;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response criarCliente(Cliente cliente) {
		
		clienteBusiness.criarCliente(cliente);
		return Response.status(201).build();
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarCliente(Cliente cliente) {
		
		clienteBusiness.atualizarCliente(cliente);
		return Response.status(204).build();
		
	}
	
	@DELETE
	public Response removerCliente(Cliente cliente) {
		
		clienteBusiness.removerCliente(cliente);
		return Response.status(200).build();
		
	}
	
	@DELETE
	@Path("/{id}")
	public Response removerClientePorId(@PathParam("id") Long id) {
		
		clienteBusiness.removerClientePorId(id);
		return Response.status(200).build();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarClientes() {
		
		List<Cliente> resultList = clienteBusiness.listarClientes();
		return Response.ok(resultList).build();
		
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarClientesPorId(@PathParam("id") Long id) {
		
		Cliente cliente = clienteBusiness.listarClientesPorId(id);
		return Response.ok(cliente).build();
		
	}
}
