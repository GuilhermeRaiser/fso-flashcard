package br.univille.projflashcard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import br.univille.projflashcard.entity.Cliente;
import br.univille.projflashcard.service.ClienteService;

@SpringBootTest
@ContextConfiguration
@ActiveProfiles(profiles = "test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)

public class ClienteServiceTest {

    @Autowired
    private ClienteService service;

    @Test
    public void getAllClientesEmptyList(){
        var listaClientes = service.getAll();
        assertEquals(listaClientes.size(), 0);
    }

    @Test
    public void saveCliente(){
        var novoCliente = new Cliente();
        novoCliente.setNome("Gui");
        service.save(novoCliente);

        var clienteConsulta = service.getById(1);
        assertNotNull(clienteConsulta);
        assertEquals(clienteConsulta.getNome(),"Gui");
    }



}
