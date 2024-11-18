import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class PharmacyApp {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JFrame frame;
    private Connection connection;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PharmacyApp().createAndShowGUI());
    }

    private void createAndShowGUI() {
        frame = new JFrame("Pharmacy Management - SID");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        initializeDatabaseConnection();

        // Add pages
        mainPanel.add(createLoginPage(), "LoginPage");
        mainPanel.add(createMedicineListPage(), "MedicineListPage");

        frame.add(mainPanel);
        frame.setVisible(true);

        // Show the login page by default
        cardLayout.show(mainPanel, "LoginPage");
    }

    @SuppressWarnings("CallToPrintStackTrace")
    private void initializeDatabaseConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/pharmacy_db";  // Replace with your actual database details
            String user = "root";  // Your MySQL username
            String password = "your_password";  // Your MySQL password

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Database connection failed!", "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JPanel createLoginPage() {
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(new Color(21, 32, 43));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Pharmacy Management - SID");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        JTextField usernameField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        JPasswordField passwordField = new JPasswordField(15);

        JButton loginButton = new JButton("Login");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        loginPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        loginPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        loginPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        loginPanel.add(passwordField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        loginPanel.add(loginButton, gbc);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (validateLogin(username, password)) {
                cardLayout.show(mainPanel, "MedicineListPage");
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password!", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });

        return loginPanel;
    }

    private boolean validateLogin(String username, String password) {
        // Simple hardcoded validation (for example purposes)
        return "admin".equals(username) && "password".equals(password);
    }

    @SuppressWarnings({"CallToPrintStackTrace", "ConvertToTryWithResources"})
    private JPanel createMedicineListPage() {
        JPanel medicinePanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        JButton logoutButton = new JButton("Logout");

        topPanel.add(logoutButton);
        logoutButton.addActionListener(e -> cardLayout.show(mainPanel, "LoginPage"));

        JLabel pageTitle = new JLabel("Medicine List");
        pageTitle.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Fetch medicine data from the database
        try {
            String sql = "SELECT * FROM medicines";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");

                JPanel medicineItem = new JPanel();
                medicineItem.setLayout(new BorderLayout());
                medicineItem.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                JLabel medicineLabel = new JLabel(name);
                medicineLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                JTextArea medicineDescription = new JTextArea(description);
                medicineDescription.setEditable(false);
                medicineDescription.setLineWrap(true);
                medicineDescription.setWrapStyleWord(true);
                medicineDescription.setFont(new Font("Arial", Font.PLAIN, 12));
                medicineDescription.setRows(3);
                medicineDescription.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

                JPanel pricePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JLabel priceLabel = new JLabel("Price: $" + price);
                pricePanel.add(priceLabel);

                medicineItem.add(medicineLabel, BorderLayout.NORTH);
                medicineItem.add(medicineDescription, BorderLayout.CENTER);
                medicineItem.add(pricePanel, BorderLayout.SOUTH);

                centerPanel.add(medicineItem);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Failed to fetch medicines from the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        medicinePanel.add(topPanel, BorderLayout.NORTH);
        medicinePanel.add(pageTitle, BorderLayout.CENTER);
        medicinePanel.add(new JScrollPane(centerPanel), BorderLayout.SOUTH);

        return medicinePanel;
    }
}
