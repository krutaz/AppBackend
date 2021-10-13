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

import co.edu.unbosque.ciclo3back.dao.DetalleVentasDAO;
import co.edu.unbosque.ciclo3back.model.DetalleVentas;

@RestController
@RequestMapping("detalleVentas")
public class DetalleVentasAPI {
	
	@Autowired //inyecta la dependencia de todos los métodos del JPA para usuarioDAO
	private DetalleVentasDAO detalleVentasDAO;
	
	@PostMapping("/crear")//Request convierte en un objeto Java desde un JSon
	public void guardar(@RequestBody DetalleVentas detalleVentas) {
		detalleVentasDAO.save(detalleVentas);
	}
	
	@GetMapping("/consultar")
	public List<DetalleVentas> listar(){
		return detalleVentasDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		detalleVentasDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody DetalleVentas detalleVentas) {
		detalleVentasDAO.save(detalleVentas);
	}
}