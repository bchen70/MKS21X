import javax.swing.*;
import java.awt.*;
public class CFConvert extends JFrame{
    private Container pane;
    private JButton b;
    private JButton c;
    private JLabel l;
    private JTextField t;

    public CFConvert(){
	  this.setSize(1000,400);
	  this.setLocation(100,100);
	  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	  
	pane=this.getContentPane();
	pane.setLayout(new FlowLayout());

	b = new JButton("Convert Fahrenheit to Celsius");
	l = new JLabel("Enter values to convert");
	c = new JButton("Convert Celsius to Fahrenheit");
	t = new JTextField(10);
	pane.add(l);
	pane.add(t);
	pane.add(b);
	pane.add(c);
    }
	
    public static double celsiusToFahrenheit(double t) {
	return 9 * t / 5 + 32;
    }

    public static double fahrenheitToCelsius(double t) {
	return 5 * (t - 32) / 9;
    }
    public static void main(String[] args) {
	CFConvert g = new CFConvert();
	g.setVisible(true);
    }
}
