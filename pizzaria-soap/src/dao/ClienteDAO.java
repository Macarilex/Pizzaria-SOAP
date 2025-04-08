
package dao;

import model.Cliente;
import java.util.HashMap;
import java.util.Map;

public class ClienteDAO {
    private Map<Integer, Cliente> clientes = new HashMap<>();
    private int counter = 1;

    public int adicionarCliente(String nome, String telefone) {
        Cliente cliente = new Cliente(counter, nome, telefone);
        clientes.put(counter, cliente);
        return counter++;
    }

    public boolean existe(int id) {
        return clientes.containsKey(id);
    }
}
