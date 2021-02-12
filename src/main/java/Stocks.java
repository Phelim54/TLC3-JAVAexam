import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stocks extends Products implements  MontrealTradedProducts{

private String ticker;
private String exchange;

    public Stocks(double price, String productID, String ticker, String exchange) {
        super(price, productID);
        this.ticker = ticker;
        this.exchange = exchange;
    }

    public Stocks(double price, String productID, int quantity) {
        super(price, productID, quantity);
    }

    public Stocks(double price, String productID) {
        super(price, productID);
    }

    public Stocks() {
        super();
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public List<Products> stockList = new ArrayList<>();

    public List<Products> getProductList(){
        return  stockList;
    }

    @Override
    public void addNewProduct(Products product) throws ProductAlreadyRegisteredException {
        List<Products> stocks = stockList
                .stream()
                .filter(s -> s.getProductID() == product.getProductID())
                .collect(Collectors.toList());

        if (stocks.isEmpty()) {
            stockList.add(product);
        } else {
            // throw an exception
            throw new ProductAlreadyRegisteredException("This stock with this product id : " + product.getProductID() + " already exists.");
        }
    }

    @Override
    public void trade(Products product, int quantity) throws ProductDoesNotExistException {

        Optional<Products> stocks =  stockList.stream().filter(products -> product.getProductID() == products.getProductID()).findFirst();

        if (stocks.isEmpty()){
            throw new ProductDoesNotExistException("This product has not been registered so kindly do so");
        }else{
            stocks.stream().map(Products::getQuantity);
        }

    }

    @Override
    public int totalTradeQuantityForDay() {
        int totalTradeQuantity= stockList.stream().map(Products::getQuantity).reduce(0,(x,y)->x+y);
        return totalTradeQuantity;
    }

    @Override
    public double totalValueOfDaysTradedProducts() {
        double totalValueTraded = getPrice() * totalTradeQuantityForDay();
        return totalValueTraded;
    }
}
