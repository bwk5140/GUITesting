package gui;

public class GuiTester extends Thread
{
    Tester tester;

    public GuiTester(Tester tester)
    {
        this.tester = tester;
    }
    public void run()
    {
        while(!this.tester.complete)
        {
            try
            {
                tester.fillTextField();
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }

    }
}
