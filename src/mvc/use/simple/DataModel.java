package mvc.use.simple;

import java.util.Observable;

public abstract class DataModel extends Observable {
      public abstract void setValue(int r,int b,int g);
      public abstract int getRedValue();
      public abstract int getBlueValue();
      public abstract int getGreenValue();
}
