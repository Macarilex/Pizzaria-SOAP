
package dao;

import model.Pedido;
import model.StatusPedido;
import java.util.*;

public class PedidoDAO {
    private Map<Integer, Pedido> pedidos = new HashMap<>();
    private int counter = 1;

    public int adicionarPedido(Pedido pedido) {
        pedidos.put(counter, pedido);
        return counter++;
    }

    public Pedido getPedido(int id) {
        return pedidos.get(id);
    }

    public List<Pedido> listarTodos() {
        return new ArrayList<>(pedidos.values());
    }

    public void atualizarStatusAutomaticamente() {
        for (Pedido pedido : pedidos.values()) {
            StatusPedido status = pedido.getStatus();
            if (status.ordinal() < StatusPedido.values().length - 1) {
                pedido.setStatus(StatusPedido.values()[status.ordinal() + 1]);
            }
        }
    }
}
