/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author wxw18
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
            //compare.setPriority(10);
            compare.start();
            guiTester.start();
            //compare.setPriority(10);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
