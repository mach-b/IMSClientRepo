/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imsclient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author markburton
 */
public class HttpHelper {

    public String getRequest(String url) throws MalformedURLException, IOException {
        URL getRequestURL = new URL(url);
        HttpURLConnection con = (HttpURLConnection) getRequestURL.openConnection();
        con.setRequestMethod("GET");

        //add request header
        //con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        StringBuffer response;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }
        
        //print result RETURN STRING - maybe JSON string
        System.out.println("Response: "+response.toString());
        return response.toString();
        
    }
    
    public String getRequest2(String urlString) throws MalformedURLException, IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn
                = (HttpURLConnection) url.openConnection();

//        if (conn.getResponseCode() != 200) {
//            throw new IOException(conn.getResponseMessage());
//        }

        StringBuilder sb;
        try ( // Buffer the result into a string
                BufferedReader rd = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
        }

        conn.disconnect();
        return sb.toString();

    }

    // HTTP POST request
    private void sendPost(String url, String message) throws Exception {
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        //add reuqest header
        con.setRequestMethod("POST");
        //con.setRequestProperty("User-Agent", USER_AGENT);
        //con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        //String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
        // Send post request
        con.setDoOutput(true);
        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.writeBytes(message);
            wr.flush();
        }
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Message : " + message);
        System.out.println("Response Code : " + responseCode);

        StringBuffer response;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }

        //print result
        System.out.println(response.toString());

    }

}
