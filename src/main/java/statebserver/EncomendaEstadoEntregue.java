package statebserver;

public class EncomendaEstadoEntregue extends EncomendaEstado {

    private EncomendaEstadoEntregue() {};
    private static EncomendaEstadoEntregue instance = new EncomendaEstadoEntregue();
    public static EncomendaEstadoEntregue getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Encomenda entregue";
    }



}