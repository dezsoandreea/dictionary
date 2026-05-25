document.getElementById('dictionaryForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const wordInputValue = document.getElementById('word').value;
    const resultCard = document.getElementById('resultCard');
    const resultStatus = document.getElementById('resultStatus');

    fetch(`/api/v1/dictionary?word=${encodeURIComponent(wordInputValue)}`)
        .then(response => response.text())
        .then(data => {
            resultCard.style.display = "block";
            resultStatus.innerText = data;

            if (data.includes("EXISTS") && !data.includes("NOT")) {
                resultStatus.style.color = "#2e7d32";
                resultCard.style.border = "2px solid #2e7d32";
            } else {
                resultStatus.style.color = "#c62828";
                resultCard.style.border = "2px solid #c62828";
            }
        })
        .catch(error => {
            console.error('Error:', error);
            resultCard.style.display = "block";
            resultStatus.innerText = "Error connecting to the server.";
            resultStatus.style.color = "red";
        });
});