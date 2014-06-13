package imsclient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
        System.out.println("Response: " + response.toString());
        if (con != null) {
            con.disconnect();
        }
        return response.toString();

    }

//    // HTTP POST request
//    public String sendPostRequest(String url, String json) throws Exception {
//        URL obj = new URL(url);
//        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
//        //add reuqest header
//        con.setRequestMethod("POST");
//        con.setDoOutput(true);
//        con.setRequestProperty("content-type", "application/json");
//        
//        
//        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
//            wr.writeBytes(url);
//            wr.flush();
//        }
//        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'POST' request to URL : " + url);
//        System.out.println("Message : " + url);
//        System.out.println("Response Code : " + responseCode);
//
//        StringBuffer response;
//        try (BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()))) {
//            String inputLine;
//            response = new StringBuffer();
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//        }
//
//        //print result
//        System.out.println(response.toString());
//        con.disconnect();
//        return response.toString();
//    }
    
    
    // HTTP POST request
	private void sendPost(String url, String json) throws Exception {
 
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		//con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
		String urlParameters = json;
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
 
	}
 


    public static String sendPostRequest(String targetURL, String json) {
        URL url;
        HttpURLConnection connection = null;
        try {
            //Create connection
            url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length", ""
                    + Integer.toString(json.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            try ( //Send request
                    DataOutputStream wr = new DataOutputStream(
                            connection.getOutputStream())) {
                        wr.writeBytes(json);
                        wr.flush();
                    }

                    //Get Response	
                    InputStream is = connection.getInputStream();
                    StringBuilder response;
                    try (BufferedReader rd = new BufferedReader(new InputStreamReader(is))) {
                        String line;
                        response = new StringBuilder();
                        while ((line = rd.readLine()) != null) {
                            response.append(line);
                            response.append('\r');
                        }
                    }
                    return response.toString();

        } catch (IOException e) {

            return null;

        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }
    }

}
