import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingCalci extends JFrame {
    JPanel panel;
    JComboBox<String> operator;
    JTextField num1, num2, result;
    JButton calculate, reset;

    public SwingCalci() {
        setTitle("Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        // by default text field is editable
        num1 = new JTextField();
        num2 = new JTextField();
        result = new JTextField();
        result.setEditable(false);

        String[] operators = { "+", "-", "*", "/" };
        operator = new JComboBox<>(operators);

        calculate = new JButton("Calculate");
        // ActionListener is a callback interface
        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculator();
            }
        });

        reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1.setText("");
                num2.setText("");
                result.setText("");
            }
        });

        panel.add(new JLabel("Number 1: "));
        panel.add(num1);
        panel.add(new JLabel("Number 2: "));
        panel.add(num2);
        panel.add(new JLabel("Choose operator: "));
        panel.add(operator);
        panel.add(new JLabel("Result: "));
        panel.add(result);

        add(panel, BorderLayout.CENTER);
        add(calculate, BorderLayout.SOUTH);
        add(reset, BorderLayout.NORTH);
    }

    public void calculator() {
        try {
            double num1 = Double.parseDouble(this.num1.getText());
            double num2 = Double.parseDouble(this.num2.getText());
            String operator = (String) this.operator.getSelectedItem();
            switch (operator) {
                case "+":
                    result.setText(String.valueOf(num1 + num2));
                    break;
                case "-":
                    result.setText(String.valueOf(num1 - num2));
                    break;
                case "*":
                    result.setText(String.valueOf(num1 * num2));
                    break;
                case "/":
                    if (num2 == 0)
                        result.setText("Error : Division by zero");
                    else
                        result.setText(String.valueOf(num1 / num2));
                    break;
                default:
                    result.setText("Invalid operator");
            }
        } catch (NumberFormatException e) {
            result.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        // running on the event dispatch thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SwingCalci frame = new SwingCalci();
                frame.setVisible(true);
            }
        });
    }
}
