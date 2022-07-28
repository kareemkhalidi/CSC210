
public class PA7 {

    public static void main(String args[]) {

        ListQueue<String> q = new ListQueue<String>();
        q.enqueue("1");
        q.enqueue("2");
        q.enqueue("3");

        ListQueue<String> q2 = new ListQueue<String>();
        q2.enqueue("1");
        q2.enqueue("2");
        q2.enqueue("3");

        System.out.println(q.equals(q2));

    }

}
