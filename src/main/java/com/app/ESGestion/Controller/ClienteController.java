package com.app.ESGestion.Controller;

import com.app.ESGestion.Model.Cliente;
import com.app.ESGestion.Model.Profesional;
import com.app.ESGestion.Service.IClienteService;
import com.app.ESGestion.Service.IProfesionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;
    @Autowired
    private IProfesionalService profesionalService;

    @GetMapping("/traer")
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @PostMapping("/crear")
    public String createCliente(@RequestBody Cliente cliente, @RequestParam Long idProfesional) {
        Profesional profesional = profesionalService.findProfesional(idProfesional);
        if (profesional == null) {
            return "No se pudo encontrar el profesional con el ID proporcionado.";
        }
        cliente.setProfesional(profesional);
        clienteService.saveCliente(cliente);
        return "Cliente creado y vinculado al profesional correctamente.";
    }

    @DeleteMapping("/borrar/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return "Se borró al cliente correctamente!";
    }

    @PutMapping("/editar/{id}")
    public Cliente editCliente(@PathVariable Long id,
                               @RequestParam(required = false, name = "nombreCli") String nombreCli,
                               @RequestParam(required = false, name = "domicilioCli") String domicilioCli,
                               @RequestParam(required = false, name = "numCli") String numCli,
                               @RequestParam(required = false, name = "emailCli") String emailCli) {
        clienteService.updateCliente(id, nombreCli, domicilioCli, numCli, emailCli);
        return clienteService.findCliente(id);
    }
}
