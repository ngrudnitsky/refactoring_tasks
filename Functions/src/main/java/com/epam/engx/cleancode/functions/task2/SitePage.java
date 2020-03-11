package com.epam.engx.cleancode.functions.task2;


import java.util.Map;


public class SitePage {
    private static final String PAGE_URL_BEGINNING = "http://mysite.com/?edit=true";
    private final String pageUrlAttributes;

    public SitePage(String siteGroup, String userGroup) {
        pageUrlAttributes = "&siteGrp=" + siteGroup + "&userGrp=" + userGroup;
    }

    public String getEditablePageUrl(Map<String, String> params) {
        return PAGE_URL_BEGINNING + getUrlParameters(params) + pageUrlAttributes;
    }

    private String getUrlParameters(Map<String, String> params) {
        StringBuilder urlParameters = new StringBuilder();

        for (Map.Entry<String, String> param : params.entrySet()) {
            urlParameters.append("&").append(param.getKey())
                    .append("=").append(param.getValue());
        }
        return urlParameters.toString();
    }
}
