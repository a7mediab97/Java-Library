package data_structures;
import java.util.Random;

// TODO Needs Testing

public class TreapSet <K extends Comparable<K>>
{
	public static void main(String[] args) {
		TreapSet<Integer> set = new TreapSet<>();
		set.insert(3);
		set.insert(2);
		set.insert(4);
		set.delete(2);
		System.out.println(set.indexOf(5));
		set.print();
		
		
	}
	class Node<T extends Comparable<T>>
	{
		T key;
		Node<T> left, right;
		int prior, size;
		
		Node(T k, int p, int s, Node<T> l, Node<T> r)
		{
			key = k;
			prior = p;
			size = s;
			left = l;
			right = r;
		}
	}
	
	Random rand = new Random();
	final Node<K> nill = new Node<K>(null, Integer.MAX_VALUE, 0, null, null);
	Node<K> root = nill;
	
	private Node<K> balance(Node<K> root)
	{
		if(root.left.prior < root.prior)
			return rotateRight(root);
		if(root.right.prior < root.prior)
			return rotateLeft(root);
		return root;
	}
	
	void delete(K key) { root = delete(key, root); }
	
	private Node<K> delete(K key, Node<K> root)
	{
		if(root == nill) return nill;
		
		if(key.compareTo(root.key) < 0)
		{
			root.left = delete(key, root.left);
			update(root);
			return root;
		}
		if(key.compareTo(root.key) > 0)
		{
			root.right = delete(key, root.right);
			update(root);
			return root;
		}
		if(root.left == nill && root.right == nill)return nill;
		
		return delete(key, root.left.prior < root.right.prior? rotateRight(root):rotateLeft(root));
	}
	
	int height() { return height(root); }
	
	private int height(Node<K> root)
	{
		if(root == null) return -1;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	int indexOf(K key) { return indexOf(key, root); }
	
	private int indexOf(K key, Node<K> root)
	{
		if(root == nill) return Integer.MIN_VALUE;
		
		if(key.compareTo(root.key) < 0) return indexOf(key, root.left);
		
		if(key.compareTo(root.key) > 0) return indexOf(key, root.right) + root.left.size + 1;
		
		return root.left.size;
	}
	
	void insert(K key) { root = insert(key, root); }
	
	private Node<K> insert(K key, Node<K> root)
	{
		if(root == nill) return new Node<K>(key, rand.nextInt(1<<30), 1, nill, nill);
		
		if(key.compareTo(root.key) < 0)
			root.left = insert(key, root.left);
		else
			if(key.compareTo(root.key) > 0)
				root.right = insert(key, root.right);
		update(root);
		return balance(root);
	}
	
	K keyOf(int index) { return keyOf(index, root);}
	
	private K keyOf(int index, Node<K> root)
	{
		if(root == nill) return null;
		if(index < root.left.size)
			return keyOf(index, root.left);
		if(index > root.left.size)
			return keyOf(index  - root.left.size - 1, root.right);
		return root.key;
	}
	
	void print()
	{
		System.out.print("[");
		
		print(root);
		
		System.out.println("]");
	}
	
	private void print(Node<K> root)
	{
		if(root == nill) return;
		print(root.left);
		System.out.print(root.key + " ");
		print(root.right);
	}
	
	private Node<K> rotateLeft(Node<K> root)
	{
		Node<K> T = root.right;
		root.right = T.left;
		T.left = root;
		update(T.left);
		update(T);
		return T;
	}
	
	private Node<K> rotateRight(Node<K> root)
	{
		Node<K> T = root.left;
		root.left = T.right;
		T.right = root;
		update(T.right);
		update(T);
		return T;
	}
	
	boolean search(K key) {return search(key, root); }
	
	private boolean search(K key, Node<K> root)
	{
		if(root == nill) return false;
		if(key.compareTo(root.key) < 0)
			return search(key, root.left);
		if(key.compareTo(root.key) > 0)
			return search(key, root.right);
		return true;
	}
	
	int size() { return root.size; }
	
	private void update(Node<K> root)
	{
		if(root != nill)
			root.size = root.left.size + 1 + root.right.size;
	}
}