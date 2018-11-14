package mvc.use.simple;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputView extends JFrame implements ActionListener{
      private JButton set;
      private JLabel jred,jblue,jgreen;
      private JTextField tfred,tfblue,tfgreen;
      private IController icontroller;
      public InputView() {
    	  //初始化控制器
    	  icontroller=new ControllerImpl();
    	  icontroller.setDataModel(new ConcreteDataModel());
    	  //定义容器，并设置为流水布局。大家可以尝试更好的布局
    	  Container con=this.getContentPane();
          con.setLayout(new FlowLayout());
          //初始化按钮标签和文本框组件
          set=new JButton("set");
          jred=new JLabel("red:");
          jblue=new JLabel("blue:");
          jgreen=new JLabel("green:");
          tfred=new JTextField(10);
          tfblue=new JTextField(10);
          tfgreen=new JTextField(10);
          //将按钮标签和文本框组件加入到容器中,注意添加顺序
          con.add(jred);con.add(tfred);
          con.add(jblue);con.add(tfblue);
          con.add(jgreen);con.add(tfgreen);
          con.add(set);
          //为按钮set设置事件处理
          set.addActionListener(this);
          /**设置窗口 **/
          this.setSize(170,140);
          this.setVisible(true);
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setResizable(false);         
      }
      //事件处理。当点击“set”按钮时做什么
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int r=Integer.parseInt(tfred.getText());
		int g=Integer.parseInt(tfgreen.getText());
		int b=Integer.parseInt(tfblue.getText());
		icontroller.setValue(r, b, g);
	}
   public static void main(String ar[]) {
	   InputView iv=new InputView();
   }
}
