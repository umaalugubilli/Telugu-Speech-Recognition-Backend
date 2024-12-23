document.addEventListener("DOMContentLoaded", function() {
	const form = document.getElementById('file-upload-form');
	const resultBox = document.getElementById('result-box');
	const feedbackBox = document.getElementById('feedback-box');
	const micButton = document.getElementById('mic-button');
	const correctBtn = document.getElementById('correct-btn');
	const incorrectBtn = document.getElementById('incorrect-btn');

	let uploadedFile = null;

	// Mic button functionality
	micButton.addEventListener('click', function() {
		alert("Microphone feature is not implemented yet!");
	});

	// Form submission handling
	form.addEventListener('submit', function(event) {
		event.preventDefault();

		const formData = new FormData(form);

		fetch(form.action, {
			method: 'POST',
			body: formData
		})
			.then(response => response.json())
			.then(data => {
				resultBox.textContent = "Result: " + data.result;
			})
			.catch(error => {
				resultBox.textContent = "Error: " + error.message;
			});
	});

	// Correct/Incorrect button functionality
	correctBtn.addEventListener('click', function() {
		feedbackBox.textContent = "Thank you for confirming the prediction as Correct!";
		feedbackBox.style.color = "green";
	});

	incorrectBtn.addEventListener("click", () => {
		const userFeedback = prompt("Please provide the correct prediction:");
		if (userFeedback) {
			thankYouMessage.innerHTML = `<p class="text-success">Thank you for your feedback: ${userFeedback}</p>`;
			thankYouMessage.style.display = "block";
			setTimeout(() => thankYouMessage.style.display = "none", 3000);
		}
	});
});