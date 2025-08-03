package testdata;

public class Product {

    String name,brand;
    int qty,price;

    public Product(ProductBuilder productBuilder) {
        this.name = productBuilder.name;
        this.brand = productBuilder.brand;
        this.qty = productBuilder.qty;
        this.price = productBuilder.price;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }


    public static class ProductBuilder{
        String name,brand;
        int qty,price;

        public ProductBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public ProductBuilder setQty(int qty) {
            this.qty = qty;
            return this;
        }

        public ProductBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Product build(){
            //api to create the product

            return new Product(this);


        }

    }
}
