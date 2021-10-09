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

import co.edu.unbosque.ciclo3back.dao.ProveedoresDAO;
import co.edu.unbosque.ciclo3back.model.Proveedores;

@RestController //esta es una clase REST
@RequestMapping("proveedores")
public class ProveedoresAPI {
	
	@Autowired //inyecta la dependencia de todos los métodos del JPA para usuarioDAO
	private ProveedoresDAO proveedoresDAO;
	
	@PostMapping("/crear")//Request convierte en un objeto Java desde un JSon
	public void guardar(@RequestBody Proveedores proveedores) {
		proveedoresDAO.save(proveedores);
	}
	
	@GetMapping("/consultar")
	public List<Proveedores> listar(){
		return proveedoresDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		proveedoresDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Proveedores proveedores) {
		proveedoresDAO.save(proveedores);
	}
}