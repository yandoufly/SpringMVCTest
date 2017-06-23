package com.yjy.web.controller.consumesproduces.contenttype;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

public class RequestContentTypeClient {
    
    public static void main(String[] args) throws IOException, URISyntaxException {
        
        //����ĵ�ַ
        String url = "http://localhost:8080/springmvc6Test/request/ContentType";
        
        //�ٴ���Http Request(�ڲ�ʹ��HttpURLConnection)
        ClientHttpRequest request = 
            new SimpleClientHttpRequestFactory().   
                createRequest(new URI(url), HttpMethod.POST);
        //����������ͷ����������ͷ�����ݱ��루GBK��
        request.getHeaders().set("Content-Type", "application/json;charset=gbk");
        //����GBK����д����Ӧ������
        String jsonData = "{\"username\":\"zhang\", \"password\":\"123\"}";
        request.getBody().write(jsonData.getBytes("gbk"));
        
        //�ܷ������󲢵õ���Ӧ
        ClientHttpResponse response = request.execute();
        System.out.println(response.getStatusCode());
    }
}
