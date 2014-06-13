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

    public String sendGetRequest(String url) throws MalformedURLException, IOException {
        URL getRequestURL = new URL(url);
        HttpURLConnection con = (HttpURLConnection) getRequestURL.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("content-type", "application/json");

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
        con.disconnect();
        return response.toString();
        
    }
    


    // HTTP POST request
    public String sendPostRequest(String url) throws Exception {
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        //add reuqest header
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setRequestProperty("content-type", "application/json");
        
        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.writeBytes(url);
            wr.flush();
        }
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Message : " + url);
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
        con.disconnect();
        return response.toString();
    }

}
