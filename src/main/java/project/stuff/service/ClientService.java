package project.stuff.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.stuff.model.Client;
import project.stuff.repository.ClientRepository;


@Service
public abstract class ClientService {

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

    public void updateClient(long id, Client clientWithEditedData) {
        Client clientToEdit = repository.getById(id);
        clientToEdit.setId(clientWithEditedData.getId());
        clientToEdit.setAddress(clientWithEditedData.getAddress());
        clientToEdit.setBirthDate(clientWithEditedData.getBirthDate());
        clientToEdit.setCity(clientWithEditedData.getCity());
        clientToEdit.setEmail(clientWithEditedData.getEmail());
        clientToEdit.setName(clientWithEditedData.getName());
        clientToEdit.setPassword(clientWithEditedData.getPassword());
        clientToEdit.setSurname(clientWithEditedData.getSurname());
        clientToEdit.setPostalCode(clientWithEditedData.getPostalCode());
        clientToEdit.setPhoneNumber(clientWithEditedData.getPhoneNumber());
        repository.save(clientToEdit);
    }



    public Client registerClient(String name, String surname, String email, String password) {
        if (email != null && password != null && name != null && surname != null){
            Client client = new Client();
            client.setEmail(email);
            client.setPassword(password);
            client.setName(name);
            client.setSurname(surname);
            return repository.save(client);
        } else {
            return null;
        }
    }

    public Client authenticate(String email, String password){
        return repository.findByEmailAndPassword(email, password).orElse(null);
    }
}

