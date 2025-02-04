package DESIGNPATTERNS.strategy;

class SortingContext {
    SortingStrategy strategy;
    SortingContext(SortingStrategy strategy){
        this.strategy = strategy;
    }

    public void performSort(int[] arr){
        this.strategy.sort(arr);
    }
}


interface SortingStrategy{
    void sort(int[] arr);
}

class BubbleSortingStrategy implements SortingStrategy{
    public void sort(int[] arr){
        System.out.printf("Yo BubbleSortingStrategy");
    }
}

class MergeSortingStrategy implements SortingStrategy{
    public void sort(int[] arr){
        System.out.printf("Yo MergeSortingStrategy");
    }
}

public class Test{
    public static void main(String args[]){
        SortingContext sc = new SortingContext(new BubbleSortingStrategy());
        sc.performSort(new int[]{1,2,3});
    }
}