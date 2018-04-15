package memory;

import memory.process;

public class memory1
{
    process head;
    int currentSize = 0;
    int memorySize = 0;

    public memory1(int os,int size)
    {   
        head = new process("os",os,true);
        this.memorySize = size;
        this.currentSize = os;
    }

    public void loadProcess(String p,int s)
    {
        if(searchProcess(p))
        {
            System.out.println("Process is already in the memory");
            return;
        }
        process c = head;
        while(c.next!=null)
        {
            if((memorySize-currentSize)>=s)
            {
                if(c.next.getSize()>=s && c.next.getIndicator()==false)
                {
                    if(c.next.getSize()>s)
                    {
                        process t = new process(null,c.next.getSize()-s,false);
                        c.next.setProcess(p,s,true);
                        t.next = c.next.next;
                        
                        c.next.next = t;
                    }
                    else
                    {
                        c.next.setProcess(p,s,true);
                    }
                    
                    currentSize = currentSize + s;
                    System.out.println("Process loaded to the memory "+p);
                    return;
                }
                else  
                {
                    c = c.next;
                }
            }
            else 
            {
                System.out.println("Process can't load no space free");
                return ;
            }
            
        }
        process t = new process(p,s,true);
        c.next = t; 
        System.out.println("Process loaded to the memory "+p);
        currentSize = currentSize + s;
        return ;
    }

    private boolean searchProcess(String p)
    {
        process c = head;
        while(c.next!=null)
        {
            if(c.next.getId()!=null)
            {
                if(p.matches(c.next.getId()))
                {
                    return true;  //process is in memory
                }
                else  
                {
                    c = c.next;
                }

            }
            else 
            {
                c = c.next;
            }
            
        }

        return false; //process is not in memory
    }

    public void removeProcess(String p)
    {
        process c = head;
        while(c.next!=null)
        {
            if(p.matches(c.getId()) && c.getIndicator())
            {
                c.setIndicator(false);
                System.out.println("Process successfully removed "+p);
                currentSize = currentSize - c.getSize();
                return ;
            }
            else 
            {
                c = c.next;
            }
        }

        System.out.println("Process not found");
        return ;
    }

    public void printMemory()
    {
        process c = head;
        System.out.println("=======================================================================================================================");
        System.out.println("\n"+"\t\t\tMemory size is "+memorySize+"MB Free size "+(memorySize-currentSize)+"MB");
        while(c!=null)
        {
            if(c.getIndicator()==true)
            {
                System.out.println("["+"\t"+"\t"+"\t"+c.getId()+"->"+c.getSize()+"MB \t\t\t]");
            }
            else 
            {
                System.out.println("["+"\t"+"\t"+"\t"+"Free Slot "+c.getSize()+"MB \t\t\t]");
            }
            c = c.next;
        }
        System.out.println("=======================================================================================================================");
    }
}