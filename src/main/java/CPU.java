import  java.io.BufferedReader;             //buffer lib
import  java.io.InputStreamReader;          //input stream reader lib
import org.apache.log4j.Logger;

public class CPU {

    private static final Logger logger = Logger.getLogger(CPU.class);

    public void show(String data){

//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date = new Date();
//        logger.info(dateFormat.format(date));
//        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43

        try {

            Process p =  Runtime.getRuntime().exec(data);
            BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String logmessage = "";

            while ((logmessage = inputBuffer.readLine())!= null){
                logger.info("CPU Usage: "+logmessage);
                //System.out.println("CPU Usage is : " + logmessage);
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("something go wrong!!!!");
            //System.out.println("something go wrong!!!!");
        }
    }
}