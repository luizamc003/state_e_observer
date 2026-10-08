package statebserver;

public class EncomendaEstadoCancelado extends EncomendaEstado {

    private EncomendaEstadoCancelado() {};
    private static EncomendaEstadoCancelado instance = new EncomendaEstadoCancelado();
    public static EncomendaEstadoCancelado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Compra cancelada";
    }



}