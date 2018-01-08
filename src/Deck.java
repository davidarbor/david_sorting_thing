import java.util.Arrays;
import java.util.Collections;

public class Deck{
    Card[] allCards;
    private Card[] hand=new Card[7];


    public Deck(boolean x){
        int count=0;
        if(x){
            allCards=new Card[52];
            for(int i=0; i<=3; i++){
                for(int j=0; j<=12; j++){
                    allCards[count]=new Card(i, j);
                    count++;
                }
            }
        }
        else{
            allCards=new Card[13];
            for(int k=0; k<=12; k++){
                allCards[count]=new Card(0, k);
                count++;
            }
        }
    }

    public Card[] getDeck(){
        return allCards;
    }
    public void swap(int first, int second){
        Card temp=allCards[first];
        allCards[first]=allCards[second];
        allCards[second]=temp;
    }
    public void dealHand(int numCards){
        for(int i=0; i<numCards; i++){
            hand[i]=allCards[i];
        }
    }
    public Card[] listHand(){
        return hand;
    }
    public void shuffleDeck(){
        Collections.shuffle(Arrays.asList(allCards));
    }
    public Card[] bubbleSort(){
        int y=allCards.length;
        for(int j=0; j<y; j++){
            for(int i=0; i<y-1; i++){
                if(allCards[i].getValue()>allCards[i+1].getValue()){
                    swap(i, i+1);
                }
            }
        }
        return allCards;
    }
    public Card[] selectionSort(){
        int firstValue=allCards[0].getValue();
        for(int i=0; i<allCards.length; i++){
            if(firstValue>allCards[i].getValue()){
                swap(0, i);
            }
        }
        return allCards;
    }
    public void mergeSortHand(){
        mergeSort(hand);
    }
    public static Card[] leftHalf(Card[] array){
        int size=array.length/2;
        Card[] left=new Card[size];
        for(int i=0; i<size; i++){
            left[i]=array[i];
        }
        return left;
    }
    public static Card[] rightHalf(Card[] array){
        int size=array.length/2;
        int sizeB=array.length-size;
        Card[] right=new Card[sizeB];
        for(int i=0; i<=sizeB-1; i++){
            right[i]=array[i-1+sizeB];
        }
        return right;
    }
    public void mergeSort(Card[] array){
        if(array.length>2){
            Card[] left=leftHalf(array);
            Card[] right=rightHalf(array);
            mergeSort(leftHalf(array));
            mergeSort(right);
            merge(array, left, right);
        }
    }
    public static void merge(Card[] result, Card[] left, Card[] right){
        int indexLeft=0;
        int indexRight=0;
        for(int i=0; i<result.length; i++){
            if(indexRight>=right.length || (indexLeft<left.length && left[indexLeft].getValue()<=right[indexRight].getValue())){
                result[i]=left[indexLeft];
                indexLeft++;
            }
            else{
                result[i]=right[indexRight];
                indexRight++;
            }
        }
    }
    public int binarySearch(Card[] arr, int l, int r, int x){
        if(r>=l){
            int mid=l+(r-l)/2;
            //If the element is present at the middle itself
            if(arr[mid].getValue()==x){
                return mid;
            }
            // If element is smaller than mid, then it can only be present in left subarray
            if(arr[mid].getValue()>x){
                return binarySearch(arr, l, mid-1, x);
            }
            // Else the element can only be present in right subarray
            return binarySearch(arr, mid+1, r, x);
        }
        // We reach here when element is not present in array
        return -1;
    }
}