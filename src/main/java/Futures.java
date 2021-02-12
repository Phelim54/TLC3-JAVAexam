import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Futures extends Products implements  MontrealTradedProducts{

    private String exchange;
    private String contractCode;
    private int month;
    private int year;

    public Futures(double price, String productID, String exchange, String contractCode, int month, int year) {
        super(price, productID);
        this.exchange = exchange;
        this.contractCode = contractCode;
        this.month = month;
        this.year = year;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public List<Products> futuresList = new ArrayList<>();

    public List<Products> getProductList(){
        return  futuresList;
    }

    @Override
    public void addNewProduct(Products product) throws ProductAlreadyRegisteredException {
        List<Products> futures = futuresList
                .stream()
                .filter(f -> f.getProductID() == product.getProductID())
                .collect(Collectors.toList());

        if (futures.isEmpty()) {
            futuresList.add(product);
        } else {
            // throw an exception
            throw new ProductAlreadyRegisteredException("This futures with this product id : " + product.getProductID() + " already exists.");
        }
    }


    @Override
    public void trade(Products product, int quantity) throws ProductDoesNotExistException {

        Optional<Products> futures =  futuresList.stream().filter(products -> product.getProductID() == products.getProductID()).findFirst();

        if (futures.isEmpty()){
            throw new ProductDoesNotExistException("This product has not been registered so kindly do so");
        }else{

            futures.stream().map(Products::getQuantity);
        }

    }


    @Override
    public int totalTradeQuantityForDay() {

            int totalTradeQuantity= futuresList.stream().map(Products::getQuantity).reduce(0,(x,y)->x+y);
            return totalTradeQuantity;
        }


    @Override
    public double totalValueOfDaysTradedProducts() {
        double totalValueTraded = getPrice() * totalTradeQuantityForDay();
        return totalValueTraded;
    }
}
