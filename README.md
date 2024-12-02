
# To-Do List App

The objective of this project is to create a simple To-Do List Application that allows users to add, edit, remove, sort, and clear tasks using Java Swing. The app serves as an introduction to graphical user interface (GUI) development with Swing, focusing on interacting with lists, buttons, and dialogs.

## Live Demo:


https://github.com/user-attachments/assets/c6c613b2-f077-40a8-9ebe-879c240d6d23






## Key Features:

- **Add** Task: Input a new task in the text field and click "Add" to add it to the list.
- **Edit** Task: Select an existing task from the list, edit it, and save the changes.
- **Remove** Task: Remove a selected task from the list.
- **Sort** Tasks: Sort tasks in alphabetical order.
- **Clear** All Tasks: Clear the entire task list after a confirmation prompt.
The app provides a clean and simple interface for managing a list of tasks, making it a useful tool for basic to-do list management.


## Pseudo Code Diagram:

![w drawio](https://github.com/user-attachments/assets/31371b35-8e75-4fbb-81e6-622330cc7df2)



## Keywords & their Definitions:


| Keywords | Description                |
| :-------- | :------------------------- |
| `JList, DefaultListModel` | For displaying and managing the list of tasks. |
| `JButton, ActionListener` | For triggering actions based on user input. |
| `Swing Layouts` | Using **BorderLayout**, **GridLayout**, and **JPanel** for organizing GUI components. |
| `JOptionPane` | For displaying confirmation and error messages. |


## Code Snippets:

### 1.  Importing Libraries
#### We import the necessary libraries for creating a Swing GUI and working with lists and event handling.
```bash
package todolistapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.DefaultListModel;
import java.util.Collections;
```
    
    
### 2. Main Frame Setup
#### Title: Sets the window title as "To-Do List App".
#### Size: Window size is set to 500x350 pixels to fit the list and buttons.
####  Close Operation: When the user closes the window, the application will exit.
####  Location: The window will appear centered on the screen.

```bash
// Set frame properties
setTitle("To-Do List App");
setSize(500, 350);  
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null); 

```
    
### 3. List Model and GUI Components
#### DefaultListModel: A model used to store and manipulate the list of tasks.
#### JList: Displays the list of tasks.
#### JTextField: For entering new tasks.
#### JButton: Various buttons for adding, editing, removing, sorting, and clearing tasks.

```bash
// Initialize components
todoListModel = new DefaultListModel<>();
todoList = new JList<>(todoListModel);
inputField = new JTextField(20);
addButton = new JButton("Add");
editButton = new JButton("Edit");
removeButton = new JButton("Remove");
sortButton = new JButton("Sort");
clearButton = new JButton("Clear List");
```

### 4. Layout and Panel Setup
#### GridLayout: Arranges the buttons horizontally.
#### BorderLayout: The bottom panel contains the input field and buttons, placed using BorderLayout.

```bash
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
```

### 5. Action Listeners for Buttons

#### Each button has an associated action listener that triggers specific functionality when clicked. #### For example:
#### Add Button: Adds the task from the text field to the list.
#### Edit Button: Edits the selected task.
#### Remove Button: Removes the selected task.
#### Sort Button: Sorts tasks alphabetically.
#### Clear Button: Clears all tasks after a confirmation prompt.

```bash
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
```

## Output:
![Screenshot (79)](https://github.com/user-attachments/assets/a203432f-b811-4c17-8363-5d31bbf074de)



## Conclusion:

This To-Do List App demonstrates how to use Java Swing to create a simple yet functional graphical user interface. The app allows users to manage their tasks through intuitive buttons and a clean layout.
#### The application highlights the following key concepts:
#### JList and DefaultListModel: For displaying and managing the list of tasks.
#### JButton and ActionListener: For triggering actions based on user input.
#### Swing Layouts: Using BorderLayout, GridLayout, and JPanel for organizing GUI components.
#### JOptionPane: For displaying confirmation and error messages.
This app serves as a great starting point for anyone learning Java Swing or looking to create task management applications with basic functionality. You can extend this app by adding features such as task deadlines, categories, or saving the list to a file for persistence.
