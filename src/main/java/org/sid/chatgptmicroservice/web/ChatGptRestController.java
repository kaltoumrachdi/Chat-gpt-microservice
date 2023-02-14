package org.sid.chatgptmicroservice.web;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ChatGptRestController {
    final String APK_KEY = "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";
    final String CSV_PATH = "C:\\Users\\azert\\Desktop\\Stage pré embauche\\chatGPTmicroservice\\src\\main\\resources\\chatGpt.csv";

    @PostMapping("/answer")
    public ResponseEntity<String> answerQuestion(@RequestBody String question)
    {
        String requestUrl = "https://api.openai.com/v1/completions";
        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("model", "text-davinci-003");
        requestBody.put("prompt", question);
        requestBody.put("max_tokens", 4000);
        requestBody.put("temperature", 1.0);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + this.APK_KEY);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(requestUrl, request, String.class);
        String jsonData = response.getBody();
        JSONObject json = new JSONObject(jsonData);

        JSONArray choices = json.getJSONArray("choices");
        JSONObject firstChoice = choices.getJSONObject(0);

        String text = firstChoice.getString("text");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Question").append(";").append("answer").append("\n");


        if (response.getStatusCode().is2xxSuccessful()) {
            stringBuilder.append(question).append(";").append(text).append(", ");
            try (FileWriter writer = new FileWriter(this.CSV_PATH, true)) {
                writer.write(stringBuilder.toString());
            } catch (IOException e) {
                System.err.println("An error occurred while writing to the file: " + e.getMessage());
            }
            return new ResponseEntity<>(text, HttpStatus.OK);
        }

        return new ResponseEntity<>("Error communicating with OpenAI API", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
