package pet.util;/**
 * Created by Administrator on 2017/8/11.
 */

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间工具类
 *
 * @author Rns
 * @create 2017-08-11 10:15
 */
public class DateUtils {

    private static final GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();

    public static boolean sameDay(Date target, Date standard){
        if(null == target || null == standard){
            return false;
        }

        Calendar calTarget = Calendar.getInstance();
        calTarget.setTime(target);

        Calendar calStandard = Calendar.getInstance();
        calStandard.setTime(standard);

        return calTarget.get(Calendar.YEAR) == calStandard.get(Calendar.YEAR)
                && calTarget.get(Calendar.MONTH) == calStandard.get(Calendar.MONTH)
                &&  calTarget.get(Calendar.DAY_OF_MONTH) == calStandard.get(Calendar.DAY_OF_MONTH);

    }

/*    public static void main(String [] args) throws ParseException {
        String target = "2017-08-11 12:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sameDay(sdf.parse(target),new Date()));
    }*/

}
