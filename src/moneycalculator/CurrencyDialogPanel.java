package moneycalculator;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import moneycalculator.model.Currency;
import moneycalculator.ui.CurrencyDialog;

public class CurrencyDialogPanel extends JPanel implements CurrencyDialog{

    //private Currency currency;
    private String currency;
    
    public CurrencyDialogPanel() {
        super(new FlowLayout(FlowLayout.LEFT));
        this.add(createComboBox());
        this.currency = "EUR";
    }

    private JComboBox createComboBox() {
        final JComboBox comboBox = new JComboBox (new String [] {"EUR", "USD"});
        comboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                if(ie.getStateChange() != ItemEvent.SELECTED) return;
                currency = (String) comboBox.getSelectedItem();
            }
        });
        return comboBox;
    }

    @Override
    public Currency getCurrency() {
        return new Currency(currency);
    }
    
    

}
