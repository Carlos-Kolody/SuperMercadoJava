import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sistema de Vendas para Supermercado");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);

            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.addTab("Clientes", new PainelClientes());
            tabbedPane.addTab("Atendentes", new PainelAtendentes());
            tabbedPane.addTab("Produtos", new PainelProdutos());

            frame.add(tabbedPane);
            frame.setVisible(true);
        });
    }
}
