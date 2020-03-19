
package com.cmi.tools;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cmi.log.LogWriter;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class RequestClient {


    /**
     * 通过GET方式发起http请求
     */

    public void requestByGet(){
        //创建默认的httpClient实例
        CloseableHttpClient httpClient = getHttpClient();
        try {
            //用get方法发送http请求
            HttpGet get = new HttpGet("http://www.baidu.com");
            System.out.println("执行get请求:...."+get.getURI());
            CloseableHttpResponse httpResponse = null;
            //发送get请求
            httpResponse = httpClient.execute(get);
            try{
                //response实体
                HttpEntity entity = httpResponse.getEntity();
                if (null != entity){
                    System.out.println("响应状态码:"+ httpResponse.getStatusLine());
                    System.out.println("-------------------------------------------------");
                    System.out.println("响应内容:" + EntityUtils.toString(entity));
                    System.out.println("-------------------------------------------------");
                }
            }
            finally{
                httpResponse.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                closeHttpClient(httpClient);
            } catch (IOException e){
                e.printStackTrace();
            }
        }

    }


    /**
     *  接口登陆获取session
     * @param address   访问 IP:port
     * @param name    用户明
     * @param pwd    密码
     * @return    session
     */
    public  String login (String address,String name,String pwd){
        LogWriter.info(RequestClient.class,"--登陆接口访问 ...--");
        CloseableHttpClient httpClient = getHttpClient();
        String response = null;
        String str="";
        String result="";
        try {
            HttpPost post = new HttpPost("http://"+address+"/cmis/userSignOn.do");          //这里用上本机的某个工程做测试
            //创建参数列表
           List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("currentUserId", name));
            list.add(new BasicNameValuePair("password", pwd));
            list.add(new BasicNameValuePair("branchId", "811111106"));
            list.add(new BasicNameValuePair("isRememberPassword", "on"));
            //url格式编码
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(list,"UTF-8");
            post.setEntity(uefEntity);
            System.out.println("POST 请求...." + post.getURI());
            //执行请求
            CloseableHttpResponse httpResponse = httpClient.execute(post);
            try{
                HttpEntity entity = httpResponse.getEntity();
                if (null != entity){
                    response = EntityUtils.toString(entity, "UTF-8");
                    if(response.contains("密码错误，不允许登录")){
                        result="fail";
                    }else{
                        // 正则获取empId
                        String regex = "var empId = \\'.*.\\'";
                        Pattern p = Pattern.compile(regex);
                        Matcher m = p.matcher(response);
                        while(m.find()) {
                            str=m.group();
                        }
                        result=str.replace("var empId = '","").replace("'","");
                    }

                }
            } finally{
                httpResponse.close();
            }
            LogWriter.info(RequestClient.class,"获取session:"+result+" 成功");
            return result;
        } catch( UnsupportedEncodingException e){
            LogWriter.error(RequestClient.class,"获取session 失败，请检查登陆接口");
            e.printStackTrace();
            return null;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        finally{
            try{
                closeHttpClient(httpClient);
            } catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }

    }

    /**
     * Post 请求接口
     * @param uri 接口地址
     */
    public String requestByPost(String uri){

        String  result="";
        LogWriter.info(RequestClient.class,"");
        CloseableHttpClient httpClient = getHttpClient();
        String response = null;
        try {
            HttpPost post = new HttpPost(uri);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5000).setConnectionRequestTimeout(1000)
                    .setSocketTimeout(1000*60*17).build(); // 相应超时时间17min

            post.setConfig(requestConfig);
          //  创建参数列表
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("accredit", "LOAN"));

            //url格式编码
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(list,"UTF-8");
            post.setEntity(uefEntity);
            System.out.println("POST 请求...." + post.getURI());
            //执行请求
            CloseableHttpResponse httpResponse = httpClient.execute(post);

            System.out.println(httpResponse.toString());
            try{
                HttpEntity entity = httpResponse.getEntity();
                if (null != entity){
                    response = EntityUtils.toString(entity, "UTF-8");
                    System.out.println("response:"+response);

                    result=response;
                }
            } finally{
                httpResponse.close();
            }
            return result;
        } catch( UnsupportedEncodingException e){
            e.printStackTrace();
            return null;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        finally{
            try{
                closeHttpClient(httpClient);
            } catch(Exception e){
                e.printStackTrace();
            }
        }

    }
    private CloseableHttpClient getHttpClient(){
        return HttpClients.createDefault();
    }

    private void closeHttpClient(CloseableHttpClient client) throws IOException{
        if (client != null){
            client.close();
        }
    }

    public static void main(String[] args) {
        RequestClient rc = new RequestClient();
      //  System.out.println("登陆测试："+rc.login("54.223.53.238:7001","admin","4C590C75BD7D9836E1C960AE0ED2FE7C"));
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        list.add(new BasicNameValuePair("accredit", "LOAN"));
        String session =rc.login("127.0.0.1:8001","admin","aaaa");
     rc.requestByPost("http://127.0.0.1:8001/aaa/eeee.do?EMP_SID="+session+"&TIMES=1553495755327"); //   批次查询 Mag



    }
}