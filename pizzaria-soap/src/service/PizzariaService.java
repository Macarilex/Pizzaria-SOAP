
package service;

import dao.ClienteDAO;
import dao.PedidoDAO;
import dao.PizzaDAO;
import model.Pedido;
import model.StatusPedido;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@WebService
public class PizzariaService {
    private ClienteDAO clienteDAO = new ClienteDAO();
    private PedidoDAO pedidoDAO = new PedidoDAO();
    private PizzaDAO pizzaDAO = new PizzaDAO();
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public PizzariaService() {
        scheduler.scheduleAtFixedRate(pedidoDAO::atualizarStatusAutomaticamente, 1, 1, TimeUnit.MINUTES);
    }

    @WebMethod
    public int cadastrarCliente(String nome, String telefone) {
        return clienteDAO.adicionarCliente(nome, telefone);
    }

    @WebMethod
    public int criarPedido(int clienteId, List<Integer> sabores, int bordaId) {
        if (!clienteDAO.existe(clienteId)) throw new RuntimeException("Cliente inválido.");
        for (int id : sabores)
            if (!pizzaDAO.saborExiste(id)) throw new RuntimeException("Sabor inválido: " + id);
        if (!pizzaDAO.bordaExiste(bordaId)) throw new RuntimeException("Borda inválida.");
        return pedidoDAO.adicionarPedido(new model.Pedido(0, clienteId, sabores, bordaId));
    }

    @WebMethod
    public Pedido consultarPedido(int id) {
        return pedidoDAO.getPedido(id);
    }

    @WebMethod
    public List<Pedido> listarPedidos() {
        return pedidoDAO.listarTodos();
    }

    @WebMethod
    public void adicionarSaborPizza(String nome) {
        pizzaDAO.adicionarSabor(nome);
    }

    @WebMethod
    public void adicionarBorda(String nome) {
        pizzaDAO.adicionarBorda(nome);
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/PizzariaService", new PizzariaService());
        System.out.println("SOAP Web Service iniciado!");
    }
}
