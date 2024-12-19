package ASD.latihan4;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LatQueue {
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList();
        q.add(2);
        q.add(5);
        System.out.println(q.toString());
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.toString());

        PriorityQueue pq=new PriorityQueue();
        pq.add("kambing");
        pq.add("ayam");
        pq.add("kjdskjdhsjks");
        System.out.println(pq.toString());
        System.out.println(pq.peek());

        PriorityQueue<Integer> pq1=new PriorityQueue<>(Collections.reverseOrder());
        pq1.add(28);
        pq1.add(67);
        pq1.add(55);
        System.out.println(pq1.peek());
        System.out.println(pq1.toString());
        System.out.println(pq1.remove());
        System.out.println(pq1.toString());
    }
}
