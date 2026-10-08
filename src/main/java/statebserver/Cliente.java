package statebserver;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void acompanhar(Encomenda encomenda) {
        encomenda.addObserver(this);
    }

    public void update(Observable encomenda, Object arg1) {
        this.ultimaNotificacao = this.nome + ", atualização na " + encomenda.toString();
    }

}