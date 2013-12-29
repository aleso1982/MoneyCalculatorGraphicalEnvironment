package moneycalculator;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class CurrencyPanel extends JPanel {

    private static final String[] currencies = {"EUR", "USD"};

    public CurrencyPanel() {
        this.add(createComboBox());
    }

    private JComboBox createComboBox() {
        JComboBox comboBox = new JComboBox(currencies);
        return comboBox;
    }

}
