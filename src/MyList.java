import java.util.ArrayList;
import java.util.Arrays;

public class MyList <T>{
    private int capacity=10;
    private T[] array;
    private T[] tempArray;

    //Boş constructor metod. Kullanılırsa dizinin kapasitesi 10 olur.
    public MyList(){
        this.array= (T[]) new Object[capacity];
    }

    //Dizinin kapasitesini parametreden alan constructor metod
    public MyList(int capacity){
        this.capacity=capacity;
        this.array=(T[]) new Object[this.capacity];
    }

    //dizinin kapasite değerini döndürür
    public int getCapacity() {
        return capacity;
    }

    //kapasite değerini değiştiren metod
    public void setCapacity(int capacity){
        this.capacity=capacity;
        array=(T[]) new Object[this.capacity];
    }

    //dizinin eleman sayısını verir
    public int size() {
        int siz = 0;
        for (int i = 0; i < getCapacity(); i++) {
            if (array[i] != (null)) {
                siz++;
            }
        }
        return siz;
    }

    //Diziye eleman ekleme metodu. Eğer dizide kapasite yok ise dizinin boyutunu 2 katına cıkarır
    public void add(T object) {
        if (size() >= getCapacity()) { //dizi boyutu dolu ise
            this.tempArray = this.array;
            setCapacity(getCapacity() * 2);
            this.array = (T[]) new Object[getCapacity()];
            this.array = Arrays.copyOf(this.tempArray, getCapacity());
        }
        this.array[size()] = object;
    }


    // dizinin indexteki değerini döndürür
    public T get(int index){
        if(isInvalidIndex(index)){
            return null;
        }
        return this.array[index];
    }

    public T remove(int index){
        if(isInvalidIndex(index)){
            return null;
        }
        //indexi sil ve sola kaydır.
        T[] temp=this.array;
        this.array[index]=null;
        for (int i=index;i<size();i++){
            if(size()-i==1) this.array[i]=null;
            else this.array[i]=temp[i+1];
        }
        return this.array[index];
    }

    //verilen indexteki değeri değiştirir.
    public T set(int index,T object){
        if(isInvalidIndex(index)){
            return null;
        }
        this.array[index]=object;
        System.out.println("Değiştirme işlemi yapıldı.");
        return this.array[index];
    }

    //geçerli index değeri var mı yok mu kontrolü sağlayan metod.
    public boolean isInvalidIndex(int index){
        return size()<index;
    }

    //dizi elemanlarını listeler
    @Override
    public String toString() {
        return "MyList{" +
                "dizi=" + Arrays.toString(array) +
                '}';
    }

    //verilen nesnenin ilk hangi indexte olduğuna bakar.
    public int indexOf(T object){
        for (int i = 0; i < size(); i++) {
            if(this.array[i]==object) {
                return i;
            }
        }
        return -1;
    }

    // verilen nesnenin en son hangi indexte oldugunu verir.
    public int lastIndexOf(T object){
        for (int i=size()-1;i>=0;i--){
            if(this.array[i]==object){
                return i;
            }
        }
        return -1;
    }

    //dizinin boş olup olmamasına bakan metod.
    public boolean isEmpty(){
        return size()==0;
    }

    //diziyi dönen metod, böylelikle baska bir atama yapılabilir.
    public T[] toArray(){
        return this.array;
    }

    //listeyi siler
    public void clear(){
        this.array=(T[]) new Object[getCapacity()];
    }

    public MyList<T> subList(int start, int finish){
        if(start>finish){
            int temp=finish;
            finish=start;
            start=temp;
        }
        MyList<T> list=new MyList<>(finish-start+1);
        for(int i=start;i<=finish;i++){
            list.add(this.array[i]);
            System.out.println("ss");
        }
        return list;
    }

    public boolean contains(T object){
        for(T obj:this.array){
            if(obj.equals(object)){
                return true;
            }
        }
        return false;
    }
}
