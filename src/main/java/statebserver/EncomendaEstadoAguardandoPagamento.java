package statebserver;

public class EncomendaEstadoAguardandoPagamento extends EncomendaEstado {

    private EncomendaEstadoAguardandoPagamento() {};
    private static EncomendaEstadoAguardandoPagamento instance = new EncomendaEstadoAguardandoPagamento();
    public static EncomendaEstadoAguardandoPagamento getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Aguardando Pagamento";
    }

    public boolean pagar(Encomenda encomenda) {
        encomenda.setEstado(EncomendaEstadoPago.getInstance());
        return true;
    }

    public boolean cancelar(Encomenda encomenda) {
        encomenda.setEstado(EncomendaEstadoCancelado.getInstance());
        return true;
    }
}