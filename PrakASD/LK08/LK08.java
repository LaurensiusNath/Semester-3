package PrakASD.LK08;


import java.util.Scanner;

class HeapTree {

    private int[] Heap;
    int size;
    private int maxsize;


    public HeapTree(int maxsize)
    {

        this.maxsize = maxsize;
        this.size = 0;

        Heap = new int[this.maxsize + 1];
    }

    private int parent(int pos){
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos)
    {

        if (pos > (size / 2)) {
            return true;
        }

        return false;
    }

   private boolean ifExist(int element){
        for (int e : Heap){
            if (element==e) {
                return true;
            }
        }
       return false;
   }

   int getPos(int element){
        if(ifExist(element)) {
            for (int i = 1; i <= size; i++) {
                if (Heap[i] == element) {
                    return i;
                }
            }
        }
        return -1;
   }

    private void swap(int fpos, int spos)
    {

        int tmp;
        tmp = Heap[fpos];

        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void minHeapify(int pos)
    {
        if(!isLeaf(pos)){
            int swapPos= pos;
            if(rightChild(pos)<=size) {
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swapPos = leftChild(pos);
                } else {
                    swapPos = rightChild(pos);
                }
            }
            else {
                swapPos = leftChild(pos);
            }

            if(Heap[pos]>Heap[leftChild(pos)] || Heap[pos]> Heap[rightChild(pos)]){
                swap(pos,swapPos);
                minHeapify(swapPos);
            }

        }
    }

    public void insert(int element)
    {

        if (size >= maxsize || ifExist(element)) {
            return;
        }

        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int getMin(){
        if (size==0){
            return -1;
        }
        else {
            int i = Integer.MAX_VALUE;
            for (int n=1;n<=size;n++){
                if (Heap[n]<i && Heap[n]!=0){
                    i=Heap[n];
                }
            }
            return i;
        }
    }

    void reArrange(int start) {
        for (int i = start; i < size; i++) {
            Heap[i] = Heap[i + 1];
        }
    }

    public void remove(int element)
    {
        int pos = getPos(element);
        if (pos!=-1){
            if (pos==size){
                size--;
            }
            else {
                reArrange(pos);
                size--;
            }
            }
    }
}

public class LK08 {
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        scan.nextLine();
        HeapTree tree = new HeapTree(i);
        for (int n=0;n<i;n++){
            String str = scan.nextLine();
            String[] strperkata = str.split(" ");
            switch (Integer.parseInt(strperkata[0])){
                case 1:
                    tree.insert(Integer.parseInt(strperkata[1]));
                    break;
                case 2:
                    tree.remove(Integer.parseInt(strperkata[1]));
                    break;
                case 3:
                    System.out.println(tree.getMin());
            }
        }
    }
}
