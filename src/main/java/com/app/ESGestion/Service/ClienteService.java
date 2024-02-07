package com.app.ESGestion.Service;

import com.app.ESGestion.Model.Cliente;
import com.app.ESGestion.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ClienteService implements IClienteService {
    @Autowired
    private ClienteRepository clienteRepo;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {
        return clienteRepo.findById(id).orElse(null);
    }

    @Override
    public void updateCliente(Long id, String nombreCli, String domicilioCli, String numCli, String emailCli) {
        Cliente existingCliente = clienteRepo.findById(id).orElse(null);
        if (existingCliente != null) {
            existingCliente.setNombreCli(nombreCli);
            existingCliente.setDomicilioCli(domicilioCli);
            existingCliente.setNumCli(numCli);
            existingCliente.setEmailCli(emailCli);
            clienteRepo.save(existingCliente);
        }
    }
}
