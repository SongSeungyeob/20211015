package co.sy.prj.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {
	private char[] stack = new char[10];
	private int top = -1;

	public void push(char ch) {
		if (top == stack.length - 1) {
			System.out.println("[ ERROR ] : Stack에 더 이상 데이터를 입력할 수 없습니다.");
		} else {
			stack[++top] = ch;
		}
	}

	public char pop() {
		char data = 0;
		if (top < 0) {
			System.out.println("[ ERROR ] : Stack에 존재하는 데이터가 없습니다.");
			return data;
		} else {
			return stack[top--];
		}
	}

	private int size() {
		return top;
	}

	private char getTop() {
		return stack[top];
	}

	private boolean isFull() {
		return top == 10 ? true : false;
	}

	private boolean isEmpty() {
		return top == 0 ? true : false;
	}

}
