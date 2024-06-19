import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelClientes extends JPanel {
    private DefaultListModel<Cliente> clienteModel;
    private JList<Cliente> clienteList;
    private JTextField idField, nomeField, cpfField, emailField;

    public PainelClientes() {
        setLayout(new BorderLayout());

        clienteModel = new DefaultListModel<>();
        clienteList = new JList<>(clienteModel);
        add(new JScrollPane(clienteList), BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        limitarApenasNumeros(idField);
        formPanel.add(idField);
        formPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        formPanel.add(nomeField);
        formPanel.add(new JLabel("CPF:"));
        cpfField = new JTextField();
        limitarApenasNumeros(cpfField);
        formPanel.add(cpfField);
        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        JButton addButton = new JButton("Adicionar Cliente");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String nome = nomeField.getText();
                String cpf = cpfField.getText();
                String email = emailField.getText();
                Cliente cliente = new Cliente(id, nome, cpf, email);
                clienteModel.addElement(cliente);
                clearFields();
            }
        });

        formPanel.add(addButton);
        add(formPanel, BorderLayout.SOUTH);
    }

    private void clearFields() {
        idField.setText("");
        nomeField.setText("");
        cpfField.setText("");
        emailField.setText("");
    }

    private void limitarApenasNumeros(JTextField field) {
        ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[0-9]+") || text.equals("")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
}
