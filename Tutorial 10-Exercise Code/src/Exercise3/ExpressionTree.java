/**
 * Write a description of class ExpressionTree here.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Exercise3;
public class ExpressionTree
{
    ETNode root;
    ExpressionTree leftSubTree;
    ExpressionTree rightSubTree;
    
    /**
     * Constructor for objects of class ExpressionTree
     */
    public ExpressionTree()
    {
        root=null;
        leftSubTree=rightSubTree=null;
    }
    
    public void buildTree(String rootValue, ExpressionTree left, ExpressionTree right)
    {
        if (rootValue==null)
        {
            root=null;
            leftSubTree=rightSubTree=null;
        }
        else
            root=new ETNode(rootValue);        

        leftSubTree=left;
        rightSubTree=right;
    }
    
    public void buildTreeByValue(String rootValue, String leftValue, String rightValue)
    {
        if (rootValue == null)
        {
            root=null;
            leftSubTree=rightSubTree=null;
        }    
        else
            root=new ETNode(rootValue);
            
        if (leftValue == null)
            leftSubTree=null;
        else
        {
            leftSubTree=new ExpressionTree();
            leftSubTree.buildTree(leftValue,null,null);
        }   
        
        if (rightValue == null)
            rightSubTree=null;
        else
        {
            rightSubTree=new ExpressionTree();
            rightSubTree.buildTree(rightValue,null,null);
        }
    }
    
    public boolean isEmpty()
    {
        return ((root==null)&&(leftSubTree==null)&&(rightSubTree==null));
    }
    
    public void makeEmpty()
    {
        root=null;
        leftSubTree=rightSubTree=null;        
    }
    
    public String getTreeValue()
    {
        return root.getLabel();
    }
    
    public void setTreeValue(String label)
    {
        if (!isEmpty())
            root.setLabel(label);
    }
    
    public boolean isLeaf()
    {
        return ((leftSubTree==null)&&(rightSubTree==null));
    }
    
    public ExpressionTree getLeftSubTree()
    {
        return leftSubTree;
    }
    
    public void setLeftSubTree(ExpressionTree left)
    {
        leftSubTree=left;
    }
    
    public ExpressionTree getRightSubTree()
    {
        return rightSubTree;
    }
    
    public void setRightSubTree(ExpressionTree right)
    {
        rightSubTree=right;
    }   
    
    public void preOrderTraversal(ExpressionTree t)
    {
        if (t!=null)
        {
            System.out.print(t.getTreeValue() + " ");
            preOrderTraversal(t.getLeftSubTree());
            preOrderTraversal(t.getRightSubTree());
        }
    }    
    
    public int getDepth(ExpressionTree t)
    {       
        if (t==null)
            return 0;
            
        if (t.isLeaf())
            return 0;

        int leftSubTreeDepth=0;
        leftSubTreeDepth=getDepth(t.getLeftSubTree());
        int rightSubTreeDepth=0;
        rightSubTreeDepth=getDepth(t.getRightSubTree());            
        if (leftSubTreeDepth > rightSubTreeDepth)
            return 1+leftSubTreeDepth;
        else
            return 1+rightSubTreeDepth;

    }
    
    public int countLeaves(ExpressionTree t)
    {
        if (t==null)
            return 0;
            
        if (t.isLeaf())
            return 1;
            
        return countLeaves(t.getLeftSubTree())+countLeaves(t.getRightSubTree());    
    }
    
    public int iPathLength(ExpressionTree t, int height)
    {
        if (t==null)
            return 0;               
        
        return height + iPathLength(t.getLeftSubTree(),height+1)+iPathLength(t.getRightSubTree(),height+1);    
    }
    
    public int countNodes(ExpressionTree t)
    {
        if (t==null)
            return 0;

        return 1+ countNodes(t.getLeftSubTree())+countNodes(t.getRightSubTree());   
    }

    public void inOrderTraversal(ExpressionTree t)
    {
        if (t!=null)
        {
            inOrderTraversal(t.getLeftSubTree());
            System.out.print(t.getTreeValue() + " ");            
            inOrderTraversal(t.getRightSubTree());
        }
    }    

    public void postOrderTraversal(ExpressionTree t)
    {
        if (t!=null)
        {
            postOrderTraversal(t.getLeftSubTree());
            postOrderTraversal(t.getRightSubTree());
            System.out.print(t.getTreeValue() + " ");            
        }
    }    
    
    public ExpressionTree clone(ExpressionTree t)
    {
        if (t==null)
            return null;
        ExpressionTree result=new ExpressionTree();
        result.buildTree(t.getTreeValue(),clone(t.getLeftSubTree()),clone(t.getRightSubTree()));
        return result;
    }
    
    public boolean isEqual(ExpressionTree t1, ExpressionTree t2)
    {
        if ((t1 == null)&&(t2==null))
            return true;
        if ((t1 == null)||(t2 == null))
            return false;
        return    (t1.getTreeValue()==t2.getTreeValue())
                &&(isEqual(t1.getLeftSubTree(),t2.getLeftSubTree()))
                &&(isEqual(t1.getRightSubTree(),t2.getRightSubTree()));    
    }
    
    public int evaluate(ExpressionTree t)
    {
        String operator;
        int operand1;
        int operand2;
        int value;
        
        if (t.isLeaf())
        {
            return Integer.parseInt(t.getTreeValue());
        }   
        else
        {
            operator=t.getTreeValue();
            operand1 = evaluate(t.getLeftSubTree());
            operand2 = evaluate(t.getRightSubTree());          
            value = applyOperator(operand1,operator,operand2);
            return value;
        }   
    }
    
    private int applyOperator(int operand1, String operator, int operand2)
    {
        if (operator.equals("+"))
            return operand1 + operand2;
        if (operator.equals("-"))
            return operand1 - operand2;
        if (operator.equals("*"))
            return operand1*operand2;
        if (operator.equals("/"))
            return operand1/operand2;
        return 0;    
        
    }
}
