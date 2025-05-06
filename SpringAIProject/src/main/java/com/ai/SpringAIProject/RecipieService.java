package com.ai.SpringAIProject;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class RecipieService {

    private final ChatModel chatModel;


    public RecipieService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String createRecipe(String ingredients,
                               String cuisine,
                               String diataryRestrictions) {
        var template = """
                I want to create a recipe using the following ingredients: {ingredients}
                The cuisine should be {cuisine}
                The diatary restrictions should be {diataryRestrictions}
                please provide me with a detailed recipe including title, ingredients, cooking time, and instructions.
                """;

        PromptTemplate promptTemplate = new PromptTemplate(template);
        Map<String, Object> params = Map.of(
                "ingredients", ingredients,
                "cuisine", cuisine,
                "diataryRestrictions", diataryRestrictions
        );
        Prompt prompt = promptTemplate.create(params);
        return chatModel.call(prompt).getResult().getOutput().getText();
    }
}
