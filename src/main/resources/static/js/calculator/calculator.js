document.addEventListener("DOMContentLoaded", function() {
	const form = document.getElementById('calculator-form');
	const resultBox = document.getElementById('result-box');
	const micButton = document.getElementById('mic-button');
	const operationButtons = document.querySelectorAll('.btn-operation');
	const operationInput = document.getElementById('operation'); // Hidden input field
	let isSubmitting = false; // Flag to prevent multiple submissions


	// Mic button functionality
		micButton.addEventListener('click', function() {
			alert("Microphone feature is not implemented yet!");
		});
		
	// Update operation value when a button is clicked
	operationButtons.forEach(button => {
		button.addEventListener('click', () => {
			const selectedOperation = button.getAttribute('data-operation');
			operationInput.value = selectedOperation; // Update hidden input
			console.log("Operation selected:", selectedOperation);
		});
	});
	

	form.addEventListener('submit', (event) => {
		event.preventDefault(); // Prevent default form submission

		if (isSubmitting) {
			console.log("Already submitting, ignoring.");
			return; // Prevent multiple submissions
		}

		isSubmitting = true; // Set the flag

		// Validate that the operation is selected
		if (!operationInput.value) {
			resultBox.textContent = "Error: Please select an operation.";
			console.log("No operation selected.");
			isSubmitting = false; // Reset the flag in case of error
			return;
		}

		const formData = new FormData(form);

		// Log the form data to debug
		for (let pair of formData.entries()) {
			console.log(pair[0] + ', ' + pair[1]);
		}

		// Send the form data via fetch
		fetch(form.action, {
			method: 'POST',
			body: formData
		})
			.then(response => {
				if (!response.ok) {
					return response.json().then(err => { throw new Error(err.message); });
				}
				return response.json();
			})
			.then(data => {
				resultBox.textContent = "Result: " + data.result;
			})
			.catch(error => {
				resultBox.textContent = "Error: " + error.message;
			})
			.finally(() => {
				isSubmitting = false; // Reset the flag
				operationInput.value = ""; // Clear the operation after submission
			});
	});
});