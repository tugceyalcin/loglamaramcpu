import com.sun.management.OperatingSystemMXBean;
import java.io.File;
import java.lang.management.ManagementFactory;
import org.apache.log4j.Logger;


public class RamSize {

    private static final Logger logger = Logger.getLogger(RamSize.class);

    public void systemRamSize(){

//        String userName = System.getProperty("user.name");
//        logger.info("UserName: "+userName);
       // System.out.println("User name : " +userName);

        float memorySize = ((OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
        logger.info("RAM Size = "+(memorySize/(1024*1024*1024))+" gigabytes");
        //System.out.println("RAM Size="+(memorySize/(1024*1024*1024))+" gigabytes");


//        System.out.println("Available processors (cores): " +
//                Runtime.getRuntime().availableProcessors()); //core numbers
        logger.info("Available processors (cores): " +
                Runtime.getRuntime().availableProcessors());

        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();

        /* For each filesystem root, print some info */
        for (File root : roots) {
            logger.info("--------------------------------------------------");
            logger.info("File system root: " + root.getAbsolutePath());
            logger.info("Total space (gigabytes): " + root.getTotalSpace()/(1024*1024*1024));
            logger.info("Free space (gigabytes): " + root.getFreeSpace()/(1024*1024*1024));
            logger.info("Usable space (gigabytes): " + root.getUsableSpace()/(1024*1024*1024));
            logger.info("Used space (gigabytes): "+(root.getTotalSpace()-root.getFreeSpace())/(1024*1024*1024));

        }
    }

}