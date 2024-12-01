package todolistapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.DefaultListModel;
import java.util.Collections;

public class ToDoListApp extends JFrame {

    // Components
    private DefaultListModel<String> todoListModel;
    private JList<String> todoList;
    private JTextField inputField;
    private JButton addButton, editButton, removeButton, sortButton, clearButton;

    public ToDoListApp() {
        // Set frame properties
        setTitle("To-Do List App");
        setSize(500, 350);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        // Layout setup
        setLayout(new BorderLayout());

        // Initialize components
        todoListModel = new DefaultListModel<>();
        todoList = new JList<>(todoListModel);
        inputField = new JTextField(20);
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        removeButton = new JButton("Remove");
        sortButton = new JButton("Sort");
        clearButton = new JButton("Clear List");

        // List to display tasks
        JScrollPane scrollPane = new JScrollPane(todoList);
        add(scrollPane, BorderLayout.CENTER);

        // Panel for input field and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(editButton);
        
        // Create a separate panel for the "Remove", "Sort", and "Clear List" buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));  // Arrange buttons horizontally
        buttonPanel.add(removeButton);
        buttonPanel.add(sortButton);
        buttonPanel.add(clearButton);

        // Add both input panel and button panel to the bottom of the window
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputPanel, BorderLayout.NORTH);
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        // Button Actions
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editTask();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeTask();
            }
        });

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortTasks();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearList();
            }
        });

        // Focus on input field
        inputField.requestFocusInWindow();
    }

    private void addTask() {
        String task = inputField.getText().trim();
        if (!task.isEmpty()) {
            todoListModel.addElement(task);
            inputField.setText(""); // Clear input field after adding
        } else {
            JOptionPane.showMessageDialog(this, "Task cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editTask() {
        int selectedIndex = todoList.getSelectedIndex();
        if (selectedIndex != -1) {
            String newTask = JOptionPane.showInputDialog(this, "Edit Task", todoListModel.getElementAt(selectedIndex));
            if (newTask != null && !newTask.trim().isEmpty()) {
                todoListModel.setElementAt(newTask, selectedIndex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a task to edit.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeTask() {
        int selectedIndex = todoList.getSelectedIndex();
        if (selectedIndex != -1) {
            todoListModel.removeElementAt(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Select a task to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void sortTasks() {
        java.util.List<String> list = Collections.list(todoListModel.elements());
        Collections.sort(list);
        todoListModel.clear();
        for (String task : list) {
            todoListModel.addElement(task);
        }
    }

    private void clearList() {
        int confirmation = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to clear all tasks?", 
                "Clear All Tasks", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE);
        if (confirmation == JOptionPane.YES_OPTION) {
            todoListModel.clear();
        }
    }

    public static void main(String[] args) {
        // Create the main frame
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ToDoListApp app = new ToDoListApp();
                app.setVisible(true);
            }
        });
    }
}
