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
                    System.out.println(allCards[count].getName());
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
            mergeSort(rightHalf(array));
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
    public void binarySearchHand(int searchFace, int searchSuit){
        binarySearch(hand, searchFace, searchSuit);
    }
    public void binarySearch(Card[] arr, int searchFace, int searchSuit){

        if(searchSuit==arr[arr.length /2].getSuit() && searchFace==arr[arr.length /2].getValue()){
            System.out.println("Found card "+arr[arr.length/2].getName());
        }
        else if(arr.length==1){
            System.out.println(new Card(searchSuit, searchFace).getName()+" not in hand");
        }
        else if(searchSuit<arr[arr.length /2].getSuit() || searchFace<arr[arr.length /2].getValue()){
            binarySearch(leftHalf(arr), searchFace, searchSuit);
        }
        else if(searchSuit>arr[arr.length /2].getSuit() || searchFace>arr[arr.length /2].getValue()){
            binarySearch(rightHalf(arr), searchFace, searchSuit);
        }
    }
}