import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MyList<Integer> myList=new MyList<>();
        System.out.println(myList.isEmpty());
        System.out.println("Size : "+myList.size());
        System.out.println("Kapasite : " +myList.getCapacity());
        for (int i=0;i<10;i++){
            myList.add(i);
        }
        System.out.println("Size : "+myList.size());
        System.out.println("Kapasite : " +myList.getCapacity());
        System.out.println(myList.toString());
        myList.add(44);
        myList.set(6,-123);
        System.out.println(myList);
        System.out.println(myList.contains(-123));
        myList.clear();
        System.out.println(myList.toString());
        System.out.println(myList.isEmpty());
    }
}
