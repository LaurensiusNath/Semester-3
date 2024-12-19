package PrakASD.LKQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LKQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int thread = scan.nextInt();
        scan.nextLine();
        Queue<String> task = new LinkedList();
        while (true) {
            String input = scan.nextLine();
            if (input.equals("START")) {
                int taskJalan;
                int sisaThread;
                taskJalan=Math.min(thread,task.size());
                if(taskJalan>0){
                    for (int i=0;i<taskJalan;i++){
                        System.out.println("task "+task.poll()+" done");
                    }
                }
                sisaThread=thread-taskJalan;
                System.out.println(sisaThread+" idle thread");
            } else if (input.equals("DONE")) {
                System.out.println("task left:");
                if (!task.isEmpty()){
                    int iteration= task.size();
                    for (int i =0;i< iteration;i++){
                        System.out.println("task "+task.poll());
                    }
                    System.exit(0);
                }
                else {
                    System.exit(0);
                }
            } else{
                task.offer(input);
            }
        }
    }
}
