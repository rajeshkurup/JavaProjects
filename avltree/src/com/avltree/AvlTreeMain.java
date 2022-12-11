package com.avltree;

/**
 * 
 * @author rtraghavakurup
 *
 */
public class AvlTreeMain {
	
	public static void main(String[] args) {
		System.out.println("AVL Tree Demo");
		
		AvlTree avlTree = new AvlTree();
		System.out.println("AVL Tree - Insert(90, 900)=" + avlTree.insert(90, "900"));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		
		System.out.println("AVL Tree - Insert(70, 700)=" + avlTree.insert(70, "700"));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		
		System.out.println("AVL Tree - Insert(50, 500)=" + avlTree.insert(50, "500"));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		
		System.out.println("AVL Tree - Insert(10, 100)=" + avlTree.insert(10, "100"));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		
		System.out.println("AVL Tree - Insert(40, 400)=" + avlTree.insert(40, "400"));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		
		System.out.println("AVL Tree - Insert(40, 400)=" + avlTree.insert(40, "400"));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		
		System.out.println("AVL Tree - Insert(20, 200)=" + avlTree.insert(20, "200"));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		
		System.out.println("AVL Tree - Insert(30, 300)=" + avlTree.insert(30, "300"));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		
		System.out.println("AVL Tree - Insert(60, 600)=" + avlTree.insert(60, "600"));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		
		System.out.println("AVL Tree - Insert(80, 800)=" + avlTree.insert(80, "800"));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		
		System.out.println("AVL Tree - Insert(100, 1000)=" + avlTree.insert(100, "1000"));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));
		System.out.println("AVL Tree In Ascending Order=" + String.join(", ", avlTree.getTreeInAscendingOrder()));
		
		System.out.println("AVL Tree In Descending Order=" + String.join(", ", avlTree.getTreeInDescendingOrder()));
		System.out.println("AVL Tree In Order=" + String.join(", ", avlTree.getTreeInOrder()));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		System.out.println("AVL Tree In Post Order=" + String.join(", ", avlTree.getTreePostOrder()));
		
		System.out.println("AVL Tree - Find(50)=" + avlTree.find(50));

		System.out.println("AVL Tree - Update(40, 4000)=" + avlTree.update(40, "4000"));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));
		
		System.out.println("AVL Tree - Delete(70)=" + avlTree.delete(70));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));

		System.out.println("AVL Tree - Delete(20)=" + avlTree.delete(20));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));

		System.out.println("AVL Tree - Delete(90)=" + avlTree.delete(90));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));

		System.out.println("AVL Tree - Delete(60)=" + avlTree.delete(60));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));
		
		System.out.println("AVL Tree - Delete(40)=" + avlTree.delete(40));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));

		System.out.println("AVL Tree - Delete(10)=" + avlTree.delete(10));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));

		System.out.println("AVL Tree - Delete(30)=" + avlTree.delete(30));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));

		System.out.println("AVL Tree - Delete(50)=" + avlTree.delete(50));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));
		
		System.out.println("AVL Tree - Delete(100)=" + avlTree.delete(100));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));

		System.out.println("AVL Tree - Delete(80)=" + avlTree.delete(80));
		System.out.println("AVL Tree In Pre Order=" + String.join(", ", avlTree.getTreePreOrder()));
		System.out.println("AVL Tree Height=" + String.valueOf(avlTree.height()));
	}

}
