/**
 * @author MagicBook
 */
public class Test {
    public static void main(String[] args) {
        WareHouse wareHouse=new WareHouse(20);
        Consume consume1=new Consume(20,wareHouse);
        Consume consume2=new Consume(30,wareHouse);
        Consume consume3=new Consume(10,wareHouse);
        consume1.setName("consume1");
        consume2.setName("consume2");
        consume3.setName("consume3");
        Producer producer1=new Producer(10,wareHouse);
        Producer producer2=new Producer(10,wareHouse);
        Producer producer3=new Producer(10,wareHouse);
        Producer producer4=new Producer(10,wareHouse);
        producer1.setName("producer1");
        producer2.setName("producer2");
        producer3.setName("producer3");
        producer4.setName("producer4");
        consume1.start();
        consume2.start();
        consume3.start();
        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
    }
}
