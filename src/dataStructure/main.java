package dataStructure;

import lineals.*;
import lineals.ArrayList;
import lineals.LinkedList;
import models.Queue;
import test.Person;
import test.Person2;

import java.util.*;


public class main {

	public static void main(String[] args) {
		models.List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(10);
		list.add(20);
		list.remove(2);
		list.add(25);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}



}
