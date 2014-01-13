package moneycalculator.persistance;

import java.util.Date;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;


public class MockExchangeRateLoader implements ExchangeRateLoader{
    
    
    public ExchangeRate load(Currency from, Currency to, Date date){
        moneycalculator.model.Number rate = new moneycalculator.model.Number(1.5);
        return new ExchangeRate (from,to,rate,date);
    }
    public ExchangeRate load(Currency from, Currency to){
        return load(from,to,new Date());
    }
}