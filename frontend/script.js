class Voto{
    
    candidato;
    sexo;
    idade;
    cpf;
    nome

}


var voto = new Voto;

function registraVoto(candidato){
    console.log(candidato);
    localStorage.setItem("candidato",candidato);
    voto.candidato = candidato;
    

}
function registraNome(){
    console.log(document.querySelector("#nome").value);
    voto.nome = document.querySelector("#nome").value;

}

function registraCPF(){
    console.log(document.querySelector("#cpf").value);
    voto.cpf = document.querySelector("#cpf").value

}

function registraIdade(){
    console.log(document.querySelector("#idade").value);
    voto.idade = document.querySelector("#idade").value;
    

}

function registraSexo(){
    console.log(document.querySelector('input[name="opcao"]:checked').value);
    voto.sexo = document.querySelector('input[name="opcao"]:checked').value;

}

function finalizaVoto(){
    registraSexo();
    registraIdade();
    registraNome();
    registraCPF();

    voto.candidato = localStorage.getItem("candidato");
       console.log(voto);
    fetch()
}


// window.onload = function (event){


// };





