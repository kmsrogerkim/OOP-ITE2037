package Week7;

public class ArrayStack {
    private int[] stack;
    private int capacity;
    private int len;
    
    public ArrayStack()
    {
        this.stack = new int[10];
        this.capacity = 10;
        this.len = 0;
    }

    public void push(int n)
    {
        if (this.len == this.capacity - 1)
        {
            this.capacity = this.capacity * 2;
            int[] new_stack = new int[this.capacity];
            for (int i = 0; i < this.stack.length; i++)
            {
                new_stack[i] = this.stack[i];
            }
            this.stack = new_stack;
        }

        this.stack[this.len] = n;
        this.len++;
    }
    public int pop()
    {
        if (this.isEmpty())
        {
            return 0;
        }
        int n = this.stack[this.len - 1];
        len--;
        return n;
    }
    public int peek()
    {
        if (this.isEmpty())
        {
            return 0;
        }
        return this.stack[this.len - 1];
    }
    public boolean isEmpty()
    {
        return this.len == 0;
    }

    public void printStack()
    {
        for (int a: this.stack)
        {
            if (a == 0)
            {
                return;
            }
            System.out.print(a + " ");
        }
    }
}
