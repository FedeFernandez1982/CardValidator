package com.federico;

        import javax.swing.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

/**
 * Created by Fede on 6/11/2016.
 */
public class CardValidator extends JFrame{
    private JTextField creditCardNumberField;
    private JButton Validate;
    private JButton quitButton;
    private JPanel RootPanel;
    private JLabel InfoLabel;

    public CardValidator (){

        super ("Credit Card Validator");
        setContentPane(RootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        Validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ccNumber = creditCardNumberField.getText();
                boolean valid = isVisaNumberValid (ccNumber);
                if (valid){
                    InfoLabel.setText("Credit Card Number is valid");
                }else{
                    InfoLabel.setText("Credit Card Number is NOT valid");
                }
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }



    private boolean isVisaNumberValid(String ccNumber){
        if (!ccNumber.startsWith("4") || (ccNumber.length() != 16)){
            System.out.println("Doesn't start with 4 or length wrong");
            return false;
        }

        int sum = 0;

        for (int i = 0; i < 16 ; i++ ) {
            int thisDigit = Integer.parseInt((ccNumber.substring(i, i+1)));
            if (i % 2 == 1) {
                sum = sum + thisDigit;
            } else {
                int doubled = thisDigit * 2;
                if (doubled > 9 ) {
                    int toAdd = 1 + (doubled % 10);
                    sum = sum + toAdd;
                } else {
                    sum = sum + (thisDigit * 2);
                }
            }
        }

        if (sum % 10 == 0) {
            return true;
        }

        return false;


    }
}

