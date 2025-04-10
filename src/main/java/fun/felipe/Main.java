package fun.felipe;

import fun.felipe.configs.database.DatabaseConfig;
import fun.felipe.configs.i18n.I18nConfig;
import fun.felipe.entities.repositories.FornecedorRepository;
import fun.felipe.entities.repositories.ProdutoRepository;
import fun.felipe.entities.repositories.VendaProdutoRepository;
import fun.felipe.entities.repositories.VendaRepository;
import fun.felipe.view.MainView;

public class Main {
    private static DatabaseConfig databaseConfig;
    private static I18nConfig i18nConfig;

    public static void main(String[] args) {
        databaseConfig = new DatabaseConfig(
                "localhost",
                3306,
                "dev_db",
                "dev",
                "root"
        );

        i18nConfig = new I18nConfig(System.getProperty("user.language"));
        createTable();

        new MainView();
    }

    public static DatabaseConfig getDatabaseConfig() {
        return databaseConfig;
    }

    public static I18nConfig getI18nConfig() {
        return i18nConfig;
    }

    private static void createTable() {
        FornecedorRepository.createTable();
        ProdutoRepository.createTable();
        VendaRepository.createTable();
        VendaProdutoRepository.createTable();
    }
}