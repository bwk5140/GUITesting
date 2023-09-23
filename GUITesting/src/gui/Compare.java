package gui;

/**
 *
 * @author Brian Karimi Wachira, Katie Killian, Nicole Vadillo
 */
public class Compare extends Thread
{

    Tester tester;
    public Compare(Tester tester)
    {
        this.tester = tester;
    }

    public synchronized void run()
    {

        try
        {
            tester.read();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
