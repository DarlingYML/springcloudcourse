/**
 * @author MagicBook
 */
public class Producer extends Thread {
    private int needNum;
    private WareHouse wareHouse;

    public Producer(int needNum, WareHouse wareHouse) {
        this.needNum = needNum;
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        this.wareHouse.produce(needNum);
    }
}
