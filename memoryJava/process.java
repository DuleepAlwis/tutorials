package memory;

public class process
{
    private String id;
    private int size;
    private boolean indicator;
    process next = null;
    

    public process(String id,int size,boolean indicator)
    {
        this.id = id;
        this.size = size;
        this.indicator = indicator;
    }

    public String getId()
    {
        return id;
    }

    public int getSize()
    {
        return size;
    }

    public void setIndicator(boolean i)
    {
        indicator = i;
    }

    public boolean getIndicator()
    {
        return indicator;
    }

    public void setProcess(String id,int size,boolean indicator)
    {
        this.id = id;
        this.size = size;
        this.indicator = indicator;
    }
    
}