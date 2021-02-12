import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


class StocksTest {

    @Test
    void stocksCanBeAddedtoProduct() throws ProductAlreadyRegisteredException{
        Products products = mock(Products.class);
        Stocks stocks = new Stocks();

       stocks.addNewProduct(products);






    }

    @Test
    void trade() {
    }

    @Test
    void totalTradeQuantityForDay() {
    }

    @Test
    void totalValueOfDaysTradedProducts() {
    }
}