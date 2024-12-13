package factory;


// Product interface
interface Product {
    void use();
}

// Concrete Products
class ProductA implements Product {
    public void use() {
        System.out.println("Using Product A");
    }
}

class ProductB implements Product {
    public void use() {
        System.out.println("Using Product B");
    }
}

// Creator
public abstract class Factory {
    abstract Product createProduct();

    void useProduct() {
        Product product = createProduct();
        product.use();
    }
}

// Concrete Creators
class FactoryA extends Factory {
    Product createProduct() {
        return new ProductA();
    }
}

class FactoryB extends Factory {
    Product createProduct() {
        return new ProductB();
    }
}

// Usage
 class FactoryPatternDemo {
    public static void main(String[] args) {
        Factory factoryA = new FactoryA();
        factoryA.useProduct(); // Output: Using Product A

        Factory factoryB = new FactoryB();
        factoryB.useProduct(); // Output: Using Product B
    }
}
