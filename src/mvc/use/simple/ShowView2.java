package mvc.use.simple;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Observable;
import java.util.Observer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;


public class ShowView2 implements Observer {
	//柱图的显示 
	private void show(int g,int b,int r) {
		//设置数据
    	DefaultCategoryDataset dpds=new DefaultCategoryDataset();
    	dpds.setValue(g,"green","green");
    	dpds.setValue(b,"blue","blue");
    	dpds.setValue(r, "red", "red");
    	//生成图
    	JFreeChart chart=ChartFactory.createBarChart("hello","color","amount",dpds);
    	CategoryPlot pp=(CategoryPlot)chart.getPlot();
    	//取得柱子
    	CategoryItemRenderer ci=pp.getRenderer();
    	//设置柱子的颜色
    	ci.setSeriesPaint(0, Color.green);
    	ci.setSeriesPaint(1, Color.blue);
    	ci.setSeriesPaint(2, Color.red);
    	try {
    		//以窗口的形式显示图
    	 ChartFrame cf=new ChartFrame("饼状图",chart);
    	 cf.setSize(300,300);
    	 cf.setVisible(true);
    	 //将图保存到文件中
    	 OutputStream os=new FileOutputStream("G:\\render.jpg");
    	 ChartUtils.writeChartAsJPEG(os,chart,500,500);
         os.close(); }
        catch(Exception e) {
        	System.out.println("show pie error");
        }
    }
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		DataModel dm=(DataModel)o;
        show(dm.getGreenValue(),dm.getBlueValue(),dm.getRedValue());
	}

}
