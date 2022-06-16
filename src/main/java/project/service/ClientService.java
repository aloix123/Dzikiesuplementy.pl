package project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.Client;
import project.repository.ClientRepository;


@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public void saveClient(Client client) {
        repository.save(client);
    }

    public Client getById(long id) {
        return repository.getById(id);
    }

    public void deleteClient(long id) {
        repository.deleteById(id);
    }









}

