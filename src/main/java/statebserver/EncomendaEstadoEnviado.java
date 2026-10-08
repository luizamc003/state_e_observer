package statebserver;

public class EncomendaEstadoEnviado extends EncomendaEstado {

    private EncomendaEstadoEnviado() {};
    private static EncomendaEstadoEnviado instance = new EncomendaEstadoEnviado();
    public static EncomendaEstadoEnviado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pedido enviado";
    }


    public boolean entregar(Encomenda encomenda) {
        encomenda.setEstado(EncomendaEstadoEntregue.getInstance());
        return true;
    }
}