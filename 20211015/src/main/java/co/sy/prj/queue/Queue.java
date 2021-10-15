package co.sy.prj.queue;

public class Queue {
	private int front = -1;
	private int rear = -1;
	private int[] queue = new int[10];
	
	public void push(int n) {
		if(rear == queue.length - 1) {
			System.out.println("[ QUEUE FULL ] : Queue에 더 이상 데이터를 입력할 수 없습니다.");
		} else {
			queue[++rear] = n;
		}
	}
	
	public int pop() {
		int data = -1;
		if(front == rear || front > queue.length - 1) {
			System.out.println("[ QUEUE EMPTY ] : Queue에 데이터가 존재하지 않습니다.");
		} else {
			data = queue[++front];
		}
		return data;
	}
}
