package com.sing.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.validator.routines.UrlValidator;

/**
 * Simple Httputils
 */
public class HttpUtils {

    /**
     * Get request
     * @param url
     * @return
     * @throws Exception
     */
    public HttpResponse<JsonNode> getResponseEntity(final String url) throws Exception {
        boolean isValid = getUrlValidator(url);
        HttpResponse<JsonNode> response;
        if (isValid) {
            try {
                response = Unirest.get(url).asJson();
            } catch (UnirestException e) {
                throw new Exception("Exception in getting data from the supplied URL: {}", e);
            }
        } else {
            throw new Exception("Not a valid URL supplied");
        }


        if(response.getStatus() != 200) {
            throw new Exception("Not a success response status code check the URL");
        }

        return response;

    }

    protected boolean getUrlValidator(final String url) {
        return new UrlValidator().isValid(url);
    }


}
