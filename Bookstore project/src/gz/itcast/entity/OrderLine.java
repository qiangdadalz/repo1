package gz.itcast.entity;

/**
 * 订单明细
 * @author APPle
 *
 */
public class OrderLine {
    private Books book;//明细对应的这本书
    private int amt;//该明细的数量
    private double price;//折扣价

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
