package statebserver;

public class EncomendaEstadoPago extends EncomendaEstado {

    private EncomendaEstadoPago() {};
    private static EncomendaEstadoPago instance = new EncomendaEstadoPago();
    public static EncomendaEstadoPago getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pagamento realizado";
    }

    public boolean cancelar(Encomenda encomenda) {
        encomenda.setEstado(EncomendaEstadoCancelado.getInstance());
        return true;
    }

    public boolean enviar(Encomenda encomenda) {
        encomenda.setEstado(EncomendaEstadoEnviado.getInstance());
        return true;
    }
}