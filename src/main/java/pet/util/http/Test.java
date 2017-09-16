package pet.util.http;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hama on 2017/9/16.
 */
public class Test {




    public static void main(String[] args) throws Exception {

        String url = "http://node-cg.xwjrfw.cn:4200/pipeway/v1/notifications";
        DefaultHttpClient client = new DefaultHttpClient();

        org.apache.http.params.HttpParams params = client.getParams();
        HttpConnectionParams.setConnectionTimeout(params, 50 * 1000);
        HttpConnectionParams.setSoTimeout(params, 20 * 1000);


        HttpPost request = new HttpPost(url);
        List<NameValuePair> formParams = new ArrayList<>();
        formParams.add(new BasicNameValuePair("topic","RESET_CACHE"));
        formParams.add(new BasicNameValuePair("msg","{\"key\":\"/api/v2/user/:userId/fundaccounts\",\"userId\":\"1929E3C8-042D-4B88-8EEB-8C34545EB682\"}"));
        request.setEntity(new UrlEncodedFormEntity(formParams, HTTP.UTF_8));
        sendRequest(client,request,3);
        //send(url);
    }

    public static void sendRequest(HttpClient client, HttpPost request, int count) {

        for (int i = 0; i < count; i++) {
            try {
                System.out.println(new Date().toLocaleString());
                HttpResponse response = client.execute(request);
                InputStream content = response.getEntity().getContent();
                if(org.apache.http.HttpStatus.SC_OK==response.getStatusLine().getStatusCode()){
                    System.out.println(content.available());
                    System.out.println(convertStreamToString(content));
                }


                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




    public static String convertStreamToString(InputStream is) {
        /*
          * To convert the InputStream to String we use the BufferedReader.readLine()
          * method. We iterate until the BufferedReader return null which means
          * there's no more data to read. Each line will appended to a StringBuilder
          * and returned as String.
          */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }





}
