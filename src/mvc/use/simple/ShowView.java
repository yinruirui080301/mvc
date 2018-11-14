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
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class ShowView implements Observer {
	//显示饼图
    private void show(int g,int b,int r) {
    	//设置数据
    	DefaultPieDataset dpds=new DefaultPieDataset();
    	dpds.setValue("red",r);
    	dpds.setValue("green", g);
    	dpds.setValue("blue", b);
    	//创建图
    	JFreeChart chart=ChartFactory.createPieChart("hello", dpds, true, true, false);
    	PiePlot pp=(PiePlot)chart.getPlot();
    	//设置饼的各部分的颜色
    	pp.setSectionPaint("red", Color.red);
    	pp.setSectionPaint("green", Color.green);
    	pp.setSectionPaint("blue", Color.blue);
    	try {
    		//以窗口的形式显示图
    	 ChartFrame cf=new ChartFrame("饼状图",chart);
    	 cf.setSize(300,300);
    	 cf.setVisible(true);
    	 //将图保存到文件
    	 OutputStream os=new FileOutputStream("G:\\pie.jpg");
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
