package Chapter7.Encapsulation;

/**
 * @author Lindokuhle Makanda
 *
 */
public class Kettle
{
    private boolean waterBoiling = false, heatSensorOn = false, isWater = false;

   public void switchOn()
   {
       if(isThereWater()){
           System.err.println("Switching on...");
           accessElectricity();
           heatUpSensor();
           if (isWaterBoiling()){
               waterBoiling = true;
               switchOff();
           }
       }else{
           switchOff();
           putWater();
       }
   }
   private void heatUpSensor(){
       System.err.println("Sensor heating up...");
       heatSensorOn = true;
   }

   private boolean isWaterBoiling(){
       System.err.println("Water is boiling...");
       return true;
   }

   public void switchOff(){ System.err.println("Switching off...");}

    public void putWater(){
        isWater = true;
    }

    private void accessElectricity(){ System.err.println("Using electricity...");}

    private boolean isThereWater(){
       return isWater;
    }
}
