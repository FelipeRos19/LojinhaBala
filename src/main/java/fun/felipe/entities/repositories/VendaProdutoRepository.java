package fun.felipe.entities.repositories;

import fun.felipe.Main;
import fun.felipe.configs.database.Query;

public class VendaProdutoRepository {

    public static void createTable() {
        String sqlQuery = """
                CREATE TABLE IF NOT EXISTS venda_produtos (
                    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
                    id_venda INTEGER NOT NULL,
                    id_produto INTEGER NOT NULL,
                    quantidade INTEGER NOT NULL,
                    FOREIGN KEY (id_venda) REFERENCES vendas(id),
                    FOREIGN KEY (id_produto) REFERENCES produtos(id)
                );
                """;

        try (Query query = Main.getDatabaseConfig().executeQuery(sqlQuery)) {
            query.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace(System.err);
        }
    }

    public void addVendaProduto(int idVenda, int idProduto, int quantidade) {
        String sqlQuery = """
                INSERT INTO venda_produtos (id_venda, id_produto, quantidade) VALUES (?,?,?);
                """;

        try (Query query = Main.getDatabaseConfig().executeQuery(sqlQuery)) {
            query.getStatement().setInt(1, idVenda);
            query.getStatement().setInt(2, idProduto);
            query.getStatement().setInt(3, quantidade);
            query.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace(System.err);
        }
    }
}
