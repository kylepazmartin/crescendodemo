package com.crescendo.demo.api;

import com.crescendo.demo.model.Responses;
import com.crescendo.demo.model.Review;
import com.crescendo.demo.model.Reviews;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("api/v1/review")
@RestController
public class ReviewController {

    @Autowired
    private Environment env;

    Gson gson = new Gson();
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping(path = "{id}")
    public Reviews getReview(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+ env.getProperty("YELP.API.KEY"));
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<String> reviewResponse = restTemplate.exchange(
                String.format("https://api.yelp.com/v3/businesses/%s/reviews",id), HttpMethod.GET, entity, String.class, Review.class);
        Reviews reviews = gson.fromJson(reviewResponse.getBody(), Reviews.class);

        for (Review review : reviews.getReviews()) {
            if (review.getUser() != null) {
                review.getUser().setEmotion(emotionSetter(review.getUser().getImage_url()));
            }
        }
        return reviews;
    }

    private String emotionSetter(String userImageURL) {
        String body;

        body = "{\n" +
                "  \"requests\": [\n" +
                "    {\n" +
                "      \"features\": [\n" +
                "        {\n" +
                "          \"maxResults\": 10,\n" +
                "          \"type\": \"FACE_DETECTION\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"image\": {\n" +
                "        \"source\": {\n" +
                "          \"imageUri\": \"" + userImageURL + "\"\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        HttpEntity<String> fEntity = new HttpEntity<>(body);
        ResponseEntity<String> facialRecognitionResponse = restTemplate.exchange(
                String.format("https://vision.googleapis.com/v1/images:annotate?key=%s",env.getProperty("GOOGLE.APP.VISION")),
                HttpMethod.POST, fEntity, String.class, Responses.class);
        Responses res = gson.fromJson(facialRecognitionResponse.getBody(), Responses.class);
        String likelihood = "JoyLikelihood: " + res.getResponses().get(0).getFaceAnnotationsList().get(0).getJoyLikelihood()
                + ", " + "Angerlikelihood: " + res.getResponses().get(0).getFaceAnnotationsList().get(0).getAngerLikelihood()
                + ", " + "BlurredLikelihood: " + res.getResponses().get(0).getFaceAnnotationsList().get(0).getBlurredLikelihood()
                + ", " + "HeadwearLikelihood: " + res.getResponses().get(0).getFaceAnnotationsList().get(0).getHeadwearLikelihood()
                + ", " + "SorrowLikelihood: " + res.getResponses().get(0).getFaceAnnotationsList().get(0).getSorrowLikelihood()
                + ", " + "SurpriseLikelihood: " + res.getResponses().get(0).getFaceAnnotationsList().get(0).getSurpriseLikelihood()
                + ", " + "UnderExposedLikelihood: " + res.getResponses().get(0).getFaceAnnotationsList().get(0).getUnderExposedLikelihood();

        return likelihood;
    }
}
