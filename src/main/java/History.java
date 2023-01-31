import java.util.Date;

public class History {
    private HistoryLog[] log = new HistoryLog[10];
    int nubmeroflogs;

    public History()
    {
        nubmeroflogs = 0;
    }
    public HistoryLog[] getLog()
    {
        return log;
    }
    public void addLog(HistoryLog log)
    {
        if(nubmeroflogs + 2 > this.log.length) //if array is too small extend it by 5
        {
            HistoryLog[] tmp = new HistoryLog[this.log.length + 5];
            for(int i = 0; i < nubmeroflogs; i++)
            {
                tmp[i] = this.log[i];
            }
            this.log = tmp;
        }
        this.log[nubmeroflogs] = log;
        nubmeroflogs += 1;
    }

    public String log()
    {
        int allowed = 0;
        int notallowed = 0;
        for(int i = 0; i < this.nubmeroflogs; i++)
        {
            if(log[i].getStatus()) //check if pet was successfully bought
            {
                allowed += 1;
            }
            else
            {
                notallowed += 1;
            }
        }
        return (new Date(System.currentTimeMillis())).toString() + ", " + Integer.toString(allowed) + ", " + Integer.toString(notallowed);
    }

    public String toString()
    {
        String r = "";
        for(int i = 0; i < this.nubmeroflogs; i++)
        {
            r += log[i].toString() + "\n";
        }
        return r;
    }
}
