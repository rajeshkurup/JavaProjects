package com.avltree;

/**
 * 
 * @author rtraghavakurup
 *
 */
public class AvlNode {
	
	private long key;
	private String value;
	private AvlNode left;
	private AvlNode right;
	
	public AvlNode(long key, String value) {
		this.key = key;
		this.value = value;
	}

	public long getKey() {
		return key;
	}

	public void setKey(long key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public AvlNode getLeft() {
		return left;
	}

	public void setLeft(AvlNode left) {
		this.left = left;
	}

	public AvlNode getRight() {
		return right;
	}

	public void setRight(AvlNode right) {
		this.right = right;
	}

}
