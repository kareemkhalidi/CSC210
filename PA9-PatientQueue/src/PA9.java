
public class PA9 {

    public static void main(String args[]) throws Exception {

        PatientQueue q = new PatientQueue();
        q.enqueue("anat", 4);
        q.enqueue("ben", 9);
        q.enqueue("sasha", 8);
        q.enqueue("wu", 7);
        q.enqueue("rein", 6);
        q.enqueue("ford", 2);
        System.out.println(q.toString());
        q.changePriority("zach", 10);
        System.out.println(q.toString());

    }

}
