import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelProdutos extends JPanel {
    private DefaultListModel<Produto> produtoModel;
    private JList<Produto> produtoList;
    private JTextField idField, nomeField, precoField, quantidadeField;

    public PainelProdutos() {
        setLayout(new BorderLayout());

        produtoModel = new DefaultListModel<>();
        produtoList = new JList<>(produtoModel);
        add(new JScrollPane(produtoList), BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        formPanel.add(idField);
        formPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        formPanel.add(nomeField);
        formPanel.add(new JLabel("Preço:"));
        precoField = new JTextField();
        formPanel.add(precoField);
        formPanel.add(new JLabel("Quantidade:"));
        quantidadeField = new JTextField();
        formPanel.add(quantidadeField);

        JButton addButton = new JButton("Adicionar Produto");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String nome = nomeField.getText();
                double preco = Double.parseDouble(precoField.getText());
                int quantidade = Integer.parseInt(quantidadeField.getText());
                Produto produto = new Produto(id, nome, preco, quantidade);
                produtoModel.addElement(produto);
                clearFields();
            }
        });

        formPanel.add(addButton);
        add(formPanel, BorderLayout.SOUTH);
    }

    private void clearFields() {
        idField.setText("");
        nomeField.setText("");
        precoField.setText("");
        quantidadeField.setText("");
    }
}
