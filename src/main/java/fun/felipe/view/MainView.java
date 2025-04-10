package fun.felipe.view;

import fun.felipe.Main;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    public MainView() throws HeadlessException {
        super("Lojinha");
        this.setSize(1024,768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setComponents();

        this.setVisible(true);
    }

    private void setComponents() {
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));

        JButton estoqueButton = new JButton(Main.getI18nConfig().get("estoque"));
        estoqueButton.setPreferredSize(new Dimension(300, 100));
        buttonPanel.add(estoqueButton);
        estoqueButton.addActionListener(e -> {
            new EstoqueView();
        });

        JButton vendasButton = new JButton(Main.getI18nConfig().get("vendas"));
        vendasButton.setPreferredSize(new Dimension(300, 100));
        buttonPanel.add(vendasButton);

        panel.add(buttonPanel);

        this.setContentPane(panel);
    }
}
