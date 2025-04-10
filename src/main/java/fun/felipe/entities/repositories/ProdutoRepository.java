package fun.felipe.entities.repositories;

import fun.felipe.Main;
import fun.felipe.configs.database.Query;
import fun.felipe.entities.models.ProdutoEntity;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {

    public static void createTable() {
        String sqlQuery = """
                CREATE TABLE IF NOT EXISTS produtos (
                    id INTEGER PRIMARY KEY AUTO_INCREMENT,
                    id_fornecedor INTEGER NOT NULL,
                    titulo VARCHAR(180) NOT NULL,
                    valor_unitario FLOAT NOT NULL,
                    quantidade INTEGER NOT NULL,
                    FOREIGN KEY (id_fornecedor) REFERENCES fornecedores(id)
                );
                """;

        try (Query query = Main.getDatabaseConfig().executeQuery(sqlQuery)) {
            query.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace(System.err);
        }
    }

    public List<ProdutoEntity> findAll() {
        String sqlQuery = """
                SELECT id, titulo, quantidade FROM produtos;
                """;

        List<ProdutoEntity> produtos = new ArrayList<>();
        try (Query query = Main.getDatabaseConfig().executeQuery(sqlQuery)) {
            ResultSet resultSet = query.executeQuery();

            while (resultSet.next()) {
                produtos.add(new ProdutoEntity(
                    resultSet.getInt("id"),
                    resultSet.getString("titulo"),
                    resultSet.getInt("quantidade")
                ));

                System.out.println(produtos.toString());
            }
        } catch (Exception exception) {
            exception.printStackTrace(System.err);
        }
        return produtos;
    }

    public void atualizarEstoque(int id, int quantidade) {
        String sqlQuery = """
                UPDATE produtos SET quantidade = ? WHERE id = ?;
                """;

        try (Query query = Main.getDatabaseConfig().executeQuery(sqlQuery)) {
            query.getStatement().setInt(1, quantidade);
            query.getStatement().setInt(2, id);
            query.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace(System.err);
        }
    }

    public void adicionarProduto(int id_fornecedor, String titulo, float valor, int quantidade) {
        String sqlQuery = """
                INSERT INTO produtos (id_fornecedor, titulo, valor_unitario, quantidade) VALUES (?, ?, ?, ?);
                """;

        try (Query query = Main.getDatabaseConfig().executeQuery(sqlQuery)) {
            query.getStatement().setInt(1, id_fornecedor);
            query.getStatement().setString(2, titulo);
            query.getStatement().setFloat(3, valor);
            query.getStatement().setInt(4, quantidade);
            query.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace(System.err);
        }
    }

    public void deletarProduto(int id) {
        String sqlQuery = """
                DELETE FROM produtos WHERE id = ?;
                """;

        try (Query query = Main.getDatabaseConfig().executeQuery(sqlQuery)) {
            query.getStatement().setInt(1, id);
            query.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace(System.err);
        }
    }
}
