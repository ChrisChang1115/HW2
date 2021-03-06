import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Scanner;
	/*
	 * ID: B0444140   /TODO: please add student ID here
     * Name: 張宸睿         /TODO: please add student name here
    */

	public class B0444140 {
      public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  System.out.println("input N(deck of cards):");
	  String testn= sc.nextLine(); 
      int nDeck=Integer.parseInt(testn);
	  Deck deck=new Deck(nDeck);
	  deck.printDeck();
	//TODO: please check your output, make sure that you print all cards on your screen
	  
	  if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
	   System.out.println("Well done!");
	  }else{
	   System.out.println("Error, please check your sourse code");
	  }
	 }
	 /*
	  * TODO: This method is used for checking your result, not a part of your HW2
	  */
      private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		 //check the output 
	  boolean isCorrect=true;;
	  HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
	  for(Card card:allCards){
	   int suit = card.getSuit();
	   int rank = card.getRank();
	   if(suit>4||suit<1||rank>13||rank<1){
	    isCorrect=false;
	    break;
	   }
	   if(checkHash.containsKey(suit+","+rank)){
	    checkHash.put(suit+","+rank, 
	      checkHash.get(suit+","+rank)+1);
	   }else{
	    checkHash.put(suit+","+rank, 1);
	   }
      }
	  if(checkHash.keySet().size()==52){
	  for(int value:checkHash.values()){
	   if(value!=nDeck){
	    isCorrect=false;
	   break;
	    }
	   }
	  }else
	  {
	   isCorrect=false;
	  }
	  return isCorrect;
	  }
     }
	/*
	 * Description: TODO: 每13張一回合,4種花色,依序存入數組中
	 */
     class Deck{
	 private ArrayList<Card> cards;
	 //TODO: Please implement the constructor
	 public Deck(int nDeck){
	 cards=new ArrayList<Card>();
	 //TODO: Please implement the method to print all cards on screen
	  for(int i=0;i<nDeck;i++){
	  for(int suit=1; suit<=4; suit++){
	   for(int rank=1; rank<=13; rank++){
	         Card c =new Card(suit,rank);
	         cards.add(c);
	      }  
	     }
	    }
       } 
      public void printDeck(){
	  for(int i=0;i<cards.size();i++){
	   Card x  = cards.get(i);
	   x.printCard();
	  }
     }
	 public ArrayList<Card> getAllCards(){
	  return cards;
	 }
	}
	/*
	 * Description: TODO:依序顯示花色和牌的數字
	 */
	class Card{
	 private int suit; 
	 private int rank;
	 public Card(int s,int r){
	  suit=s;
	  rank=r;
     } 
	 //TODO: 1. Please implement the printCard method
     public void printCard(){
	  System.out.println(suit+","+rank);
	 }
	 public int getSuit(){
	  return suit;
	 }
	 public int getRank(){
	  return rank;
	 }
	}
