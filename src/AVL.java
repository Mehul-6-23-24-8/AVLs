import java.util.*;

public class AVL extends BST{

    //r is the initial root
	BST_node root;
	public AVL(int r, BST_node root)
	{
		super(r);
		this.root = root;
	}
	
	public int left_height(BST_node a, int h)
	{
		if(a == root && a.left == null)
		{
				return -1;
		}
		else if( a.left!= null)
		{
		
		   return left_height(a.left, h+1);
		}
		else if (a.left== null && a.right== null)
		{
			return h;
		}
		else if( a.right != null)
		{
			return left_height(a.right, h+1);
		}
		
		return h;
	}
	
	public int right_height(BST_node a, int h)
	{
		if(a == this.root && a.right == null)
		{
				return -1;
		}
		else if( a.right!= null)
		{
		   return right_height(a.right, h+1);
		}
		else if (a.right== null && a.left== null)
		{
			return h;
		}
		else if( a.left != null)
		{
			return right_height(a.left, h+1);
		}
		
		return h;
	}
	
	public String balance(BST_node a, int h)
	{
		int L= left_height(a, h);
		int R = right_height(a, h);
		
		if(R-L > 1)
		   return "R";
		else if(L-R > 1)
			return "L";
		else if(Math.abs(L-R) <= 1)
            return "B";			
		return "error";
	}
	//The reason it is called head is because the root of the tree already exists, so there may be an accidental mixup betweem the true root and what it is being passed into the method
	public BST_node right_heavy(BST_node head, BST_node R)
	{
		BST_node child;
		if(head.left == null)
		{
			BST_node hold = head;
			head = R;
			head.left= hold;
			head.left.right = null;
            return head;
		}
		else if (head.left != null)
		{
			child = head.left;
			BST_node hold = head;
			head = R;
			head.left= hold;
			head.left.right = null;
			head.left.left = child;
	        return head;

		}
		return null;
			
			
	}
	
	public BST_node left_heavy(BST_node head, BST_node L)
	{
		BST_node child;
		if(head.right == null)
		{
			BST_node hold = head;
			head = L;
			head.right= hold;
			head.right.left = null;
            return head;
		}
		else if (head.right != null)
		{
			child = head.right;
			BST_node hold = head;
			head = L;
			head.right= hold;
			head.right.left = null;
			head.right.right = child;
	        return head;

		}
		return null;
			
			
	}
	
	
}
