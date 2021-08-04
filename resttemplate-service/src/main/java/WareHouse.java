public class WareHouse {
    private final int MAX_SIZE=100;
    private int currentNum;

    public WareHouse(int currentNum) {
        this.currentNum = currentNum;
    }
    public synchronized void produce(int needNum){
        while (true){
            while (this.currentNum+needNum>this.MAX_SIZE){
                System.out.println(Thread.currentThread().getName()+"要生产的产品数量"+needNum+"已经超过剩余库存数量"+(this.MAX_SIZE-this.currentNum)+"");
                try {
                    this.wait(200);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            // 满足生产条件，进行生产
            this.currentNum+=needNum;
            System.out.println(Thread.currentThread().getName() + "已经生产了" + needNum + ",现在的库存是：" + this.currentNum);
            // 唤醒在此对象监视器上等待的所有线程
            this.notify();
        }
    }
    public synchronized void consume(int needNum){
        while (true){
            while (this.currentNum<needNum){
                System.out.println(Thread.currentThread().getName()+"要消费的产品数量"+needNum+"已经超过剩余库存数量"+this.currentNum+"");
                try {
                    // 不需要消费释放锁，进入等待队列
                    this.wait(200);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            // 满足生产条件，进行生产
            this.currentNum-=needNum;
            System.out.println(Thread.currentThread().getName() + "已经消费了" + needNum + ",现在的库存是：" + this.currentNum);
            // 唤醒在此对象监视器上等待的所有线程
            this.notify();
        }
    }
}
