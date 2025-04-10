package fun.felipe.configs.i18n;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class I18nConfig {
    private final Map<String, String> keys;

    public I18nConfig(String language) {
        this.keys = new HashMap<>();
        System.out.println(language);
        this.loadKeys(language);
    }

    private void loadKeys(String language) {
        String fileName = language + ".txt";
        String filePath = "src/main/resources/lang/" + fileName;

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("não encontrado!");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                String line = br.readLine();
                String[] lineV = line.split("=");
                this.keys.put(lineV[0], lineV[1]);
            }
        } catch (IOException exception) {
            exception.printStackTrace(System.err);
        }
    }

    public String get(String key) {
        return keys.get(key);
    }
}
