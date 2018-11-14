package mvc.use.simple;



public class ConcreteDataModel extends DataModel {
    private int green,blue,red;
   
    public ConcreteDataModel() {
    	red=100;
    	green=100;
    	blue=100;
    	
    }
    private void notifyShow() {
    	
    	this.addObserver(new ShowView());
    	this.addObserver(new ShowView2());
    	this.setChanged();
        this.notifyObservers();
    }
	
	public void setValue(int r,int b,int g) {
		// TODO Auto-generated method stub
       red=r; blue=b; green=g;
       notifyShow();
	}

	@Override
	public int getRedValue() {
		// TODO Auto-generated method stub
		return red;
	}

	@Override
	public int getBlueValue() {
		// TODO Auto-generated method stub
		return blue;
	}

	@Override
	public int getGreenValue() {
		// TODO Auto-generated method stub
		return green;
	}

}
