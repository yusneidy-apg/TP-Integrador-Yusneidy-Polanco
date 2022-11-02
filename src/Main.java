import org.apache.log4j.Logger;

public class Main {
    public static final Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] args) {

        try{
            int res = 2/0;
        }catch (Exception e){
            LOGGER.error("No se puede dividir por 0");
        }
    }
}