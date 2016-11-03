/**
 * Created by thomas on 10/29/16.
 */
public class Order {
    private String deliveryAddress;
    private String city;
    private String state;
    private String zip;
    private String nameOnOrder;
    private String itemOrdered;
    private String itemCatagory;

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public String getZip() { return zip; }

    public void setZip(String zip) { this.zip = zip; }

    public String getNameOnOrder() {
        return nameOnOrder;
    }

    public void setNameOnOrder(String nameOnOrder) {
        this.nameOnOrder = nameOnOrder;
    }

    public String getItemOrdered() {
        return itemOrdered;
    }



    public void setItemOrdered(String itemOrdered) {
        this.itemOrdered = itemOrdered;
    }

    public String getItemCatagory() {
        return itemCatagory;
    }

    public void setItemCatagory(String itemCatagory) {
        this.itemCatagory = itemCatagory;
    }
}
