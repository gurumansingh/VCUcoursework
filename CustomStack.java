/*
 * CustomStacks in Bridges API Project 
 * Gurumanpreet Singh
 * Project #4
 * CMSC 256-901 Spring 2020
 * This program uses the Bridges API to visualize nodes 
 */
package cmsc256;

import bridges.connect.Bridges;
import bridges.base.SLelement;
import java.util.*;

public class CustomStack<E> implements StackInterface<E> {
	SLelement<E> topNode; 		//creating variable topNode
	public static void main(String[] args) throws Exception{
		//connecting to the Bridges API
		Bridges bridges = new Bridges(0, "singhg24", "816756910631");
		//setting the title that will appear online in Bridges
		bridges.setTitle("CMSC 256 Project 4 Gurumanpreet Singh");
		//creating instance of CustomStack that will have Strings as elements
		CustomStack<String> stacks = new CustomStack<String>();
		
		//push means adding that value to the stack
		stacks.push("256");
		stacks.push("10");
		stacks.push("18");
		stacks.push("20");
		stacks.push("2018");
		
		//display shows the current stack
		stacks.display();
		
		//pop retrieves and removes the value at topNode
		stacks.pop();
		stacks.pop();
		stacks.pop();
		stacks.pop();
		stacks.pop();
		stacks.push("256");
		stacks.push("10");
		stacks.push("18");
		stacks.push("20");
		stacks.push("2018");
		stacks.display();
		
		//peek shows the topNode value without removing it from the stack
		stacks.peek();
		stacks.display();
		
		//creating the display and setting colors and sizes for the nodes
		SLelement<String> topNode = stacks.topNode;
		topNode.getVisualizer().setColor("purple");
		topNode.getNext().setColor("orange");
		topNode.getNext().getNext().setColor("yellow");
		topNode.getNext().getNext().getNext().setColor("red");
		topNode.getNext().getNext().getNext().getNext().setColor("blue");

		topNode.setSize(30);
		topNode.getNext().setSize(35);
		topNode.getNext().getNext().setSize(45);
		topNode.getNext().getNext().getNext().setSize(50);
		topNode.getNext().getNext().getNext().getNext().setSize(40);

		//setting topNode as what the Bridges visualizer will show
		bridges.setDataStructure(topNode);
	
		try {
			bridges.visualize();
		}
		catch(Exception e) {
			System.out.println("Cannot Connect to Bridges");	//if the connection to Bridges cannot be made
			e.printStackTrace();
		}
	}
	
	//the display method shows what is in the current stack
	public void display() {
		//if the stack is empty, an appropriate message is displayed
		if(isEmpty()) {
			System.out.println("The stack is empty");
		}
		else {
			SLelement<E> current = topNode;
			StringBuffer output = new StringBuffer();
			output.append("Top of stack: " + current.getValue() + "\n");
		
			//while the stack has more elements, keep printing them
			while(current.getNext() != null) {
				current = current.getNext();
				if(current.getNext() == null)
					output.append("Stack bottom: ");
				else
					output.append(" ");
				output.append(current.getValue() + "\n");
			}
			System.out.println(output.toString());
			}
		}
	
	@Override
	//the push method adds elements to the stack
	public void push(E newEntry) {
		if (newEntry == null) {	
			throw new IllegalArgumentException();		//if the newEntry has a null value
		}if (!isEmpty()) {		//if the stack is not empty, add the new entry to the first position
			SLelement<E> temp = new SLelement<E>(newEntry, topNode);
			topNode = temp;
		}else if(isEmpty()) {		//if the stack is empty, add the entry to the first position
			topNode = new SLelement<E>(newEntry);
		}	
	}

	@Override
	//the pop method retrieves and removes the first element of the stack
	public E pop() {
		if(topNode == null) {
			throw new EmptyStackException();
		}else {
			E valueToReturn = topNode.getValue();		//retrieves the topNode value
			topNode = topNode.getNext();		//sets the new topNode value to the one after it
			return valueToReturn;		//returns the original top value
		}
	}

	@Override
	//the peek method retrieves the topmost value of the stack
	public E peek() {
		if(isEmpty()) {
			throw new EmptyStackException();		//if stack is empty, throw Exception
		}else {
	        E element = topNode.getValue();		
	        return element; 		//return the value of the topNode
		}
	}

	@Override
	//the isEmpty() method returns true if the topNode value is null (empty)
	//otherwise, the method returns false if the stack isn't empty
	public boolean isEmpty() {
		if(topNode == null) {
			return true;
		}
		return false;
	}

	@Override
	//the clear method sets the topNode value to null and clears the stack
	public void clear() {
		topNode = null;
		
	}
	


}
