import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        List<String > list = getAnnotationValue(Person.class);
        for (String s : list) {
            System.out.println(s);
        }
        writeToFile(list,new File("javacore21.txt"));

        Date date = new Date();

        LocalDate ld = toLocalDate(date);
        LocalTime lt = toLocalTime(date);
        LocalDateTime ldt = toLocalDateTime(date);

        System.out.println("Date format: "+date);
        System.out.println("LocalDate format: "+ld);
        System.out.println("LocalTime format: "+lt);
        System.out.println("LocalDateTime format: "+ldt);


    }
    public static List<String> getAnnotationValue(Class<?> cl){
        List<String> list = new ArrayList<>();
        Field[]fields = cl.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if(field.getAnnotation(Fielder.class) instanceof Fielder){
                list.add(field.getName() + "  " +field.getAnnotation(Fielder.class).value() );
                /*System.out.print(field.getName() + "   ");
                System.out.println(field.getAnnotation(Fielder.class).value());*/
            }
            
        }
        return list;

    }

    public static void writeToFile(List<String> list, File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(list);
        oos.close();
        os.close();


    }
    public static LocalDate toLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalTime toLocalTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
