/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Brian Karimi Wachira, Katie Killian, Nicole Vadillo
 */
public class GUITest
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        try
        {
            Tester tester = new Tester();
            Compare compare = new Compare(tester);
            GuiTester guiTester = new GuiTester(tester);
            compare.start();
            guiTester.start();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
