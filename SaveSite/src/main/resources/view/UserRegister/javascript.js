const formulario = document.querySelector("form");
const Ilogin = document.querySelector(".login");
const Ipassword = document.querySelector(".password");;

function cadastra() {

    fetch("http://localhost:8080/SaveSite/user/register", {

        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            login: Ilogin.value,
            password: Ipassword.value,
        })

    })
    .then(function (res) { 
        alert("Usuario cadastrado")
    })
    .catch(function (error) { 
        console.log(error); 
        alert("Ocorreu um erro durante o processo de cadastro. Por favor, tente novamente mais tarde.");
    });
};

function limpar(){
    Ilogin.value="";
    Ipassword.value="";
}

formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    cadastra();
    limpar();
});
