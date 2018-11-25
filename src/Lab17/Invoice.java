package Lab17;

public class Invoice {
    private String invNumber;
    private Item[] itemList;
    private int itemCount;

    public Invoice(String invNumber, int itemNum) {
        this.invNumber = invNumber;
        itemList = new Item[itemNum];
        itemCount = 0;
    }

    public String getInvNumber() {
        return invNumber;
    }

    public Item[] getItemList() {
        return itemList;
    }

    public int getItemCount() {
        return itemCount;
    }

    public Item getItem(int index) {
        return itemList[index];
    }

    public void addItem(String productCode, double price, int quantity) {
        if (itemCount < itemList.length) {
            Item item = new Item(productCode, price, quantity);
            itemList[itemCount] = item;
            itemCount++;
        } else {
            System.out.println("Failed to add new item; max already");
        }
    }
}