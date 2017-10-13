package com.avltree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author rtraghavakurup
 *
 */
public class AvlTree {
	
	private AvlNode node;
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	private AvlNode balance(AvlNode node) {
		long bFactor = balanceFactor(node);
		
		if(bFactor < -1) {
			if(balanceFactor(node.getRight()) > 0) {
				node = rightLeftRotation(node);
			} else {
				node = leftRotation(node);
			}
		} else if(bFactor > 1) {
			if(balanceFactor(node.getLeft()) < 0) {
				node = leftRightRotation(node);
			} else {
				node = rightRotation(node);
			}
		}
		
		return node;
	}
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	private AvlNode rightRotation(AvlNode node) {
		AvlNode temp = node.getLeft();
		node.setLeft(null);
		
		if(temp.getRight() == null) {
			temp.setRight(node);
		} else {
			temp.setRight(insert(temp.getRight(), node));
		}
		
		return temp;
	}
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	private AvlNode leftRotation(AvlNode node) {
		AvlNode temp = node.getRight();
		node.setRight(null);
		
		if(temp.getLeft() == null) {
			temp.setLeft(node);
		} else {
			temp.setLeft(insert(temp.getLeft(), node));
		}
		
		return temp;
	}
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	private AvlNode leftRightRotation(AvlNode node) {
		AvlNode temp = node.getLeft();
		node.setLeft(temp.getRight());
		temp.setRight(null);
		
		if(node.getLeft().getLeft() == null) {
			node.getLeft().setLeft(temp);
		} else {
			node.getLeft().setLeft(insert(node.getLeft().getLeft(), temp));
		}
		
		return rightRotation(node);
	}
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	private AvlNode rightLeftRotation(AvlNode node) {
		AvlNode temp = node.getRight();
		node.setRight(temp.getLeft());
		temp.setLeft(null);
		
		if(node.getRight().getRight() == null) {
			node.getRight().setRight(temp);
		} else {
			node.getRight().setRight(insert(node.getRight().getRight(), temp));
		}
		
		return leftRotation(node);
	}
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	private long balanceFactor(AvlNode node) {
		return (node != null ? height(node.getLeft()) - height(node.getRight()) : 0);
	}
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	private long height(AvlNode node) {
		long treeHeight = 0;
		
		if(node != null) {
			long leftHeight = height(node.getLeft());
			long rightHeight = height(node.getRight());
			long maxHeight = Math.max(leftHeight, rightHeight);
			treeHeight = maxHeight + 1;
		}
		
		return treeHeight;
	}
	
	/**
	 * 
	 * @param node
	 * @param key
	 */
	private AvlNode insert(AvlNode node, AvlNode newNode) {
		if(node != null) {
			if(node.getKey() > newNode.getKey()) {
				if(node.getLeft() == null) {
					node.setLeft(newNode);
					
				} else {
					node.setLeft(insert(node.getLeft(), newNode));
					node = balance(node);
				}
			} else if(node.getKey() < newNode.getKey()) {
				if(node.getRight() == null) {
					node.setRight(newNode);
					
				} else {
					node.setRight(insert(node.getRight(), newNode));
					node = balance(node);
				}
			}
		}
		
		return node;
	}
	
	/**
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	private AvlNode find(AvlNode node, long key) {
		AvlNode result = null;
		
		if(node != null) {
			if(node.getKey() == key) {
				result = node;
				
			} else if(node.getKey() < key) {
				result = find(node.getRight(), key);
				
			} else {
				result = find(node.getLeft(), key);
			}
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	private boolean delete(AvlNode parentNode, AvlNode node, long key) {
		boolean result = false;
		
		if(node != null) {
			if(node.getKey() == key) {
				if(parentNode.getRight() != null && parentNode.getRight().getKey() == node.getKey()) {
					parentNode.setRight(null);
				} else if(parentNode.getLeft() != null && parentNode.getLeft().getKey() == node.getKey()) {
					parentNode.setLeft(null);
				}
				
				if(node.getRight() != null) {
					parentNode = insert(parentNode, node.getRight());
				}
				
				if(node.getLeft() != null) {
					parentNode = insert(parentNode, node.getLeft());
				}
				
				result = true;
				
			} else if(node.getKey() < key) {
				result = delete(node, node.getRight(), key);
				
			} else {
				result = delete(node, node.getLeft(), key);
			}
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param node
	 * @param intArray
	 */
	private void inOrder(AvlNode node, List<AvlNode> nodeArray) {
		if(node.getLeft() != null) {
			inOrder(node.getLeft(), nodeArray);
		}
		
		nodeArray.add(node);
		
		if(node.getRight() != null) {
			inOrder(node.getRight(), nodeArray);
		}
	}
	
	/**
	 * 
	 * @param node
	 * @param intArray
	 */
	private void preOrder(AvlNode node, List<AvlNode> nodeArray) {
		nodeArray.add(node);
		
		if(node.getLeft() != null) {
			preOrder(node.getLeft(), nodeArray);
		}
		
		if(node.getRight() != null) {
			preOrder(node.getRight(), nodeArray);
		}
	}
	
	/**
	 * 
	 * @param node
	 * @param intArray
	 */
	private void postOrder(AvlNode node, List<AvlNode> nodeArray) {
		if(node.getLeft() != null) {
			postOrder(node.getLeft(), nodeArray);
		}
		
		if(node.getRight() != null) {
			postOrder(node.getRight(), nodeArray);
		}
		
		nodeArray.add(node);
	}
	
	/**
	 * 
	 * @param node
	 * @param intArray
	 */
	private void ascendingOrder(AvlNode node, List<AvlNode> nodeArray) {
		if(node.getLeft() != null) {
			ascendingOrder(node.getLeft(), nodeArray);
		}
		
		nodeArray.add(node);
		
		if(node.getRight() != null) {
			ascendingOrder(node.getRight(), nodeArray);
		}
	}
	
	/**
	 * 
	 * @param node
	 * @param intArray
	 */
	private void descendingOrder(AvlNode node, List<AvlNode> nodeArray) {
		if(node.getRight() != null) {
			descendingOrder(node.getRight(), nodeArray);
		}
		
		nodeArray.add(node);
		
		if(node.getLeft() != null) {
			descendingOrder(node.getLeft(), nodeArray);
		}
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public boolean insert(long key, String value) {
		boolean result = false;
		
		if(key != 0 && find(key) == null) {
			if(this.node == null) {
				this.node = new AvlNode(key, value);
				
			} else {
				this.node = insert(this.node, new AvlNode(key, value));
			}
			
			result = true;
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public String find(long key) {
		String result = null;
		
		if(key != 0) {
			AvlNode node = find(this.node, key);
			if(node != null) {
				result = node.getValue();
			}
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean update(long key, String value) {
		boolean result = false;
		
		if(this.node != null && key != 0) {
			AvlNode node = find(this.node, key);
			if(node != null) {
				node.setValue(value);
				result = true;
			}
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public boolean delete(long key) {
		boolean result = false;
		
		if(this.node != null && key != 0) {
			if(this.node.getKey() == key) {
				
				if(this.node.getRight() != null) {
					AvlNode node = this.node.getLeft();
					this.node = this.node.getRight();
					
					if(node != null) {
						this.node = insert(this.node, node);
					}
				} else if(this.node.getLeft() != null) {
					AvlNode node = this.node.getRight();
					this.node = this.node.getLeft();
					
					if(node != null) {
						this.node = insert(this.node, node);
					}
				} else {
					this.node = null;
				}
				
				result = true;
				
			} else if(this.node.getKey() < key) {
				result = delete(this.node, this.node.getRight(), key);
				
			} else {
				result = delete(this.node, this.node.getLeft(), key);
			}
			
			this.node = balance(this.node);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getTreeInAscendingOrder() {
		List<String> valueArray = new ArrayList<String>();
		
		if(this.node != null) {
			List<AvlNode> nodeArray = new ArrayList<AvlNode>();
			ascendingOrder(this.node, nodeArray);
			
			for(AvlNode node : nodeArray) {
				valueArray.add(node.getValue());
			}
		}
		
		return valueArray;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getTreeInDescendingOrder() {
		List<String> valueArray = new ArrayList<String>();
		
		if(this.node != null) {
			List<AvlNode> nodeArray = new ArrayList<AvlNode>();
			descendingOrder(this.node, nodeArray);
			
			for(AvlNode node : nodeArray) {
				valueArray.add(node.getValue());
			}
		}
		
		return valueArray;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getTreeInOrder() {
		List<String> valueArray = new ArrayList<String>();
		
		if(this.node != null) {
			List<AvlNode> nodeArray = new ArrayList<AvlNode>();
			inOrder(this.node, nodeArray);

			for(AvlNode node : nodeArray) {
				valueArray.add(node.getValue());
			}
		}
		
		return valueArray;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getTreePreOrder() {
		List<String> valueArray = new ArrayList<String>();
		
		if(this.node != null) {
			List<AvlNode> nodeArray = new ArrayList<AvlNode>();
			preOrder(this.node, nodeArray);
			
			for(AvlNode node : nodeArray) {
				valueArray.add(node.getValue());
			}
		}
		
		return valueArray;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getTreePostOrder() {
		List<String> valueArray = new ArrayList<String>();
		
		if(this.node != null) {
			List<AvlNode> nodeArray = new ArrayList<AvlNode>();
			postOrder(this.node, nodeArray);
			
			for(AvlNode node : nodeArray) {
				valueArray.add(node.getValue());
			}
		}
		
		return valueArray;
	}
	
	/**
	 * 
	 * @return
	 */
	public long height() {
		return height(this.node);
	}
	
}
