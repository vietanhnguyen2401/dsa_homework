package Exercise2;

/**
 * Class InfixToPostfix implements an algorithm to convert an infix expression to the corresponding postfix expression.
 * A stack that contains character items is used to support the converting process.
 * See Lecture 8 for more information about the infix to postfix conversion algorithm.
 * @author (nxthang) 
 * @version (1.0)
 */
public class InfixToPostfix {
    public static void main (String[]args) 
    {
        String infix = "(1+3)*((2-4)+5*7)";
        
        System.out.println("The input infix expression is: " + infix);
        String postfix = "";
        
        SLLStack s = new SLLStack();
        
        for (int i = 0; i < infix.length(); i++)
        {
            char c = infix.charAt(i);
            if (('0'<=c)&&(c<='9'))
            {
                postfix = postfix + c + " ";
            }
            if (c == '(')
            {
                StackNode tmp = new StackNode(c);
                s.push(tmp);
            }
            if ((c == '+')||(c=='-')||(c=='*')||(c=='/'))
            {                        
                if (s.isEmpty())
                {
                    StackNode tmp = new StackNode(c);
                    s.push(tmp);                    
                }
                else
                {
                    if (s.peek().getData() == '(')
                    {
                        StackNode tmp = new StackNode(c);
                        s.push(tmp);                                            
                    }
                    else
                    {
                        if (cal_priority(c) >= cal_priority(s.peek().getData()))
                        {
                            StackNode tmp = new StackNode(c);
                            s.push(tmp);                                                                        
                        }
                        else
                        {
                            while (cal_priority(c) < cal_priority(s.peek().getData()))
                            {
                                postfix = postfix + s.pop().getData() + " ";
                            }
                        }
                    }
                }                
            }
            if (c==')')
            {
                while (s.peek().getData() !='(')
                    postfix = postfix + s.pop().getData() +" ";
                StackNode tmp = s.pop();    //Removing the '(' from the stack
            }
        }
        while (!s.isEmpty())
        {
            postfix = postfix + s.pop().getData() + " ";
        }
        System.out.println("The postfix expression is : " + postfix);
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
}

