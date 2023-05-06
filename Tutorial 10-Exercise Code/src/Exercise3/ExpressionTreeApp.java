/**
 * Write a description of class ExpressionTreeApp here.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Exercise3;
public class ExpressionTreeApp
{
    /**
     * Constructor for objects of class ExpressionTreeApp
     */
    public ExpressionTreeApp()
    {
    }

    private static int cal_priority(char c)
    {
        if (c == '(')
            return 1;
        if ((c == '+')||(c=='-'))
            return 2;
        if ((c == '*')||(c=='/'))
            return 3;
        return 0;
    }
    
    private static String infixToPostfix(String infix)
    {
        String postfix = "";        
        ArrayStack s = new ArrayStack();        
        for (int i = 0; i < infix.length(); i++)
        {
            char c = infix.charAt(i);
            if (('0'<=c)&&(c<='9'))
                postfix = postfix + c + " ";

            if (c == '(')
                s.push(c);

            if ((c == '+')||(c=='-')||(c=='*')||(c=='/'))
            {                        
                if (s.isEmpty())
                    s.push(c);                   
                else
                {
                    if (s.peek() == '(')
                    {
                        s.push(c);                                            
                    }
                    else
                    {
                        if (cal_priority(c) >= cal_priority(s.peek()))
                            s.push(c);                                                                        
                        else
                        {
                            while (cal_priority(c) < cal_priority(s.peek()))
                            {
                                postfix = postfix + s.pop() + " ";
                            }
                        }
                    }
                }                
            }

            if (c==')')
            {
                while (s.peek() !='(')
                    postfix = postfix + s.pop() +" ";
                char tmp = s.pop();    //Removing the ')' from the stack
            }
        }
        while (!s.isEmpty())
        {
            postfix = postfix + s.pop() + " ";
        }
        return postfix;        
    }
    
    public static void main () 
    {
        String s = "(1+3)*((2-4)+5*7)";
        String postfix = infixToPostfix(s);
        System.out.println("The expression s is: " + s);
        System.out.println("The post-fix notation of s is: " + postfix);
        
        ETStack ets = new ETStack();        
        for (int i=0; i<postfix.length(); i++)
        {
            char c=postfix.charAt(i);
            if (('0'<=c)&&(c<='9'))
            {
                ExpressionTree operand=new ExpressionTree();
                operand.buildTree(String.valueOf(c),null,null);
                ets.push(operand);
            }
            if ((c=='+')||(c=='-')||(c=='*')||(c=='/'))
            {
                ExpressionTree operand2=ets.pop();
                ExpressionTree operand1=ets.pop();
                ExpressionTree operand = new ExpressionTree();
                operand.buildTree(String.valueOf(c),operand1,operand2);
                ets.push(operand);
            }
        }
        ExpressionTree t = ets.pop();
        System.out.println("The result of evaluating the expression is: " + t.evaluate(t));       
    }    
}
