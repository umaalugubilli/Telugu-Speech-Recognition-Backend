### Project Documentation: Telugu Speech Recognition Web Application

---

#### **Project Overview**
This project aims to develop a web application that integrates Telugu speech recognition capabilities. It allows users to interact with a simple UI for performing tasks like a calculator, dialer, and note-making. The application leverages a Python-based Telugu speech recognition model that processes audio files, specifically in the `.wav` format, and provides real-time predictions. The backend of the application is built using **Spring Boot**, and the speech recognition model is exposed via a **FastAPI** REST API.

---

### **Features**

- **Speech Recognition for Telugu Digits:** The core feature is the ability to process Telugu speech and recognize digits spoken in the language.
- **Calculator Functionality:** The app includes a speech-enabled calculator to perform basic arithmetic operations.
- **Dialer Functionality:** A speech-enabled dialer where users can speak the number they wish to dial.(Yet to be develop)
- **File Upload for Model Input:** Users can upload `.wav` files to be processed by the Telugu speech recognition model, which returns recognized digits.
- **Real-time Interaction:** The system processes uploaded audio files in real-time and provides results back to the user.(Yet to be develop)

---

### **Tech Stack**

1. **Backend:**
   - **Spring Boot** for handling the web server, user requests, and API interactions.
   - **FastAPI** for serving the Python-based Telugu speech recognition model.
   - **WebSocket** support for real-time audio processing in the backend.
   - **Thymeleaf** for server-side rendering of HTML views.

2. **Frontend:**
   - **HTML/CSS/JavaScript** for building a responsive and interactive UI.
   - **Bootstrap** for UI styling and layout.
   - **FontAwesome** for adding icons, such as the microphone button.

3. **Speech Recognition Model:**
   - **Python** model using **Convolutional Neural Networks (CNN)** for recognizing Telugu digits (0-9) from `.wav` audio files.
   - The model is wrapped in a **FastAPI** application to expose it via REST API.

4. **Other Tools:**
   - **Docker** for containerizing the speech recognition model, allowing for seamless deployment on different platforms.

---

### **Project Structure**

The project is divided into multiple modules to ensure maintainability and scalability:

1. **Frontend:**
   - Contains all static resources like HTML, CSS, and JavaScript files.
   - **Thymeleaf templates** for rendering dynamic content based on user interaction.

2. **Backend:**
   - **Spring Boot application** to handle routing, API calls, and integrate with the FastAPI service.
   - **Controller classes** for managing the different operations like file upload and calculation.
   - **Service classes** for handling business logic and API interactions.

3. **Speech Recognition Model:**
   - Python-based model for recognizing Telugu digits.
   - Dockerized for easy deployment.

4. **Integration:**
   - FastAPI exposes the model as an API, which is consumed by the Spring Boot backend.
   - WebSocket is used to enable real-time communication for audio streaming.

---

### **Steps to Run the Application**

#### 1. **Setup the Backend (Spring Boot + FastAPI):**
   - Clone the repository and navigate to the Spring Boot project directory.
   - Build the Spring Boot project using Maven:
     ```bash
     mvn clean install
     ```
   - Set up the FastAPI service:
     - Install Python dependencies:
       ```bash
       pip install -r requirements.txt
       ```
     - Run the FastAPI service:
       ```bash
       uvicorn app:app --reload
       ```
   - Ensure that both services (Spring Boot and FastAPI) are running on their respective ports (e.g., Spring Boot on `localhost:8080` and FastAPI on `localhost:8000`).

#### 2. **Setup the Speech Recognition Model:**
   - The speech recognition model is containerized using Docker.
   - Build the Docker image:
     ```bash
     docker build -t telugu-speech-app:latest.
     ```
   - Run the Docker container:
     ```bash
     docker run -p 8000:8000 telugu-speech-app:latest.
     ```

#### 3. **Frontend Setup (Thymeleaf Templates):**
   - The frontend templates are powered by **Thymeleaf**.
   - The application is fully responsive and styled with **Bootstrap**.
   - Ensure all required static assets (CSS, JavaScript, and images) are correctly linked in the project.

---

### **Detailed Features and Functionality**

#### **1. Home Page (Calculator, Dialer, Note Maker)**
   - The home page provides a navigation bar to access different functionalities:
     - **Calculator**: Perform basic arithmetic operations (addition, subtraction, multiplication, and division).
     - **Dialer**: Dial a number by speaking the digits in Telugu.
     - **Note Maker**: Create notes by voice input.
   
   - **Mic Button**: A clickable microphone button is provided for users to record and upload `.wav` files containing Telugu speech.

#### **2. File Upload for Speech Recognition**
   - Users can upload `.wav` files containing Telugu speech.
   - Upon submission, the backend calls the FastAPI service, which processes the speech data and returns the recognized digits.

#### **3. Result Display Box**
   - The result is shown dynamically in a box below the file upload and operation buttons.
   - A cute **submit button** is provided next to the result to confirm the prediction.

#### **4. Validation (Correct or Incorrect Prediction)**
   - After submitting the result, users are prompted to validate the prediction with **"Correct"** and **"Incorrect"** buttons.
   - A **tick** icon is displayed for correct predictions, and a **cross** icon for incorrect ones.
   - Dynamic response is generated to thank the user for their input.

---

### **Key Components**

1. **Controller (Spring Boot):**
   - Manages the file upload and integration with the FastAPI backend.
   - Handles HTTP requests for different routes like `/calculator`, `/dialer`, and `/note-maker`.

2. **Service (Spring Boot):**
   - Contains business logic for interacting with the speech recognition model.
   - Sends audio data to the FastAPI endpoint and processes the response.

3. **API (FastAPI):**
   - Provides an endpoint (`/recognize`) for receiving `.wav` audio files and returning predictions based on the Telugu speech recognition model.

4. **UI (Thymeleaf):**
   - Provides the interface for uploading files, displaying results, and interacting with the backend.
   - Dynamic elements like the microphone button and result display box are handled using JavaScript and Thymeleaf.

---

### **Future Enhancements**

1. **Real-Time Audio Processing:**
   - Implementing WebSockets in the frontend and backend to process live audio streams instead of uploading files.
   - Enabling live speech-to-text conversion as users speak.

2. **Additional Languages:**
   - Expanding the speech recognition model to support other Indian languages or even a multilingual speech-to-text feature.

3. **Advanced UI/UX:**
   - Improving the user interface with modern frontend frameworks like **ReactJS** for better interactivity and performance.

4. **Cloud Deployment:**
   - Deploying the application on cloud platforms (AWS, GCP, or Azure) for scalability and performance.

---

### **Conclusion**

This project successfully integrates Telugu speech recognition with a user-friendly web application. Using **Spring Boot**, **FastAPI**, and **Thymeleaf**, the application provides a robust, interactive, and scalable solution for users to perform tasks like calculations, dialer operations, and note-making through voice input. The modular architecture allows for easy enhancements and improvements, particularly with real-time speech processing and additional language support in the future.telugu-speech-app:latest
Itelugu-speech-app:latest
I