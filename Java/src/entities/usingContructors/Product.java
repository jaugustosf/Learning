package entities.usingContructors;

public class Product {
    public String name;
    public double price;
    public int quantity;

    //É uma forma de obrigar a declaração de todos
    //os atributos iniciais da classe na hora do instanciamento.
    public Product(String name, double price, int quantity){
        this.name = name; //O this faz o diferenciamento do atributo name, para ele não apontar para o argumento.
        this.price = price;
        this.quantity = quantity;
    }

    //Fazendo sobrecarga de construtores, eu faço com que eu possa cadastrar um produto
    //Sem informar a quantidade de itens.
    public Product(String name, double price){
        this.name = name; //O this faz o diferenciamento do atributo name, para ele não apontar para o argumento.
        this.price = price;
    }
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
