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
        MyList<Integer> myList1;
        myList1=myList.subList(3,7);
        System.out.println(myList1);
    }
}
