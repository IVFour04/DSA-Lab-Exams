package LabExam_1;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class queue {

	static Scanner input = new Scanner(System.in);
	static Queue<String> queue = new LinkedList<>();
	
	public static void main(String args[]){
		
		int choice;
		
		do {
			
			System.out.println("\n===== PERMUTATION =====");
			System.out.println("[1] Add to Queue");
			System.out.println("[2] Display Queue");
			System.out.println("[3] Generate Permutations");
			System.out.println("[4] Exit");
			System.out.print("Enter choice: ");
			
			choice = input.nextInt();
			
			switch (choice) {
			
			case 1:
				addElements();
				break;
				
			case 2:
				display();
				break;
				
			case 3:
				permutation();
				break;
				
			case 4:
				System.out.println("Exited program.");
				break;
				
			default:
				System.out.println("Invalid choice. Please choose again.");
			}
		}
		
		while (choice != 5);
		
	}
	
	static void addElements(){
		System.out.println("Elements to add: ");
		
		String elements;
		elements = input.nextLine();
		
		while (input.hasNextLine() && (elements = input.nextLine()).length() !=0) {
			queue.add(elements);
		}
		
		System.out.printf("Queue: %s%n", queue);
		
	}
	
	static void display(){
		if(queue.isEmpty()){
			System.out.println("Queue is still empty. Please add content first.");
			return;
		}
		
		System.out.println("Queue: " + queue);
		System.out.println("First in line: " + queue.peek());
		
	}
	
	static void dequeue(){
		for(int i=0; i<2; i++){
			if(queue.isEmpty()){
				System.out.println("Queue is empty.");
				break;
			}
			
			System.out.println("Removed: " + queue.poll());
		}
		
		System.out.println("Current queue: " + queue);
	}
	
	static String[] toArray(){
		String[] items = new String[queue.size()];
		int i=0;
		for (String str: queue){
			items[i++] = str;
		}
		
		return items;
	}
	
	static int readR(int n, String act){
		System.out.println("\nEnter number of elements to " + act + ": ");
		int r = input.nextInt();
		System.out.println();
		
		if(r<1 | r>n){
			System.out.println("Invalid number.");
			return -1;
		}
		
		return r;
	}
	
	static String build(int[] path, String[] items){
		StringBuilder Build = new StringBuilder();
		for (int p: path){
			Build.append(items[p]);
		}
		return Build.toString();
	}
	
	
	static void permutation(){
		if(queue.isEmpty()){
			System.out.println("Queue is still empty. Please add content first.");
			return;
		}
		
		String[] items = toArray();
		System.out.println("Queue: " + queue);
		
		int r = readR(items.length, "arrange");
		if(r==-1) return;
		
		Queue<int[]> work = new LinkedList<>();
		work.add(new int[0]);
		
		int count = 0;
		
		while(!work.isEmpty()){
			int[]path = work.poll();
			
			if(path.length == r){
				System.out.println(build(path, items));
				count++;
				continue;
			}
			
			for(int i=0; i<items.length; i++){
				boolean used = false;
				for(int p: path){
					if(p==i){
						used = true;
						break;
					}
				}
				if(used) continue;
				
				int[] next = new int[path.length + 1];
				System.arraycopy(path, 0, next, 0, path.length);
				next[path.length]=i;
				work.add(next);
			}
		}
		
	System.out.println("\nTotal Permutations: " + count);
		
	}
}







