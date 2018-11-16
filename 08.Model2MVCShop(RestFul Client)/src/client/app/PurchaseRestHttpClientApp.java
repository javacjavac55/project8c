package client.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.Search;

public class PurchaseRestHttpClientApp {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		PurchaseRestHttpClientApp.addPurchaseTest_Codehaus();
		System.out.println("======================================================");
		PurchaseRestHttpClientApp.addPurchasePostTest_Codehaus();
	}
	
	private static void addPurchaseTest_Codehaus() throws ClientProtocolException, IOException {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/purchase/json/addPurchase/10002";
				
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		System.out.println("httpGet"+httpGet);
		
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		System.out.println(httpResponse);
		System.out.println();
		
		HttpEntity httpResEntity = httpResponse.getEntity();
		InputStream is = httpResEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println(jsonobj);
		
		ObjectMapper objectMapper = new ObjectMapper();
		Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		System.out.println(product);
	}
	
	private static void addPurchasePostTest_Codehaus() throws JsonGenerationException, JsonMappingException, IOException {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/purchase/json/addPurchase";
				
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		json.put("prodNo", 10002);
		json.put("buyerId", "user02");
		json.put("paymentOption", "1");
		json.put("receiverName", "receiverName");
		json.put("receiverPhone", "receiverPhone");
		json.put("divyAddr", "divyAddr");
		json.put("divyRequest", "divyRequest");
		json.put("divyDate", "2018-11-11");
		
		HttpEntity httpReqEntity = new StringEntity(json.toString(), "utf-8");

		httpPost.setEntity(httpReqEntity);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		System.out.println(httpResponse);
		System.out.println();
		
		HttpEntity httpResEntity = httpResponse.getEntity();
		InputStream is = httpResEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println(jsonobj);	
		
		ObjectMapper objectMapper = new ObjectMapper();
		Purchase purchase = objectMapper.readValue(jsonobj.toString(), Purchase.class);
		System.out.println(purchase);
	}
}
