package com.ai.SpringAIProject;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class GenAiController {

    private final ChatService chatService;
    private final ImageService imageService;
    private final RecipieService recipieService;

    public GenAiController(ChatService chatService, ImageService imageService, RecipieService recipieService) {
        this.chatService = chatService;
        this.imageService = imageService;
        this.recipieService = recipieService;
    }

    @GetMapping("ask-ai")
    public String getResponse(@RequestParam String prompt){
        return chatService.getResponse(prompt);
    }

    @GetMapping("ask-ai-options")
    public String getResponseOptions(@RequestParam String prompt){
        return chatService.getResponseOptions(prompt);
    }

//    @GetMapping("generate-image")
//    public void generateImages(HttpServletResponse response, @RequestParam String prompt) throws IOException {
//        try {
//            // Generate the image
//            ImageResponse imageResponse = imageService.generateImage(prompt);
//
//            // Check if the response or result is null
//            if (imageResponse == null || imageResponse.getResult() == null) {
//                throw new RuntimeException("Image generation failed. No result received.");
//            }
//
//            // Extract the URL of the generated image
//            String imageUrl = imageResponse.getResult().getOutput().getUrl();
//
//            // Redirect to the image URL
//            response.sendRedirect(imageUrl);
//
//        } catch (Exception e) {
//            // Log the error and return a proper response to the client
//            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            response.getWriter().write("Error generating image: " + e.getMessage());
//            e.printStackTrace(); // Log the exception for debugging
//        }
//    }
    @GetMapping("generate-image")//this is generate-image endpoint
    public List<String> generateImagesOptions(HttpServletResponse response, @RequestParam String prompt, @RequestParam(defaultValue = "hd") String quality, @RequestParam(defaultValue = "1")int n, @RequestParam(defaultValue = "1024")int height, @RequestParam(defaultValue = "1024")int width) throws IOException {
        ImageResponse imageResponse = imageService.generateImage(prompt, quality, n, height, width);

        //streams to get urls from ImageResponse
        List<String> imageUrls = imageResponse.getResults().stream().map(result -> result.getOutput().getUrl()).toList();

        return imageUrls;
    }

    @GetMapping("recipe-creator")
    public String recipeCreator(@RequestParam String ingredients, @RequestParam(defaultValue = "any") String cuisine, @RequestParam(defaultValue = "") String diataryRestrictions) {
        return recipieService.createRecipe(ingredients, cuisine, diataryRestrictions);

    }


}
