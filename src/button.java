import javax.swing.*;
public class button
{
     button()
    {
        JFrame f = new JFrame("The End");
        Icon icon = new ImageIcon("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\button.png");
        JButton btn = new JButton(icon);
        btn.setBounds(40,80,200,50);
        f.add(btn);
        f.setSize(300,250);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}