package moneycalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {

    public static void main(String[] args) {

        final CommandDictionary commandDictionary = new CommandDictionary();
        ActionListenerFactory factory = new ActionListenerFactory() {

            @Override
            public ActionListener getAction(final String action) {
                return new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        commandDictionary.get(action).execute();
                    }
                };
            }
        };
        final ApplicationFrame frame = new ApplicationFrame(factory);
        commandDictionary.register("calculate", new CalculateCommand(frame.getMoneyDialog(), frame.getCurrencyDialog()));
        commandDictionary.register("exit", new Command() {

            @Override
            public void execute() {
                frame.dispose();
            }
        });
        
        //MainFrame mainFrame = new MainFrame();
        
        
        /*System.out.println("*****   MONEY CALCULATOR  *****");
        System.out.println("Como prueba solo está disponible el cambio entre euros y dollar americano");
        CurrencySetLoader.getInstance().load();
        ExchangeMoneyControl control = new ExchangeMoneyControl(
                createExchangeRateLoader(),
                createCurrencyDialog(),
                createMoneyDialog(),
                createMoneyViewer());
        control.execute();

    }

    private static ExchangeRateLoader createExchangeRateLoader() {
        return new MockExchangeRateLoader();
    }

    private static CurrencyDialog createCurrencyDialog() {
        return new ConsoleCurrencyDialog();
    }

    private static MoneyDialog createMoneyDialog() {
        return new ConsoleMoneyDialog();
    }

    private static MoneyViewer createMoneyViewer() {
        return new ConsoleMoneyViewer();*/
    }
}
