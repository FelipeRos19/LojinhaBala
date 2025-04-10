package fun.felipe.view;

import fun.felipe.Main;
import fun.felipe.entities.models.ProdutoEntity;
import fun.felipe.entities.repositories.ProdutoRepository;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;

public class EstoqueView extends JFrame {

    public EstoqueView() throws HeadlessException {
        super("Estoque");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.setComponents();

        this.setVisible(true);
    }

    private void setComponents() {
        this.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel);

        JLabel title = new JLabel(Main.getI18nConfig().get("estoque"), SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        mainPanel.add(title, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        this.atualizarLista(listModel);

        JList<String> productList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(productList);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        centerPanel.add(scrollPane, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        centerPanel.add(buttonPanel, BorderLayout.CENTER);

        JButton atualizarButton = new JButton(Main.getI18nConfig().get("atualizar-estoque"));
        JButton adicionarButton = new JButton(Main.getI18nConfig().get("adicionar-produto"));
        JButton removerButton = new JButton(Main.getI18nConfig().get("remover-produto"));
        atualizarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        adicionarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        atualizarButton.setMaximumSize(new Dimension(180, 40));
        adicionarButton.setMaximumSize(new Dimension(180, 40));
        removerButton.setMaximumSize(new Dimension(180, 40));

        atualizarButton.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setTitle(Main.getI18nConfig().get("atualizar-estoque"));
            dialog.setSize(250, 200);
            dialog.setLayout(new GridLayout(4, 2));

            JLabel id = new JLabel("ID:");
            JTextField idText = new JTextField();

            JLabel quantidade = new JLabel(Main.getI18nConfig().get("quantidade"));
            JTextField quantidadeText = new JTextField();


            JButton confirm = new JButton(Main.getI18nConfig().get("confirmar"));
            confirm.addActionListener(e2 -> {
                int rID = Integer.parseInt(idText.getText());
                int rQuantidade = Integer.parseInt(quantidadeText.getText());
                new ProdutoRepository().atualizarEstoque(rID, rQuantidade);
                this.atualizarLista(listModel);
                dialog.dispose();
            });

            dialog.add(id);
            dialog.add(idText);
            dialog.add(quantidade);
            dialog.add(quantidadeText);
            dialog.add(confirm);
            dialog.setVisible(true);

        });

        adicionarButton.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setTitle(Main.getI18nConfig().get("adicionar-produto"));
            dialog.setSize(250, 200);
            dialog.setLayout(new GridLayout(6, 2));

            JLabel id = new JLabel(Main.getI18nConfig().get("id-fornecedor"));
            JTextField idText = new JTextField();

            JLabel titulo = new JLabel(Main.getI18nConfig().get("titulo"));
            JTextField tituloText = new JTextField();

            JLabel valor = new JLabel(Main.getI18nConfig().get("valor"));
            JTextField valorText = new JTextField();

            JLabel quantidade = new JLabel(Main.getI18nConfig().get("quantidade"));
            JTextField quantidadeText = new JTextField();

            JButton confirm = new JButton(Main.getI18nConfig().get("confirmar"));
            confirm.addActionListener(e2 -> {
                int rID = Integer.parseInt(idText.getText());
                String rTitulo = tituloText.getText();
                float rValor = Float.parseFloat(valorText.getText());
                int rQuantidade = Integer.parseInt(quantidadeText.getText());
                new ProdutoRepository().adicionarProduto(rID, rTitulo, rValor, rQuantidade);
                this.atualizarLista(listModel);
                dialog.dispose();
            });

            dialog.add(id);
            dialog.add(idText);
            dialog.add(titulo);
            dialog.add(tituloText);
            dialog.add(valor);
            dialog.add(valorText);
            dialog.add(quantidade);
            dialog.add(quantidadeText);
            dialog.add(confirm);
            dialog.setVisible(true);
        });

        removerButton.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setTitle(Main.getI18nConfig().get("remover-produto"));
            dialog.setSize(250, 200);
            dialog.setLayout(new GridLayout(2, 2));

            JLabel id = new JLabel(Main.getI18nConfig().get("id-produto"));
            JTextField idText = new JTextField();

            JButton confirm = new JButton(Main.getI18nConfig().get("confirmar"));
            confirm.addActionListener(e2 -> {
                int rID = Integer.parseInt(idText.getText());
                new ProdutoRepository().deletarProduto(rID);
                this.atualizarLista(listModel);
                dialog.dispose();
            });

            dialog.add(id);
            dialog.add(idText);
            dialog.add(confirm);
            dialog.setVisible(true);
        });

        buttonPanel.add(Box.createVerticalStrut(30));
        buttonPanel.add(atualizarButton);
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(adicionarButton);
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(removerButton);

        JPanel topLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton voltarButton = new JButton(Main.getI18nConfig().get("voltar"));

        voltarButton.addActionListener(e -> dispose());

        topLeftPanel.add(voltarButton);
        mainPanel.add(topLeftPanel, BorderLayout.WEST);
    }

    private void atualizarLista(DefaultListModel<String> listModel) {
        listModel.clear();
        var produtos = new ProdutoRepository().findAll();
        for (ProdutoEntity produto : produtos) {
            listModel.addElement(produto.getId() + " - " + produto.getTitulo() + " - " + produto.getQuantidade());
        }
    }
}
