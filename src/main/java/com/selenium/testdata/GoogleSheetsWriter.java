package com.selenium.testdata;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;

import java.io.FileInputStream;
import java.io.FileReader;
import java.security.GeneralSecurityException;
import java.util.*;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.http.HttpCredentialsAdapter;

public class GoogleSheetsWriter {

    private static final String APPLICATION_NAME = "Selenium Scraper to Google Sheets";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    // Set your spreadsheet ID and sheet name
    private static final String SPREADSHEET_ID = "1n1KdkZ1BqVIoZOm6lBRCX8x9cRWYOWVvai6bhIfCZhY";
    private static final String SHEET_NAME = "Sheet1";

    public static Sheets getSheetsService() throws Exception {

        GoogleCredentials credentials = GoogleCredentials
                .fromStream(new FileInputStream("//google-cred.json"))
                .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));


        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, new HttpCredentialsAdapter(credentials))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static void writeToSheet(List<String> outerHTMLList) throws Exception {
        Sheets service = getSheetsService();

        List<List<Object>> values = new ArrayList<>();

        // Add headers
        values.add(Arrays.asList("number", "data"));

        // Add rows
        for (int i = 0; i < outerHTMLList.size(); i++) {
            List<Object> row = Arrays.asList(i + 1, outerHTMLList.get(i));
            values.add(row);
        }

        ValueRange body = new ValueRange()
                .setValues(values);

        service.spreadsheets().values()
                .update(SPREADSHEET_ID, SHEET_NAME + "!A1", body)
                .setValueInputOption("RAW")
                .execute();

        System.out.println("Data successfully written to Google Sheets.");
    }
}

