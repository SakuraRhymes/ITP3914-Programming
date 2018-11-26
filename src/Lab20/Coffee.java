package Lab20;

public class Coffee extends Drink {
    protected boolean isSweet;

    public Coffee (String name, int price, int volume, boolean isSweet){
        super(name, price, volume);
        this.isSweet = isSweet;
    }

    public String toString(){
        return super.toString() + (isSweet?", sweet":", not sweet");
    }

    public void setPrice(int price){
        if (price < 10)
            super.setPrice(10);
        else
            super.setPrice(price);
    }
}