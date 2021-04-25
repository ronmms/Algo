public class Stuff {
    
    private int price = 1;
    private int weight = 1;

    public Stuff(int price, int weight){
        setPrice(price);
        setWeight(weight);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if(price > 0)
            this.price = price;
        else
            this.price = 1;    
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if(weight > 0)
            this.weight = weight;
        else
            this.weight = 1;    
    }

   
}
