package com.app.ESGestion.Service;

import com.app.ESGestion.Model.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> getClientes();

    void saveCliente(Cliente cliente);

    void deleteCliente(Long id);

    Cliente findCliente(Long id);

    void updateCliente(Long id, String nombreCli, String domicilioCli, String numCli, String emailCli);
}
