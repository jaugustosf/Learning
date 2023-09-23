package entities.usingContructors.usingEncapsulamento;

public class Product {
    public String name;
    public double price;
    public int quantity;

    public Product() {
    }

    //É uma forma de obrigar a declaração de todos os atributos iniciais da classe na hora do instanciamento.
    public Product(String name, double price, int quantity){
        this.name = name; //O this faz o diferenciamento do atributo name, para ele não apontar para o argumento.
        this.price = price;
        this.quantity = quantity;
    }

    //Fazendo sobrecarga de construtores, eu faço com que eu possa cadastrar um produto sem informar a quantidade de itens.
    public Product(String name, double price){
        this.name = name; //O this faz o diferenciamento do atributo name, para ele não apontar para o argumento.
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double totalValueInStock(){
        return price * quantity;
    }

    public void addProducts(int quantity){
        this.quantity += quantity; // Esse this faz com que especifique que nos queremos referenciar o objeto da classe e não o parametro.
    }

    public void removeProducts(int quantity){
        this.quantity -= quantity;
    }

    public String toString(){
        return String.format("%s, R$%.2f, %d units, Total: R$%.2f",name, price, quantity, totalValueInStock());
    }
}
