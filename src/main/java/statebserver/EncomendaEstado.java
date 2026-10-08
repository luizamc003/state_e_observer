package statebserver;


public abstract class EncomendaEstado {

    public abstract String getEstado();

    public boolean pagar(Encomenda encomenda) {
        return false;
    }

    public boolean enviar(Encomenda encomenda) {
        return false;
    }

    public boolean entregar(Encomenda encomenda) {
        return false;
    }

    public boolean cancelar(Encomenda encomenda) {
        return false;
    }
}