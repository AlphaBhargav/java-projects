import javax.swing.*;
import java.awt.event.*;

public class bgk {

    static String correctpassword = "bhargav_029";
    static String[] name = new String[100];
    static String[] id = new String[100];
    static int[] marks = new int[100];

    static int count = 0;

    public static void main(String[] args) {

        JFrame sample = new JFrame("SAMPLE");
        sample.setLayout(null);

        JLabel a = new JLabel("Enter your name");
        a.setBounds(10, 10, 150, 20);

        JLabel b = new JLabel("Enter your age");
        b.setBounds(10, 40, 150, 20);

        JLabel c = new JLabel("Enter your password");
        c.setBounds(10, 70, 150, 20);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 10, 150, 20);

        JTextField ageField = new JTextField();
        ageField.setBounds(150, 40, 150, 20);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 20);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 100, 100, 25);

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(260, 100, 100, 25);

        JButton add = new JButton("Add");
        add.setBounds(10, 100, 90, 25);

        JButton update = new JButton("Update");
        update.setBounds(110, 100, 90, 25);

        JButton search = new JButton("Search");
        search.setBounds(210, 100, 90, 25);

        JButton delete = new JButton("Delete");
        delete.setBounds(310, 100, 90, 25);

        JButton view = new JButton("View");
        view.setBounds(410, 100, 90, 25);

        JButton logout = new JButton("Logout");
        logout.setBounds(510, 100, 90, 25);

        add.setVisible(false);
        update.setVisible(false);
        search.setVisible(false);
        delete.setVisible(false);
        view.setVisible(false);
        logout.setVisible(false);

        sample.add(a);
        sample.add(b);
        sample.add(c);
        sample.add(nameField);
        sample.add(ageField);
        sample.add(passwordField);
        sample.add(submitButton);
        sample.add(resetButton);
        sample.add(add);
        sample.add(update);
        sample.add(search);
        sample.add(delete);
        sample.add(view);
        sample.add(logout);

        sample.setSize(700, 300);
        sample.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sample.setLocationRelativeTo(null);
        sample.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String userName = nameField.getText();
                String age = ageField.getText();
                String password = new String(passwordField.getPassword());

                if (password.equals(correctpassword)) {

                    JOptionPane.showMessageDialog(sample,
                            "Name : " + userName +
                            "\nAge : " + age +
                            "\nLogin Successful");

                    add.setVisible(true);
                    update.setVisible(true);
                    search.setVisible(true);
                    delete.setVisible(true);
                    view.setVisible(true);
                    logout.setVisible(true);

                    a.setVisible(false);
                    b.setVisible(false);
                    c.setVisible(false);

                    nameField.setVisible(false);
                    ageField.setVisible(false);
                    passwordField.setVisible(false);

                    submitButton.setVisible(false);
                    resetButton.setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(sample, "Incorrect Password");
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                nameField.setText("");
                ageField.setText("");
                passwordField.setText("");
            }
        });

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String studentName = JOptionPane.showInputDialog(sample, "Enter Student Name");
                String studentId = JOptionPane.showInputDialog(sample, "Enter Student ID");
                int studentMarks = Integer.parseInt(
                        JOptionPane.showInputDialog(sample, "Enter Student Marks"));

                name[count] = studentName;
                id[count] = studentId;
                marks[count] = studentMarks;

                count++;

                JOptionPane.showMessageDialog(sample, "Student Added Successfully");
            }
        });

        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (count == 0) {
                    JOptionPane.showMessageDialog(sample, "No Students Added");
                    return;
                }

                String searchId = JOptionPane.showInputDialog(sample, "Enter Student ID");

                boolean found = false;

                for (int i = 0; i < count; i++) {

                    if (searchId.equals(id[i])) {

                        name[i] = JOptionPane.showInputDialog(sample, "Enter New Name");
                        id[i] = JOptionPane.showInputDialog(sample, "Enter New ID");
                        marks[i] = Integer.parseInt(
                                JOptionPane.showInputDialog(sample, "Enter New Marks"));

                        JOptionPane.showMessageDialog(sample, "Student Updated Successfully");

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(sample, "Student Not Found");
                }
            }
        });

        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (count == 0) {
                    JOptionPane.showMessageDialog(sample, "No Students Added");
                    return;
                }

                String searchId = JOptionPane.showInputDialog(sample, "Enter Student ID");

                for (int i = 0; i < count; i++) {

                    if (searchId.equals(id[i])) {

                        JOptionPane.showMessageDialog(sample,
                                "Name : " + name[i] +
                                "\nID : " + id[i] +
                                "\nMarks : " + marks[i]);
                        return;
                    }
                }

                JOptionPane.showMessageDialog(sample, "Student Not Found");
            }
        });

        view.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (count == 0) {
                    JOptionPane.showMessageDialog(sample, "No Students Added");
                    return;
                }

                String data = "";

                for (int i = 0; i < count; i++) {

                    data += "Name : " + name[i]
                            + "\nID : " + id[i]
                            + "\nMarks : " + marks[i]
                            + "\n----------------------\n";
                }

                JOptionPane.showMessageDialog(sample, data);
            }
        });

        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (count == 0) {
                    JOptionPane.showMessageDialog(sample, "No Students Added");
                    return;
                }

                String deleteId = JOptionPane.showInputDialog(sample, "Enter Student ID");

                for (int i = 0; i < count; i++) {

                    if (deleteId.equals(id[i])) {

                        for (int j = i; j < count - 1; j++) {
                            name[j] = name[j + 1];
                            id[j] = id[j + 1];
                            marks[j] = marks[j + 1];
                        }

                        count--;

                        JOptionPane.showMessageDialog(sample, "Student Deleted Successfully");
                        return;
                    }
                }

                JOptionPane.showMessageDialog(sample, "Student Not Found");
            }
        });

        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                add.setVisible(false);
                update.setVisible(false);
                search.setVisible(false);
                delete.setVisible(false);
                view.setVisible(false);
                logout.setVisible(false);

                a.setVisible(true);
                b.setVisible(true);
                c.setVisible(true);

                nameField.setVisible(true);
                ageField.setVisible(true);
                passwordField.setVisible(true);

                submitButton.setVisible(true);
                resetButton.setVisible(true);

                nameField.setText("");
                ageField.setText("");
                passwordField.setText("");

                JOptionPane.showMessageDialog(sample, "Logged Out Successfully");
            }
        });
    }
}
