package statebserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EncomendaTest {

    Encomenda encomenda;

    @BeforeEach
    public void setUp() {
        encomenda = new Encomenda("BR123");
    }


    @Test
    public void deveIniciarAguardandoPagamento() {
        assertEquals(EncomendaEstadoAguardandoPagamento.getInstance(), encomenda.getEstado());
    }


    @Test
    public void devePagarEncomendaAguardandoPagamento() {
        encomenda.setEstado(EncomendaEstadoAguardandoPagamento.getInstance());
        assertTrue(encomenda.pagar());
        assertEquals(EncomendaEstadoPago.getInstance(), encomenda.getEstado());
    }

    @Test
    public void naoDeveEnviarEncomendaAguardandoPagamento() {
        encomenda.setEstado(EncomendaEstadoAguardandoPagamento.getInstance());
        assertFalse(encomenda.enviar());
    }

    @Test
    public void naoDeveEntregarEncomendaAguardandoPagamento() {
        encomenda.setEstado(EncomendaEstadoAguardandoPagamento.getInstance());
        assertFalse(encomenda.entregar());
    }

    @Test
    public void deveCancelarEncomendaAguardandoPagamento() {
        encomenda.setEstado(EncomendaEstadoAguardandoPagamento.getInstance());
        assertTrue(encomenda.cancelar());
        assertEquals(EncomendaEstadoCancelado.getInstance(), encomenda.getEstado());
    }


    @Test
    public void naoDevePagarEncomendaPaga() {
        encomenda.setEstado(EncomendaEstadoPago.getInstance());
        assertFalse(encomenda.pagar());
    }

    @Test
    public void deveEnviarEncomendaPaga() {
        encomenda.setEstado(EncomendaEstadoPago.getInstance());
        assertTrue(encomenda.enviar());
        assertEquals(EncomendaEstadoEnviado.getInstance(), encomenda.getEstado());
    }

    @Test
    public void naoDeveEntregarEncomendaPaga() {
        encomenda.setEstado(EncomendaEstadoPago.getInstance());
        assertFalse(encomenda.entregar());
    }

    @Test
    public void deveCancelarEncomendaPaga() {
        encomenda.setEstado(EncomendaEstadoPago.getInstance());
        assertTrue(encomenda.cancelar());
        assertEquals(EncomendaEstadoCancelado.getInstance(), encomenda.getEstado());
    }


    @Test
    public void naoDevePagarEncomendaEnviada() {
        encomenda.setEstado(EncomendaEstadoEnviado.getInstance());
        assertFalse(encomenda.pagar());
    }

    @Test
    public void naoDeveEnviarEncomendaEnviada() {
        encomenda.setEstado(EncomendaEstadoEnviado.getInstance());
        assertFalse(encomenda.enviar());
    }

    @Test
    public void deveEntregarEncomendaEnviada() {
        encomenda.setEstado(EncomendaEstadoEnviado.getInstance());
        assertTrue(encomenda.entregar());
        assertEquals(EncomendaEstadoEntregue.getInstance(), encomenda.getEstado());
    }

    @Test
    public void naoDeveCancelarEncomendaEnviada() {
        encomenda.setEstado(EncomendaEstadoEnviado.getInstance());
        assertFalse(encomenda.cancelar());
    }

    // Encomenda entregue

    @Test
    public void naoDevePagarEncomendaEntregue() {
        encomenda.setEstado(EncomendaEstadoEntregue.getInstance());
        assertFalse(encomenda.pagar());
    }

    @Test
    public void naoDeveEnviarEncomendaEntregue() {
        encomenda.setEstado(EncomendaEstadoEntregue.getInstance());
        assertFalse(encomenda.enviar());
    }

    @Test
    public void naoDeveEntregarEncomendaEntregue() {
        encomenda.setEstado(EncomendaEstadoEntregue.getInstance());
        assertFalse(encomenda.entregar());
    }

    @Test
    public void naoDeveCancelarEncomendaEntregue() {
        encomenda.setEstado(EncomendaEstadoEntregue.getInstance());
        assertFalse(encomenda.cancelar());
    }


    @Test
    public void naoDevePagarEncomendaCancelada() {
        encomenda.setEstado(EncomendaEstadoCancelado.getInstance());
        assertFalse(encomenda.pagar());
    }

    @Test
    public void naoDeveEnviarEncomendaCancelada() {
        encomenda.setEstado(EncomendaEstadoCancelado.getInstance());
        assertFalse(encomenda.enviar());
    }

    @Test
    public void naoDeveEntregarEncomendaCancelada() {
        encomenda.setEstado(EncomendaEstadoCancelado.getInstance());
        assertFalse(encomenda.entregar());
    }

    @Test
    public void naoDeveCancelarEncomendaCancelada() {
        encomenda.setEstado(EncomendaEstadoCancelado.getInstance());
        assertFalse(encomenda.cancelar());
    }
}