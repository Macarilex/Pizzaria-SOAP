
package dao;

import java.util.HashMap;
import java.util.Map;

public class PizzaDAO {
    private Map<Integer, String> sabores = new HashMap<>();
    private Map<Integer, String> bordas = new HashMap<>();

    public void adicionarSabor(String nome) {
        sabores.put(sabores.size() + 1, nome);
    }

    public void adicionarBorda(String nome) {
        bordas.put(bordas.size() + 1, nome);
    }

    public boolean saborExiste(int id) {
        return sabores.containsKey(id);
    }

    public boolean bordaExiste(int id) {
        return bordas.containsKey(id);
    }
}
