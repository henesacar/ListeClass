import java.util.Arrays;

public class Liste<T> {

    private T[] myliste;
    private int size;

    public Liste() {
        this.myliste = (T[]) new Object[10];
    }

    public Liste(int size) {
        this.myliste = (T[]) new Object[size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T[] getMyliste() {
        return myliste;
    }

    public void setMyliste(T[] myliste) {
        this.myliste = myliste;
    }

    public void size() {
        int count = 0;
        for (T x : this.getMyliste()) {
            if (x != null) {
                count += 1;
            }
        }
        setSize(count);
        System.out.println("Dizideki eleman sayısı: " + count);
    }

    public void getCapacity() {
        int capacity = this.getMyliste().length;

        System.out.println("Dizi kapasitesi: " + capacity);

    }

    public void add(T data) {
        int arrItemCount = 0;
        for (T i : this.getMyliste()) {
            if (i != null)
                arrItemCount += 1;
        }
        if (arrItemCount == this.getMyliste().length) {
            System.out.println("Mevcut dizinin limiti doldu. Yeni dizi oluşturuluyor..");
            int oldArrayLength = this.getMyliste().length;
            T[] newArray = (T[]) new Object[oldArrayLength * 2];
            System.out.println("Önceki dizi değeri: " + oldArrayLength + ", Yeni dizi değeri: " + newArray.length);
            for (int i = 0; i < this.getMyliste().length; i++) {
                newArray[i] = this.getMyliste()[i];
            }
            this.setMyliste(newArray);
            this.myliste[arrItemCount] = data;
        } else {
            this.myliste[arrItemCount] = data;
        }

    }

    public void get(int i) {
        if (i > getSize()) {
            System.out.println(i + ". indiste bulunan değer: (null)");
        } else {
            System.out.println(i + ".  indiste bulunan değer: " + this.getMyliste()[i]);
        }

    }

    public void remove(int i) {
        T[] newListe = (T[]) new Object[this.getMyliste().length - 2];
        for (int a = 0, b = 0; a < this.getMyliste().length - 1; a++) {
            if (a == i) {
                continue;
            } else {
                newListe[b++] = this.getMyliste()[a];
            }
        }
        setMyliste(newListe);

    }

    public void set(int i, T data) {
        if (i > this.getMyliste().length) {
            System.out.println("Geçersiz indis değeri girdiniz. (null)");
        } else {
            this.getMyliste()[i] = data;
        }
    }


    @Override
    public String toString() {
        String elems = "";
        for (T x : this.getMyliste()
        ) {
            elems += x + " ";
        }

        return elems;
    }

    public int indexOf(T data) {
        for (int i = 0; i < this.getMyliste().length; i++) {
            if (this.getMyliste()[i] == data) {
                return i;
            } else {
                continue;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = (this.getMyliste().length - 1); i >= 0; i--) {
            if (this.getMyliste()[i] == data) {
                return i;
            } else {
                continue;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        for (int i = 0; i < this.getMyliste().length; i++) {
            if (this.getMyliste()[i] != null) {
                System.out.println("Liste dolu.");
                return true;
            } else {
                System.out.println("Liste boş");
                return false;
            }
        }
        return false;
    }

    public T[] toArray() {
        T[] arr = (T[]) new Object[this.getMyliste().length];
        for (int i = 0, b = 0; i < this.getMyliste().length; i++) {
            if(this.getMyliste()[i] != null){
            arr[i] = this.getMyliste()[i];}
        }
        return arr;
    }

    public void clear(){
        for (int i = 0;i<this.getMyliste().length;i++){
            this.getMyliste()[i] = null;
            System.out.print(this.getMyliste()[i] + " ");
        }

    }

    public T[] sublist(int start,int finish){
        T[] arr = (T[]) new Object[finish-start+1];
        if(start<finish){
            for(int i =0,a=start;i <arr.length;i++){
                arr[i] = this.getMyliste()[a++];
            }
        }
        return arr;
    }

    public boolean contains(T data){
        for (int i = 0;i<this.getMyliste().length;i++){
            if (this.getMyliste()[i] == data){
                System.out.println(data+ " öğesi listede mevcut.");
                return true;
            }
        }
        System.out.println(data+ " öğesi listede mevcut değil.");
        return false;
    }


}



