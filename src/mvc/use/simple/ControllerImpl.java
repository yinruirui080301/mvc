package mvc.use.simple;

public class ControllerImpl implements IController {
    private DataModel dataModel;
    public void setDataModel(DataModel dataModel) {
    	this.dataModel=dataModel;
    }
	@Override
	public void setValue(int r, int b, int g) {
		// TODO Auto-generated method stub
       dataModel.setValue(r, b, g);
	}

}
