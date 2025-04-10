package fun.felipe.entities.repositories;

import fun.felipe.Main;
import fun.felipe.configs.database.Query;

public class VendaRepository {

    public static void createTable() {
        String sqlQuery = """
                CREATE TABLE IF NOT EXISTS vendas (
                    id INTEGER PRIMARY KEY AUTO_INCREMENT,
                    data DATETIME NOT NULL,
                    cpf VARCHAR(11) NOT NULL,
                    forma_pagamento VARCHAR(45) NOT NULL,
                    total FLOAT NOT NULL
                );
                """;

        try (Query query = Main.getDatabaseConfig().executeQuery(sqlQuery)) {
            query.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace(System.err);
        }
    }
}
