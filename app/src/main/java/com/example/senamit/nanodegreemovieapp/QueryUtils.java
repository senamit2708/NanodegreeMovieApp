package com.example.senamit.nanodegreemovieapp;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by senamit on 2/12/17.
 */

public class QueryUtils {

    public static final String LOG_TAG = QueryUtils.class.getSimpleName();

    public static String stringUrl = "https://api.themoviedb.org/3/movie/550?api_key=f6fc8d8e4043fefdfe43c153dd429479";

    //now lets create url from the string
    //and return the url to the calling function
    //create it as static

    public static URL createUrl (String stringUrl) throws MalformedURLException {
        if (stringUrl==null){
            return null;
        }
        URL url = null;

        url = new URL(stringUrl);
        Log.i(LOG_TAG, "the created url is  "+url);
        return url;

    }

    //now once the url is created ..lets do the http request
    //and once we hit the http request, we get the json response
    //so return type is json data in form of string

    public static String makeHttpRequest(URL url) throws IOException {
        Log.i(LOG_TAG, "inside makehttp request starting point");

        if (url==null){
            return null;
        }

        //here variables are initialised to null, normally try to initialise all the variables
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        String jsonResponse = null;


        try {


            Log.i(LOG_TAG, "inside the try block of makehttp request");
            //open the url connection , then exception is added and then its cast into httpurlconnection because we hit http connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            //HERE WE SET THE REQUEST TYPQ IS GET, AS THERE ARE I THINK TWO TYPES OF REQUEST MODE...LETS SEE IN OFFICE THE TYPE OF REQUESET
            urlConnection.setRequestMethod("GET");
            //NOW LETS connect THE CONNECTION..it means lets hit the api server by conncting the urlconnection
            urlConnection.connect();
            //once the connection is connected, we have to check the connection is fine or retuned some error
            if (urlConnection.getResponseCode() == 200) {

                Log.i(LOG_TAG, "connection is stablishes here and the response code is  "+urlConnection.getResponseCode());
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
                Log.i(LOG_TAG,"returned form readfromStream successfully");

            } else {
                Log.i(LOG_TAG, "the urlConnection is bad");
                return null;
            }
        }
        catch (IOException e){
            Log.i(LOG_TAG, "the  connection is interuptrd "+e);
        }finally {
            //in the finally block lets close whatever we have opened,
            //so here we have open the connection and also the inputstream to read the data
            if (urlConnection !=null){
                urlConnection.disconnect();
            }
            if (inputStream != null){
                inputStream.close();
            }
        }


        return jsonResponse;

    }

    //lets read the json data from here line by line
    //i dont know really whats here clearly
    private static String readFromStream(InputStream inputStream) throws IOException {

        Log.i(LOG_TAG, "inside the readformstream method ");

        //stringbuilder is a type of string in which we can add as many times as we want ...thats why its differnt from normal string
        StringBuilder output = new StringBuilder();

        if (inputStream!= null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //lets read the first line ...it means we r initialising the variable
            //here we r using while loop ..so initialisation is done before calling the while loop

            String line = bufferedReader.readLine();


            Log.i(LOG_TAG, "read the first line from bufferreader by using read line  "+ line);
           // put condition that this loop will run until its null
            while (line !=null){
                Log.i(LOG_TAG, "inside the while loop of read line ");

                //append is used to adding the new lines that we r getting through read line
                output.append(line);
                //read line reads the data line by line
                //one line at a time and put the cursor to that postion, so that if its called next time,
                //we can read the next line easily
                line = bufferedReader.readLine();
                Log.i(LOG_TAG, "lets read the line for our knowledge purpose:-  "+ line);
            }
            Log.i(LOG_TAG, "the final data is to be read further is: "+ output);

        }
        return output.toString();

    }


    public static void fetchMovieRequest() throws IOException {
        URL url = createUrl(stringUrl);

        String  jsonResponsee = null;

       jsonResponsee = makeHttpRequest(url);
       Log.i(LOG_TAG, "the fetch movie request is  "+ jsonResponsee);
    }
}
