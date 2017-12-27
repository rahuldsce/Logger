package logger.toniq.logutil;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class AppLogger
{
    public static void logException(String errorPath, Exception e)
    {
        // Log.e("Exception", errorPath + "-->" + getStackTrace(e));
    }

    public static void logInfo(String msg)
    {
        Log.e("NeuBio", msg);
    }

    private static String getStackTrace(Exception e)
    {
        String stackTrace = "";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        e.printStackTrace(printStream);
        try
        {
            stackTrace = byteArrayOutputStream.toString("UTF8");
        }
        catch (Exception e1)
        {
            e.printStackTrace();
        }
        printStream.close();
        try
        {
            byteArrayOutputStream.close();
        }
        catch (IOException e1)
        {
            e.printStackTrace();
        }

        return stackTrace.trim();
    }
}
