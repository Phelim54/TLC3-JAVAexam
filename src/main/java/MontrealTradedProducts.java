public interface MontrealTradedProducts {

    void addNewProduct(Products product) throws ProductAlreadyRegisteredException;
    void trade(Products product, int quantity) throws ProductDoesNotExistException;
    int totalTradeQuantityForDay();
    double totalValueOfDaysTradedProducts();



}
