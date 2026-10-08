package statebserver;

import java.util.Observable;

public class Encomenda extends Observable {

    private EncomendaEstado estado;
    private String nomeEncomenda;

    public Encomenda(String nomeEncomenda) {
        this.nomeEncomenda = nomeEncomenda;
        this.estado = EncomendaEstadoAguardandoPagamento.getInstance();
    }

    public void setEstado(EncomendaEstado estado) {
        this.estado = estado;
        setChanged();        // Observer: marca que mudou
        notifyObservers();   // Observer: avisa todos os clientes
    }

    // state -> muda o estado da encomenda
    public boolean pagar()    { return estado.pagar(this); }
    public boolean enviar()   { return estado.enviar(this); }
    public boolean entregar() { return estado.entregar(this); }
    public boolean cancelar() { return estado.cancelar(this); }

    public String getNomeEstado() { return estado.getEstado(); }

    public String getNomeEncomenda(){
        return this.nomeEncomenda;
    }

    public EncomendaEstado getEstado() {
        return estado;
    }

    // estava depreciado
    @Override
    public String toString() {
        return "Encomenda{nome='" + nomeEncomenda + "', estado='" + getNomeEstado() + "'}";
    }
}