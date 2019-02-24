package com.sing.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.message.BasicStatusLine;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class TestHttpUtils {


    @Mock
    private Unirest unirest;

    @Mock
    private HttpResponse<JsonNode> response;

    @Test
    void getResponseEntity() throws Exception {


        HttpResponseFactory factory = new DefaultHttpResponseFactory();
        org.apache.http.HttpResponse response = factory.newHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, null), null);
        JSONObject json = new JSONObject();
        json.put("result", "10");
        response.setEntity(new StringEntity(json.toString()));
        HttpResponse<JsonNode> httpResponse = new HttpResponse<>(response, JsonNode.class);
        assertEquals(HttpStatus.SC_OK, httpResponse.getStatus());

    }


    @DisplayName("Testing not a valid URL Exception")
    @Test
    void testNotValidURL() {
        HttpUtils httpUtils = new HttpUtils();
        Exception exception = assertThrows(Exception.class, () -> {
            httpUtils.getResponseEntity(anyString());
        });
        assertEquals("Not a valid URL supplied", exception.getMessage());
    }
}