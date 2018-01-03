import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Temperature extends JFrame implements ActionListener{
    private Container pane;
    private JButton ftoc;
    private JButton ctof;
    private JLabel l;
    private JTextField t;

    public Temperature(){
      this.setSize(1000,400);
      this.setLocation(100,100);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      pane=this.getContentPane();
      pane.setLayout(new FlowLayout());

      l = new JLabel("Enter values to convert");
      pane.add(l);

      t = new JTextField(5);
      pane.add(t);

      ftoc = new JButton("Convert Fahrenheit to Celsius");
      ftoc.addActionListener(this);
      pane.add(ftoc);
      
      ctof = new JButton("Convert Celsius to Fahrenheit");
      ctof.addActionListener(this);
      pane.add(ctof);
    }

  public void actionPerformed(ActionEvent e){
    String str = e.getActionCommand();
    if (str.equals("Convert Celsius to Fahrenheit")){
	    double result = celsiusToFahrenheit(Double.parseDouble(t.getText()));
	    t.setText(result + "");
    }
    else {
	    double result = fahrenheitToCelsius(Double.parseDouble(t.getText()));
	    t.setText(result + "");
    }  	 
  }
    public static double celsiusToFahrenheit(double t) {
      return 9 * t / 5 + 32;
    }

    public static double fahrenheitToCelsius(double t) {
      return 5 * (t - 32) / 9;
    }
    public static void main(String[] args) {
      Temperature g = new Temperature();
      g.setVisible(true);
    }
}
