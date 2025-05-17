# Spring Boot AI Project

This is a simple Spring Boot AI project with integrated services for chat, image generation, and recipe generation using OpenAI APIs. The project includes both backend services built with Spring Boot and a frontend built with React.

## Project Overview

This project demonstrates how to use various OpenAI APIs to provide different services in a backend Spring Boot application. The project is divided into several key components:

1. **Chat Service**: A service to handle user queries and generate AI-based responses.
2. **Image Generation**: Uses OpenAI API to generate images based on user input.
3. **Recipe Generator**: Generates recipes based on input ingredients using the OpenAI API.
4. **React Frontend**: Provides a simple interface for users to interact with the services.

### Features
- **AI Chatbot**: Chat interface that communicates with an AI model to generate responses.
- **Image Generation**: Allows users to input prompts and receive AI-generated images.
- **Recipe Generation**: Users can input ingredients and get recipes in return.
- **React-based Frontend**: A simple interface for interacting with the backend services.

## Technologies Used

- **Backend**:
  - Spring Boot (Java)
  - OpenAI API for AI chat, image generation, and recipe generation
  - Restful API design

- **Frontend**:
  - React
  - Axios for API communication

## Project Structure

- **src/main/java/com/example/springaiproject**: Contains all the Java files for the backend services.
  - `ChatService.java`: Handles the chatbot interactions.
  - `GenAiController.java`: Controller for the AI-related endpoints.
  - `ImageService.java`: Manages image generation requests.
  - `RecipieService.java`: Handles recipe generation logic.
  - `SpringAiProjectApplication.java`: Main class to start the Spring Boot application.
  - `WebConfig.java`: Configuration class for setting up backend services.
  
- **src/main/resources**: Contains application properties and configuration files.
  
- **frontend/**: Contains the React frontend code.
