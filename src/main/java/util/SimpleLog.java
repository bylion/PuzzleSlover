package util;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class SimpleLog
{
    public static void writelog(String log)
    {
        System.out.println(new Date()+log);
    }
}