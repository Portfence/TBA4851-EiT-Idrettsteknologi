package app;

import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Albert
 */
public class URLReader {

    private URL webData;
    private String[] weatherData;
    private String currentLine;

    /**
     * Creates a date which is the starting point of the data we are interested
     * in.
     *
     * @throws MalformedURLException
     */
    public URLReader() throws MalformedURLException {
        Date today = new Date();
        String from = parseDate(today);
        String url = "http://alfeh.azurewebsites.net/get_temp_data.php" + from;
        webData = new URL(url);
    }

    /**
     * incase data from today not available
     *
     * @param yesterday
     * @throws MalformedURLException
     */
    public URLReader(boolean yesterday) throws MalformedURLException {
        Date today = new Date();
        String from = parseDate(yesterday());
        String url = "http://alfeh.azurewebsites.net/get_temp_data.php" + from;
        System.out.println(url);
        webData = new URL(url);
    }

    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    /**
     * parses the data in the web page of the URL.
     *
     * @return true if successfully executed
     * @throws IOException
     */
    public boolean parseURL() throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(webData.openStream()));
        //stores reference time for runtime
        long then = System.currentTimeMillis();
        currentLine = in.readLine();
        String lastLine;
        String[] tokens = currentLine.split("}");
        try {
            lastLine = tokens[tokens.length - 2];
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        Object[] objectData = extractDataFromLine(lastLine);
        weatherData = (String[]) objectData[0];
        ArrayList<Integer> nullNumbers = (ArrayList) objectData[1];
        if (!nullNumbers.isEmpty()) {
            usePreviousData(nullNumbers);
        }
        //prints actual runtime
        System.out.println("Runtime: " + (System.currentTimeMillis() - then));
        in.close();
        return true;
    }

    /**
     * A getter for the weatherData.
     *
     * @return
     */
    public String[] getWeatherData() {
        return weatherData;
    }

    /**
     * Call this method to get latest data from URL
     *
     * @throws MalformedURLException
     */
    public void updateURL() throws MalformedURLException {
        webData = new URL("http://alfeh.azurewebsites.net/get_temp_data.php");
    }

    /**
     * Used to set the date at which the gathering of data should start. The
     * date is set to todays date to increase runtime.
     *
     * @param today
     * @return
     */
    private String parseDate(Date today) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String returnString = s.format(today);
        return "?from=" + returnString;
    }

    /**
     * Splits the line at " to extract data. The data we need is always at index
     * 3.
     *
     * @param lastLine
     * @return
     */
    private Object[] extractDataFromLine(String lastLine) {
        String temp_1, temp_2, temp_3, pressure, relativeHum;
        ArrayList<Integer> nullNumber = new ArrayList<>();
        //lastLine = ",{\"time\":\"2017-03-15T10:52:04.363\",\"id\":\"862643032870150\",\"sq\":\"-94 \",\"batt\":\"3.85\",\"baro\":\"98355\",\"rh\":null,\"t1\":\"20.7\",\"t2\":\"31.0\",\"t3\":\"26.6\"}";
        String[] type = lastLine.split(",");
        String date = type[1].split("\"")[3];
        String data[] = new String[5];
        for (int i = 5; i < type.length; i++) {
            if (type[i].contains("\":" + null)) {
                //do not change the data
                nullNumber.add(i);
            } else {
                data[i - 5] = type[i].split("\"")[3];
                //System.out.println(data[i-5]);

            }
        }
        pressure = data[0];
        relativeHum = data[1];
        temp_1 = data[2];
        temp_2 = data[3];
        temp_3 = data[4];

        return new Object[]{new String[]{date, pressure, relativeHum, temp_1, temp_2, temp_3}, nullNumber};
    }

    /**
     * Unimplemented - if a sensor shows "null" then this function should return
     * the previous data for the sensors in question. returns void or something
     * else
     *
     * @param nullNumber
     */
    private void usePreviousData(ArrayList<Integer> nullNumber) {
//        for (int i = 0; i < nullNumber.toArray().length; i++) {
//            //currentLine
//        }
    }
}
