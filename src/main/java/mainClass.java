import org.apache.log4j.Logger;

public class mainClass {

    private static final Logger logger = Logger.getLogger(mainClass.class);

    public static void main(String[] args) throws InterruptedException {



        String  command = "cmd.exe /c @for /f \"skip=1\" %p in ('wmic cpu get loadpercentage') do @echo %p%";
        CPU c1 = new CPU();
        RamSize r1 = new RamSize();

        logger.info("UserName: "+ System.getProperty("user.name"));

        c1.show(command);
        Thread.sleep(2000);
        r1.systemRamSize();
        logger.info("--------------------------------------------------");
    }
}

