import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelAtendentes extends JPanel {
    private DefaultListModel<Atendente> atendenteModel;
    private JList<Atendente> atendenteList;
    private JTextField idField, nomeField, matriculaField;

    public PainelAtendentes() {
        setLayout(new BorderLayout());

        atendenteModel = new DefaultListModel<>();
        atendenteList = new JList<>(atendenteModel);
        add(new JScrollPane(atendenteList), BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        formPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        formPanel.add(idField);
        formPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        formPanel.add(nomeField);
        formPanel.add(new JLabel("Matrícula:"));
        matriculaField = new JTextField();
        formPanel.add(matriculaField);

        JButton addButton = new JButton("Adicionar Atendente");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String nome = nomeField.getText();
                String matricula = matriculaField.getText();
                Atendente atendente = new Atendente(id, nome, matricula);
                atendenteModel.addElement(atendente);
                clearFields();
            }
        });

        formPanel.add(addButton);
        add(formPanel, BorderLayout.SOUTH);
    }

    private void clearFields() {
        idField.setText("");
        nomeField.setText("");
        matriculaField.setText("");
    }
}
