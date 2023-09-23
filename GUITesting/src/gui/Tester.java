package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Tester
{
    public static int resultVal = 0, num1, num2, result;
    public static boolean complete = false;
    public static boolean certify = false;
    static JTextField jtf1 = new JTextField();
    static JTextField jtf2 = new JTextField();
    static JTextField jtf3 = new JTextField();
    static JButton jbtn = new JButton();
    MyGUI gui = new MyGUI();
    synchronized void read() throws Exception
    {
        FileInputStream inFile = new FileInputStream("C:\\Users\\brian\\Documents\\Fall 2023\\SWENG 431\\GUITesting\\GUITesting\\src\\gui\\input.txt");
        Scanner scnr = new Scanner(inFile);
        String input;
        while (scnr.hasNextInt())
        {
            //complete = false;
            num1 = scnr.nextInt();
            num2 = scnr.nextInt();
            result = scnr.nextInt();
            sleep(100);

            while(!certify)
                this.wait();

            jtf1.setText(Integer.toString(num1));
            jtf2.setText(Integer.toString(num2));
            jbtn.doClick();
            input = jtf3.getText();
            resultVal = Integer.parseInt(input);

            if (resultVal != result)
            {
                throw new Exception("Test failure!");
            }
            sleep(1500);
        }
        complete = true;
    }

    synchronized void fillTextField() throws Exception
    {
        //Thread.sleep(500);
        Toolkit tk = Toolkit.getDefaultToolkit();

        AWTEventListener listener = new AWTEventListener()
        {
            ArrayList<AWTEvent> al = new ArrayList<>();

            @Override
            public void eventDispatched(AWTEvent event)
            {
                if (al.size() < 4)
                {
                    if (event.getID() == MouseEvent.MOUSE_PRESSED)
                    {
                        al.add(event);
                    }

                    if (al.size() == 4)
                    {
                        jtf1 = (JTextField) al.get(0).getSource();
                        jtf2 = (JTextField) al.get(1).getSource();
                        jtf3 = (JTextField) al.get(2).getSource();
                        jbtn = (JButton) al.get(3).getSource();
                        jtf1.setText("100");
                        jtf2.setText("200");
                        jtf3.setText("300");

                        certify = true;
                    }
                }
            }
        };

        tk.addAWTEventListener(listener, AWTEvent.MOUSE_EVENT_MASK);
        if (gui == null)
            gui = new MyGUI();
        gui.setSize(400,300);
        gui.setVisible(true);
        this.notify();
        sleep(500);
    }
}
