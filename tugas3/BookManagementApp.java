package tugas3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookManagementApp extends JFrame {
    private JTextField bookTitleField, authorNameField;
    private JTextArea descriptionArea;
    private JRadioButton genreFiction, genreNonFiction;
    private JCheckBox isAvailable;
    private JComboBox<String> categoryComboBox;
    private JList<String> languageList;
    private JSlider ratingSlider;
    private JSpinner quantitySpinner;
    private JTable bookTable, authorTable;
    private DefaultTableModel bookTableModel, authorTableModel;

    public BookManagementApp() {
        setTitle("Book Management Application");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Menu setup
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        
        JMenuItem bookMenuItem = new JMenuItem("Book Form");
        bookMenuItem.addActionListener(e -> showBookForm());
        
        JMenuItem authorMenuItem = new JMenuItem("Author Form");
        authorMenuItem.addActionListener(e -> showAuthorForm());
        
        menu.add(bookMenuItem);
        menu.add(authorMenuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Layout manager for main content area
        setLayout(new CardLayout());
        add(createBookFormPanel(), "Book Form");
        add(createAuthorFormPanel(), "Author Form");
    }

    private JPanel createBookFormPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Input Form
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Book Information"));
        
        formPanel.add(new JLabel("Judul"));
        bookTitleField = new JTextField(20);
        formPanel.add(bookTitleField);

        formPanel.add(new JLabel("deskripsi"));
        descriptionArea = new JTextArea(3, 20);
        formPanel.add(new JScrollPane(descriptionArea));

        formPanel.add(new JLabel("Genre:"));
        genreFiction = new JRadioButton("Fiction");
        genreNonFiction = new JRadioButton("Non-Fiction");
        ButtonGroup genreGroup = new ButtonGroup();
        genreGroup.add(genreFiction);
        genreGroup.add(genreNonFiction);
        JPanel genrePanel = new JPanel();
        genrePanel.add(genreFiction);
        genrePanel.add(genreNonFiction);
        formPanel.add(genrePanel);

        formPanel.add(new JLabel("Category:"));
        categoryComboBox = new JComboBox<>(new String[]{"Novel", "Science", "History", "Art"});
        formPanel.add(categoryComboBox);

        formPanel.add(new JLabel("Languages:"));
        languageList = new JList<>(new String[]{"inggris", "Indonesia", "Arab", "Jerman"});
        languageList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        formPanel.add(new JScrollPane(languageList));

        formPanel.add(new JLabel("Rating:"));
        ratingSlider = new JSlider(0, 10, 5);
        ratingSlider.setMajorTickSpacing(2);
        ratingSlider.setPaintTicks(true);
        ratingSlider.setPaintLabels(true);
        formPanel.add(ratingSlider);

        formPanel.add(new JLabel("Quantity:"));
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        formPanel.add(quantitySpinner);

        formPanel.add(new JLabel("Available:"));
        isAvailable = new JCheckBox();
        formPanel.add(isAvailable);

        // Submit Button
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> addBookToTable());
        formPanel.add(addButton);

        // Table
        bookTableModel = new DefaultTableModel(new String[]{"Title", "Genre", "Category",
        "Rating", "Quantity", "Available"}, 0);
        bookTable = new JTable(bookTableModel);
        JScrollPane tableScroll = new JScrollPane(bookTable);

        // Add components to panel
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(tableScroll, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createAuthorFormPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Input Form
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Author Information"));

        formPanel.add(new JLabel("Author Name:"));
        authorNameField = new JTextField(20);
        formPanel.add(authorNameField);

        JButton addAuthorButton = new JButton("Add Author");
        addAuthorButton.addActionListener(e -> addAuthorToTable());
        formPanel.add(addAuthorButton);

        // Table
        authorTableModel = new DefaultTableModel(new String[]{"Author Name"}, 0);
        authorTable = new JTable(authorTableModel);
        JScrollPane tableScroll = new JScrollPane(authorTable);

        // Add components to panel
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(tableScroll, BorderLayout.CENTER);

        return panel;
    }

    private void addBookToTable() {
        String title = bookTitleField.getText();
        String genre = genreFiction.isSelected() ? "Fiction" : "Non-Fiction";
        String category = (String) categoryComboBox.getSelectedItem();
        int rating = ratingSlider.getValue();
        int quantity = (Integer) quantitySpinner.getValue();
        boolean available = isAvailable.isSelected();

        bookTableModel.addRow(new Object[]{title, genre, category, rating, quantity, available});
    }

    private void addAuthorToTable() {
        String authorName = authorNameField.getText();
        authorTableModel.addRow(new Object[]{authorName});
    }

    private void showBookForm() {
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "Book Form");
    }

    private void showAuthorForm() {
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "Author Form");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookManagementApp app = new BookManagementApp();
            app.setVisible(true);
        });
    }
}

