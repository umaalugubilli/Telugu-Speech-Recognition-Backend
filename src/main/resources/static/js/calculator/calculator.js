document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById('calculator-form');
    const resultBox = document.getElementById('result-box');
    const operationButtons = document.querySelectorAll('.btn-operation');
    const operationInput = document.getElementById('operation');
    let isSubmitting = false;

    operationButtons.forEach(button => {
        button.addEventListener('click', () => {
            const selectedOperation = button.getAttribute('data-operation');
            operationInput.value = selectedOperation;
        });
    });

    form.addEventListener('submit', (event) => {
        event.preventDefault();

        if (isSubmitting) return;

        isSubmitting = true;

        if (!operationInput.value) {
            resultBox.textContent = "Error: Please select an operation.";
            isSubmitting = false;
            return;
        }

        const formData = new FormData(form);

        fetch(form.action, {
            method: 'POST',
            body: formData
        })
        .then(response => {
            if (!response.ok) throw new Error("Network response was not ok");
            return response.json();
        })
        .then(data => {
            resultBox.textContent = "Result: " + data.result;
        })
        .catch(error => {
            resultBox.textContent = "Error: " + error.message;
        })
        .finally(() => {
            isSubmitting = false;
            operationInput.value = "";
        });
    });
});
