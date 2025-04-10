package fun.felipe.entities.repositories;

import fun.felipe.Main;
import fun.felipe.configs.database.Query;

public class FornecedorRepository {

    public static void createTable() {
        String sqlQuery = """
                CREATE TABLE IF NOT EXISTS fornecedores (
                    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
                    nome VARCHAR(100) NOT NULL,
                    endereco VARCHAR(200) NOT NULL);
                """;

        try (Query query = Main.getDatabaseConfig().executeQuery(sqlQuery)) {
            query.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace(System.err);
        }
    }
}
