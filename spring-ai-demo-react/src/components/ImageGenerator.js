import React, { useState } from "react";

function ImageGenerator() {
  const [prompt, setPrompt] = useState("");
  const [imageUrls, setImageUrls] = useState([]);

  const generateImage = async () => {
    try {
      const response = await fetch(
        `http://localhost:9090/generate-image?prompt=${prompt}`
      );
      const urls = await response.json();
      setImageUrls(urls);
      console.log(urls);
    } catch (error) {
      console.error("Error generating image:", error);
    }
  };

  return (
    <div className="tab-content">
      <h2>Generate Image</h2>
      <input
        type="text"
        className="prompt-input"
        value={prompt}
        onChange={(e) => setPrompt(e.target.value)}
        placeholder="Enter prompt for image"
      />
      <button className="generate-btn" onClick={generateImage}>
        Generate Image
      </button>

      <div className="image-grid">
        {imageUrls.map((url, index) => (
          <img
            key={index}
            src={url}
            alt={`Generated ${index}`}
            className="generated-image"
          />
        ))}
        {[...Array(4 - imageUrls.length)].map((_, index) => (
          <div
            key={index + imageUrls.length}
            className="empty-image-slot"
          ></div>
        ))}
      </div>
    </div>
  );
}

export default ImageGenerator;
