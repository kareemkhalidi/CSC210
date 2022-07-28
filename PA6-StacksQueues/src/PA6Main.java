
public class PA6Main {

    public static void main(String args[]) {

        ListQueue q = new ListQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.toString());
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.enqueue(5);
        System.out.println(q.toString());

    }

}
