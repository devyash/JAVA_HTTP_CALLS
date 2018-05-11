import java.io.IOException;


/**
 * 
 * @author devyash
 * @function to return http://fakerestapi.azurewebsites.net/api/Books
 * Given Json file
Return max length word count
Word with max vowels..if the count is same return the first one
Word with max length
Programming Exercise: (data fetched using REST API.
 I was spared of this requirement since I was using C++). 
 1) Extracting most frequently occurring words, vowel, 
 word of most frequently occurring word length.
 2) Question related to mapping to and from letters. 
3) I didn't have time to read it. 
I was told that it was about permutations. 
 OkHttp.
 javax.net.ssl.HttpsURLConnection
 APACHE HTTP CLIENT
  
 */


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;


public class SampleClass {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		SampleClass http = new SampleClass();
		
		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();

	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "http://fakerestapi.azurewebsites.net/api/Books";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
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
		
		JSONArray obj1 = new JSONArray(response.toString());
		JSONObject obj2 = obj1.getJSONObject(5);
		System.out.println(obj2);
		
	}
	
	// HTTP POST request
	private void sendPost() throws Exception {

		String url = "https://selfsolve.apple.com/wcResults.do";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
		
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

}
