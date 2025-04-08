
package model;

import java.util.List;

public class Pedido {
    private int id;
    private int clienteId;
    private List<Integer> sabores;
    private int borda;
    private StatusPedido status;

    public Pedido(int id, int clienteId, List<Integer> sabores, int borda) {
        this.id = id;
        this.clienteId = clienteId;
        this.sabores = sabores;
        this.borda = borda;
        this.status = StatusPedido.RECEBIDO;
    }

    public int getId() { return id; }
    public int getClienteId() { return clienteId; }
    public List<Integer> getSabores() { return sabores; }
    public int getBorda() { return borda; }
    public StatusPedido getStatus() { return status; }
    public void setStatus(StatusPedido status) { this.status = status; }
}
