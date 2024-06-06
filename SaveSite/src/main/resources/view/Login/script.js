const formulario = document.querySelector("form");
const loginInput = document.getElementById('loginInput');
const passwordInput = document.getElementById('passwordInput');

function login(){
    const Ilogin = loginInput.value;
    const Ipassword = passwordInput.value;
  
    fetch('http://localhost:8080/SaveSite/user/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ login: Ilogin, password: Ipassword })
    })
    .then(function (res) { 
        if (res.ok) {
            window.location.href = "../Profile/profile.html";
        } else {
            return res.text().then(function(errorMessage) {
                alert(errorMessage);
            });
        }
    })
    .catch(function (error) { 
        console.log(error); 
        alert("Ocorreu um erro durante o processo de login. Por favor, tente novamente mais tarde.");
    });
}

formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    login();
});

//label 
const labels = document.querySelectorAll('.form-control label')

labels.forEach(label => {
    label.innerHTML = label.innerText
        .split('')
        .map((letter, idx) => `<span style="transition-delay:${idx * 50}ms">${letter}</span>`)
        .join('')
})
