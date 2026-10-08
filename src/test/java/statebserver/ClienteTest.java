package statebserver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveNotificarUmCliente() {
        Encomenda encomenda = new Encomenda("BR123");
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(encomenda);
        encomenda.pagar();
        assertEquals("Cliente 1, atualização na Encomenda{nome='BR123', estado='Pagamento realizado'}", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Encomenda encomenda = new Encomenda("BR123");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.acompanhar(encomenda);
        cliente2.acompanhar(encomenda);
        encomenda.pagar();
        assertEquals("Cliente 1, atualização na Encomenda{nome='BR123', estado='Pagamento realizado'}", cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2, atualização na Encomenda{nome='BR123', estado='Pagamento realizado'}", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Encomenda encomenda = new Encomenda("BR123");
        Cliente cliente = new Cliente("Cliente 1");
        encomenda.pagar();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteEncomendaA() {
        Encomenda encomendaA = new Encomenda("A");
        Encomenda encomendaB = new Encomenda("B");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.acompanhar(encomendaA);
        cliente2.acompanhar(encomendaB);
        encomendaA.pagar();
        assertEquals("Cliente 1, atualização na Encomenda{nome='A', estado='Pagamento realizado'}", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}