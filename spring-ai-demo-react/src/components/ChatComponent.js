// import React, { useState } from "react";

// function ChatComponent() {
//   const [prompt, setPrompt] = useState("");
//   const [chatResponse, setChatResponse] = useState("");

//   const askAI = async () => {
//     try {
//       const response = await fetch(
//         `http://localhost:9090/ask-ai?prompt=${prompt}`
//       );
//       const data = await response.text();
//       console.log(data);
//       setChatResponse(data);
//     } catch (error) {
//       console.error("Error generating image:", error);
//     }
//   };

//   return (
//     <div>
//       <h2>Talk to AI</h2>
//       <input
//         type="text"
//         value={prompt}
//         onChange={(e) => setPrompt(e.target.value)}
//         placeholder="Enter a prompt for AI"
//       />
//       <button onClick={askAI}>Ask AI </button>
//       <div className="output">
//         <p>{chatResponse}</p>
//       </div>
//     </div>
//   );
// }

// export default ChatComponent;

import React, { useState } from "react";

function ChatComponent() {
  const [prompt, setPrompt] = useState("");
  const [chatResponse, setChatResponse] = useState("");

  const askAI = async () => {
    try {
      const response = await fetch(
        `http://localhost:9090/ask-ai?prompt=${encodeURIComponent(prompt)}`
      );
      const data = await response.text();
      console.log(data);
      setChatResponse(data);
    } catch (error) {
      console.error("Error asking AI:", error);
    }
  };

  return (
    <div className="tab-content">
      <h2>Talk to AI</h2>
      <input
        type="text"
        className="prompt-input"
        value={prompt}
        onChange={(e) => setPrompt(e.target.value)}
        placeholder="What would you like to ask?"
      />
      <button className="generate-btn" onClick={askAI}>
        Ask AI
      </button>

      {chatResponse && (
        <div className="ai-response-box">
          <p>{chatResponse}</p>
        </div>
      )}
    </div>
  );
}

export default ChatComponent;
