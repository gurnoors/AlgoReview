package com.gurnoors.dsalgo.hackerrank;

import java.util.LinkedList;
import java.util.List;

/**
 * Stack implementation using LinkedList
 * @author gurnoorsinghbhatia
 * @param <T>
 *
 */
public class MyStack<T>{
	List<T> list = new LinkedList<>();
	
	public void push(T toPush){
		list.add(toPush);
	}
	
	public T pop(){
		if (!list.isEmpty()){
			return list.remove(list.size()-1);
		}else{
			return null;
		}
	}
	
	public T peek(){
		return list.get(list.size()-1);
	}
	
	public boolean empty(){
		return list.isEmpty();
	}
}
