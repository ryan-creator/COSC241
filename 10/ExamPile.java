package week10;

import java.util.*;

public interface ExamPile {

	public void load(int[] item);

	public int size();

	public int peek();

	public int mark();

	public void delay();
}