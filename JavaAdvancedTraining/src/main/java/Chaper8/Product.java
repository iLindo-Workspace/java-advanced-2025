package Chaper8;

import javax.naming.LimitExceededException;

/**
 * @author Lindokuhle Makanda
 * This class will throw exceptions based on the following rules
 * - A product description should be at lest 5 characters long
 * - Price cannot be zero or negative
 * - Quantity to sell cannot be more than Quantity in stock
 * - The price increase should be less than R10
 */
public class Product {


    private String code,description;
    private double price;
    private int quantityInStock;

    public Product(String code, String description, double price, int quantityInStock)  {
        setCode(code);
        setDescription(description);
        setPrice(price);
        setQuantityInStock(quantityInStock); ;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) throws IllegalArgumentException {
        if(description.length() < 5){
            throw new IllegalArgumentException("Description should be at least 5 characters long. "
            + "\nCurrent description [" + description + "]");
        }
        this.description = description;
    }

    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException("Price cannot be 0 or negative\n" +
                    "Current price [" + price + "]");
        }
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void sell(int quantityToSell) throws LowStockException {
        if(getQuantityInStock() < quantityToSell){
            throw new  LowStockException("Not enough quantity to sell. "
            + getDescription() + " \nCurrent Quantity In Stock: " + getQuantityInStock() +
                    "\nRequested quantity to sell: " + quantityToSell);
        }
        setQuantityInStock(getQuantityInStock() - quantityToSell);
    }

    public void increasePrice(double percentage){
        double increase = getPrice() * (percentage / 100);
        if( increase >= 10){
            throw new HighPriceIncreaseException("The price increase on " + getDescription() +
                    " is too high [R"  + increase + "]" +
                    "\nThe increase should be less than R10.00");
        }
        setPrice(getPrice() + increase);
    }

    @Override
    public String toString() {
        return String.format("""
                
                ===== Product Details for %s [%s] =====
                
                Code: %s
                Description: %s
                Price: R%.2f
                Quantity In Stock: %d
                
                """,getDescription(),getCode(),getCode(), getDescription(), getPrice(), getQuantityInStock());
    }
}
