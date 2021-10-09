package co.edu.unbosque.ciclo3back.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.ciclo3back.dao.ClientesDAO;
import co.edu.unbosque.ciclo3back.model.Clientes;

@RestController //esta es una clase REST
@RequestMapping("clientes")
public class ClientesAPI {
	
	@Autowired //inyecta la dependencia de todos los métodos del JPA para usuarioDAO
	private ClientesDAO clientesDAO;
	
	@PostMapping("/crear")//Request convierte en un objeto Java desde un JSon
	public void guardar(@RequestBody Clientes clientes) {
		clientesDAO.save(clientes);
	}
	
	@GetMapping("/consultar")
	public List<Clientes> listar(){
		return clientesDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		clientesDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Clientes clientes) {
		clientesDAO.save(clientes);
	}
}