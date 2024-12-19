package PrakASD.latihan1;
public class GenericClass <T>{
    private T isi;

    public GenericClass(){

    }
    public GenericClass(T isi){
        this.isi=isi;
    }

    public void setIsi(T isi) {
        this.isi = isi;
    }

    public void getStatus() {
        System.out.println(isi);
    }

}

class MainGeneric{
    public static void main(String[] args) {
        GenericClass<String> itemString = new GenericClass<>("String");
        itemString.getStatus();

        GenericClass<Integer> itemInteger = new GenericClass<>(10);
        itemInteger.getStatus();

        GenericClass<Boolean> itemBoolean = new GenericClass<>(true);
        itemBoolean.getStatus();

        GenericClass<Character> itemChar = new GenericClass<>();
        itemChar.setIsi('A');
        itemChar.getStatus();
    }
}
