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
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Search;

public class ProductRestHttpClientApp {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		System.out.println("\n====================================\n");
//		// 1.1 Http Get 방식 Request : JsonSimple lib 사용
		//ProductRestHttpClientApp.addProductTest_JsonSimple();
		
		System.out.println("\n====================================\n");
//		// 1.2 Http Get 방식 Request : CodeHaus lib 사용
		//ProductRestHttpClientApp.addProductTest_Codehaus();
		
		System.out.println("\n====================================\n");
//		// 2.1 Http Post 방식 Request : JsonSimple lib 사용
		//ProductRestHttpClientApp.getProductTest_JsonSimple();
		
		System.out.println("\n====================================\n");
//		// 1.2 Http Post 방식 Request : CodeHaus lib 사용
		//ProductRestHttpClientApp.getProductTest_Codehaus();	
		
		//ProductRestHttpClientApp.updateProductTest_JsonSimple();
		//ProductRestHttpClientApp.updateProductTest_Codehaus();
		
		//ProductRestHttpClientApp.updateProductPostTest_JsonSimple();
		//ProductRestHttpClientApp.updateProductPostTest_Codehaus();
		
		//ProductRestHttpClientApp.listProductTest_Codehaus();
		ProductRestHttpClientApp.listProductPostTest_Codehaus();

	}

	private static void addProductTest_JsonSimple() throws ClientProtocolException, IOException {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/addProduct";
				
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		json.put("prodName", "prodName");
		json.put("prodDetail", "prodDetail");
		json.put("manuDate", "2018-11-11");
		json.put("price", "12345");
		json.put("fileName", "fileName");
		
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
	}

	private static void addProductTest_Codehaus() throws ClientProtocolException, IOException {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/addProduct";
				
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		json.put("prodName", "prodName");
		json.put("prodDetail", "prodDetail");
		json.put("manuDate", "2018-11-11");
		json.put("price", "12345");
		json.put("fileName", "fileName");
		
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
		Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		System.out.println(product);
		
	}

	private static void getProductTest_JsonSimple() throws ClientProtocolException, IOException {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/getProduct/10002/search";
				
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		System.out.println(httpResponse);
		System.out.println();
		
		HttpEntity httpResEntity = httpResponse.getEntity();
		InputStream is = httpResEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println(jsonobj);		
	}

	private static void getProductTest_Codehaus() throws IllegalStateException, IOException {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/getProduct/10002/search";
				
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
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
	
	private static void updateProductTest_JsonSimple() throws ClientProtocolException, IOException {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/updateProduct/10002";
				
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		System.out.println(httpResponse);
		System.out.println();
		
		HttpEntity httpResEntity = httpResponse.getEntity();
		InputStream is = httpResEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println(jsonobj);		
	}

	private static void updateProductTest_Codehaus() throws ClientProtocolException, IOException {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/updateProduct/10002";
				
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
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
	
	private static void updateProductPostTest_JsonSimple() throws ClientProtocolException, IOException {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/updateProduct";
				
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		json.put("prodNo", 10002);
		json.put("prodName", "prodName2");
		json.put("prodDetail", "prodDetail2");
		json.put("manuDate", "2018-11-12");
		json.put("price", "123452");
		json.put("fileName", "fileName2");
		
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
	}

	private static void updateProductPostTest_Codehaus() throws ClientProtocolException, IOException {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/updateProduct";
				
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		json.put("prodNo", 10002);
		json.put("prodName", "prodName3");
		json.put("prodDetail", "prodDetail3");
		json.put("manuDate", "2018-11-13");
		json.put("price", "123453");
		json.put("fileName", "fileName3");
		
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
		Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		System.out.println(product);
	}
	

	private static void listProductTest_Codehaus() throws ClientProtocolException, IOException {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/listProduct";
				
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		System.out.println(httpResponse);
		System.out.println();
		
		HttpEntity httpResEntity = httpResponse.getEntity();
		InputStream is = httpResEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println(jsonobj);	
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = objectMapper.readValue(jsonobj.toString(), new TypeReference<Map<String,Object>>(){});
		List<Product> product = (List<Product>)map.get("list");
		System.out.println(product);
	}

	private static void listProductPostTest_Codehaus() throws ClientProtocolException, IOException {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/listProduct";
				
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		Search search = new Search();
		search.setCurrentPage(1);
		search.setFilterCondition("0");
		search.setPageSize(3);
		search.setSearchCondition("2");
		search.setSearchKeyword("1100-2000000000");
		search.setSortCondition("0");
		
		ObjectMapper objectMapperBefore = new ObjectMapper();
		String jsonValue = objectMapperBefore.writeValueAsString(search);		
		HttpEntity httpReqEntity = new StringEntity(jsonValue, "utf-8");

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
		Map<String, Object> map = objectMapper.readValue(jsonobj.toString(), new TypeReference<Map<String,Object>>(){});
		List<Product> product = (List<Product>)map.get("list");
		System.out.println(product);
	}
}
