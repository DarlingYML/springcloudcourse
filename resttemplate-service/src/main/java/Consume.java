/**
 * @author MagicBook
 */
public class Consume extends Thread {
    private int needNum;
    private WareHouse wareHouse;

    public Consume(int needNum, WareHouse wareHouse) {
        this.needNum = needNum;
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        this.wareHouse.consume(needNum);
    }
}
