package entities;

public class Product {
    public String name;
    public double price;
    public int quantity;

    public double totalValueInStock(){
        return price * quantity;
    }

    public void addProducts(int quantity){
        this.quantity += quantity; // Esse this faz com que especifique que nos queremos
                                   // referenciar o objeto da classe e não o parametro.
    }

    public void removeProducts(int quantity){
        this.quantity -= quantity;
    }

    public String toString(){
        return String.format("%s, R$%.2f, %d units, Total: R$%.2f",name, price, quantity, totalValueInStock());
    }
}
