package br.com.loja.business;

import java.util.List;

import javax.inject.Inject;

import br.com.loja.dao.ClienteDao;
import br.com.loja.entity.Cliente;

public class ClienteBusiness {
	
	@Inject
	ClienteDao clienteDao;

	public void criarCliente(Cliente cliente) {
		clienteDao.create(cliente);
	}

	public void atualizarCliente(Cliente cliente) {
		clienteDao.update(cliente);
	}

	public void removerCliente(Cliente cliente) {
		clienteDao.delete(cliente);
	}

	public void removerClientePorId(Long id) {
		clienteDao.delete(id);
	}

	public List<Cliente> listarClientes() {
		return clienteDao.findAll();
	}

	public Cliente listarClientesPorId(Long id) {
		return clienteDao.find(id);
	}

}
