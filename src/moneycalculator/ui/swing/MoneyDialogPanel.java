package moneycalculator.ui.swing;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import moneycalculator.model.Money;
import moneycalculator.ui.CurrencyDialog;
import moneycalculator.ui.MoneyDialog;
import moneycalculator.model.Number;

public class MoneyDialogPanel extends JPanel implements MoneyDialog{

    private Number number;
    private String amount;
    private static JTextField result;
    private CurrencyDialog currencyDialog;

    public MoneyDialogPanel() {
        super(new FlowLayout(FlowLayout.LEFT));
        this.amount = "Introduzca cantidad";
        this.createComponents();
    }

    private JTextField createAmountField() {
        final JTextField textField = new JTextField(12);
        textField.setText(amount);
        textField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                amount = textField.getText();
            }
        });
        return textField;
    }

    private JPanel createCurrencyDialog() {
        CurrencyDialogPanel panel = new CurrencyDialogPanel();
        currencyDialog = panel;
        return panel;
    }

    private void createComponents() {
        this.add(createAmountField());
        result = createDestinationField();
        this.add(result);
        this.add(createCurrencyDialog());
    }

    @Override
    public Money getMoney() {
        number = new Number(Double.parseDouble(amount));
        //return new Money(Double.parseDouble(amount), currencyDialog.getCurrency());
        return new Money(number, currencyDialog.getCurrency());
    }

    private JTextField createDestinationField() {
        final JTextField textFielddestination = new JTextField(12);
        textFielddestination.setText("Cantidad convertida");
        return textFielddestination;
    }   
    public static void refresh(String number){
        result.setText(number);
    }
    @Override
    public void execute() {
    }

}