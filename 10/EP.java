package week10;

import java.util.*;

/**
 *  EP class that holds various methods that can be called from the App class.
 *
 * @author Ryan Cole
 */
public class EP implements ExamPile{

    /** Creates a linked list to put the array. */
    private LinkedList<Integer> examPile = new LinkedList<>();

    /**
     * Initialises the pile of exams into the linked list.
     *
     * @param item array to be initialised into a linked list.
     */
    public void load(int[] item){
    	for(int i : item){
    		examPile.add(i);
    	}
    }

    /**
     * Returns the size of the linked list.
     *
     * @return examPile.size() the size of the exam pile. 
     */
    public int size(){
    	return examPile.size();
    }

    /**
     * Returns the exam on the top of the pile.
     *
     * @return topExam the top exam from the exam pile.
     */
    public int peek() {
        int topExam = 0;
        try {
            if(isEmpty()) {
                throw new EmptyPileException("Empty Pile");
            } else {
                topExam =  examPile.peek();
            }
        } catch (EmptyPileException e){
            e.printStackTrace();
    	}
        return topExam;
    }

    /**
     * Returns the value at the top of the pile and removes it from the pile.
     *
     * @return topExam  is the top exam from the exam pile.
     */
    public int mark(){
        int topExam = 0;
        try {
            if(isEmpty()) {
                throw new EmptyPileException("Empty Pile");
            } else {
                topExam =  examPile.poll();
            }
        } catch (EmptyPileException e){
            e.printStackTrace();
    	}
        return topExam;
    }

    /**
     * Moves the value from the top of the pile to the ottom of the pile.
     */
    public void delay() {
        try {
            if(isEmpty()) {
                throw new EmptyPileException("Empty Pile");
            } else {
                examPile.addLast(examPile.remove(0));

            }
        } catch (EmptyPileException e){
            e.printStackTrace();
    	}
    }

    /** 
     * Returns true if the linked list is empty, otherwise false.
     *
     * @return examPile.peek() == null checks to see if there is any exams.
     */
    public boolean isEmpty() {
        return examPile.peek() == null;
    }

    /**
     * Returns true if the two exam piles are the same.
     * 
     * @return answer true or false if the two exampiles are the same.
     */
    public boolean equals(EP newPile){
    	EP ep = new EP();
    	int count = 0;
    	boolean answer = false;
    	ep = EP.reconstruct(sortingSteps());
        if(ep.size() == newPile.size()){
        	for(int i = 0; i < ep.size(); i++){
        		if(ep.mark() == newPile.mark()){
        			count++;
        		}
        	}
        	if(count == ep.size()){
        		answer = true;
        	}
        }
        return answer; 
    }
    
    /**
     * Returns the exams in the linked list in a string seperated by a space.
     *
     * @return temp.trim() the string with the linked list values. 
     */
    public String toString(){
    	String temp = "";
    	for(int i = 0; i < examPile.size(); i++){
    		temp += examPile.get(i) + " ";
    	}
    	return temp.trim();
    }

    /**
     * Will mark all the exams in the order of first to last and will record each step.
     * in the form of a M (mark) or a D (delay)
     *
     * @return steps the steps it took to mark all the exams.
     */
    public String sortingSteps(){
    	String steps = "";
    	while(!isEmpty()){
    		if(examPile.getFirst() == smallest()){
    			mark();
    			steps += "M";
    		} else {
    			delay();
    			steps += "D";
    		}
    	}
    	return steps;
    }

    /**
     * Will go through the examPile and find the smallest int.
     *
     * @return examPile.get(sma) the smallest exam (int).
     */
    public int smallest(){
    	int sma = 0;
    	for(int i = 1; i < examPile.size(); i++){
    		if(examPile.get(i) < examPile.get(sma)){
    			sma = i;
    		}
    	}
    	return examPile.get(sma);
    }

    /**
     * will reconstruct a pile of exams by reversing the steps.
     *
     * @param steps the steps it will reverse to recreate the examPile.
     * @return newPile the new pile of exams created from the steps.
     */
    public static EP reconstruct(String steps){
    	int n = 0;
        steps = steps.toLowerCase();
        steps = new StringBuilder(steps).reverse().toString();
    	for(char c : steps.toCharArray()){ 
    		if(c == 'm'){
    			n++;
    		}
    	}
        int m = n;
        n = n-1;
    	LinkedList<Integer> examPile2 = new LinkedList<>();
        for(int i = 0; i < steps.length(); i++){
            if(steps.charAt(i) == 'm'){
                examPile2.addFirst(n);
                n = n - 1;
            } else if(steps.charAt(i) == 'd'){
                examPile2.addFirst(examPile2.pollLast());
            }
        }
        EP newPile = new EP();
        int[] array = new int[m];
        for (int i = 0; i < array.length; i++) {
            array[i] = examPile2.get(i);
        }
        newPile.load(array);
    	return newPile;
    } 
}
