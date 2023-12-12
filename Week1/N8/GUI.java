package Misha.Week1.N8;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.util.Objects;

public class GUI {
    //Frame & Panels
    public static JFrame frame = new JFrame("Number 8");                                            // this JFrame
    public static JPanel panel = new JPanel();                                                          // This JPanel -> other JPanel
    public static JPanel pTop = new JPanel();                                                           //{ This panels locations
    public static JPanel pCenter = new JPanel();
    public static JPanel pDown = new JPanel();                                                         //end}

    // Texts & Labels
        // String data
    static String[] arr = {"+", "-", "*", "/"};
    static String[] arr2 = {"+", "-"};
        //Top component
    public static JLabel sk1 = new JLabel("(");
    public static JComboBox comboBox0 = new JComboBox(arr2);
    public static JTextField t1 = new JTextField(4);
    public static JComboBox comboBox = new JComboBox(arr2);
    public static JTextField t2 = new JTextField(4);
    public static JLabel label2 = new JLabel("i");
    public static JLabel sk2 = new JLabel(")");
    public static JComboBox znak = new JComboBox(arr);
    public static JLabel sk12 = new JLabel("(");
    public static JComboBox comboBox00 = new JComboBox(arr2);
    public static JTextField t12 = new JTextField(4);
    public static JComboBox comboBox2 = new JComboBox(arr2);
    public static JTextField t22 = new JTextField(4);
    public static JLabel label22 = new JLabel("i");
    public static JLabel sk22 = new JLabel(")");
        // Center component
    public static JTextArea textArea = new JTextArea(15, 43);
    public static JScrollPane scrollPane = new JScrollPane(textArea);
        // Down component
    public static JButton b_run = new JButton("Run");
    // Runner funk -> main
    public static void main(String[] args) {

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // doc for print numbers, not symbols
        PlainDocument doc1 = new PlainDocument();
        doc1.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int off, String str, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(off, str.replaceAll("\\D++", ""), attr);  // remove non-digits
            }

            @Override
            public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr)
                    throws BadLocationException {
                fb.replace(off, len, str.replaceAll("\\D++", ""), attr);  // remove non-digits
            }
        });
        PlainDocument doc2 = new PlainDocument();
        doc2.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int off, String str, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(off, str.replaceAll("\\D++", ""), attr);  // remove non-digits
            }

            @Override
            public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr)
                    throws BadLocationException {
                fb.replace(off, len, str.replaceAll("\\D++", ""), attr);  // remove non-digits
            }
        });
        PlainDocument doc3 = new PlainDocument();
        doc3.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int off, String str, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(off, str.replaceAll("\\D++", ""), attr);  // remove non-digits
            }

            @Override
            public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr)
                    throws BadLocationException {
                fb.replace(off, len, str.replaceAll("\\D++", ""), attr);  // remove non-digits
            }
        });
        PlainDocument doc4 = new PlainDocument();
        doc4.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int off, String str, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(off, str.replaceAll("\\D++", ""), attr);  // remove non-digits
            }

            @Override
            public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr)
                    throws BadLocationException {
                fb.replace(off, len, str.replaceAll("\\D++", ""), attr);  // remove non-digits
            }
        });

        // assignment TextField doc
        t1.setDocument(doc1);
        t2.setDocument(doc2);
        t12.setDocument(doc3);
        t22.setDocument(doc4);

        textArea.setEditable(false); // textArea didn't print with keyboard
        // work button b_run
        b_run.addActionListener(actionEvent -> {
            if (!Objects.equals(t1.getText(), "") ||
                    !Objects.equals(t2.getText(), "") ||
                    !Objects.equals(t12.getText(), "") ||
                    !Objects.equals(t22.getText(), "")) {

                String ts01 = Objects.requireNonNull(comboBox0.getSelectedItem()) + t1.getText(),
                        ts02 = Objects.requireNonNull(comboBox.getSelectedItem()) + t2.getText(),
                        ts11 = Objects.requireNonNull(comboBox00.getSelectedItem()) + t12.getText(),
                        ts12 = Objects.requireNonNull(comboBox2.getSelectedItem()) + t22.getText();
                int ti01 = Integer.parseInt(ts01),
                        ti02 = Integer.parseInt(ts02),
                        ti11 = Integer.parseInt(ts11),
                        ti12 = Integer.parseInt(ts12);
                ComplexNumber c1 = new ComplexNumber(ti01, ti02);
                ComplexNumber c2 = new ComplexNumber(ti11, ti12);
                switch (Objects.requireNonNull(znak.getSelectedItem()).toString()) {
                    case "+" -> {
                        ComplexNumber c1_plus_c2 = ComplexNumber.add(c1, c2);
                        textArea.append(c1 + " + " + c2 + " = " + c1_plus_c2+";\n");
                    }
                    case "-" -> {
                        ComplexNumber c1_minus_c2 = ComplexNumber.subtract(c1, c2);
                        textArea.append(c1 + " - " + c2 + " = " + c1_minus_c2+";\n");
                    }
                    case "*" -> {
                        ComplexNumber c1_into_c2 = ComplexNumber.multiply(c1, c2);
                        textArea.append(c1 + " * " + c2 + " = " + c1_into_c2+";\n");
                    }
                    case "/" -> {
                        ComplexNumber c1_by_c2 = ComplexNumber.divide(c1, c2);
                        textArea.append(c1 + " / " + c2 + " = " + c1_by_c2+";\n");
                    }
                }
            }
        });

        // add into pTop components
            // one expression
        pTop.add(sk1);
        pTop.add(comboBox0);
        pTop.add(t1);
        pTop.add(comboBox);
        pTop.add(t2);
        pTop.add(label2);
        pTop.add(sk2);

        pTop.add(znak);//this symbol for calculations complex numbers

            // two expression
        pTop.add(sk12);
        pTop.add(comboBox00);
        pTop.add(t12);
        pTop.add(comboBox2);
        pTop.add(t22);
        pTop.add(label22);
        pTop.add(sk22);

        // add into pCenter textArea through scrollPane
        pCenter.add(scrollPane);

        // add into pDown button action
        pDown.add(b_run);

        // add into panel other panels
        panel.add(pTop);
        panel.add(pCenter);
        panel.add(pDown);

        // create frame & add into frame panel
        frame.add(panel);
        frame.setResizable(false);
        frame.setBounds(400, 400, 500, 365);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}