class Cidadao{
    sexo;
    idade;
    cpf;
    nome;
}

class Voto{
    
    voto;    
    coordenadaGeografica;
    justificativa;
    data;
    cidadao = new Cidadao();
    

}


var voto = new Voto;

function registraVoto(candidato){
    console.log(candidato);
    localStorage.setItem("candidato",candidato);
    voto.voto = candidato;
    

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
function registraJustificativa(){
    voto.justificativa = "porque eu quis";
}

function registraCoordenadaGeografica(){
    voto.coordenadaGeografica=Math.floor(Math.random() * 100) + "," + Math.floor(Math.random() * 100); ;
}
function registraData(){
    voto.data = new Date();
}
function registraCidadao(){
    cidadao = new Cidadao();
    cidadao.cpf = document.querySelector("#cpf").value;
    cidadao.idade = document.querySelector("#idade").value;
    cidadao.nome = document.querySelector("#nome").value;
    cidadao.sexo = document.querySelector('input[name="opcao"]:checked').value;
    voto.cidadao = cidadao;
}
function finalizaVoto(){
 registraCidadao();

registraData();
registraCoordenadaGeografica();
registraJustificativa();


    voto.voto = localStorage.getItem("candidato");

     var myInit = { method: 'POST',
                      headers: new Headers({'content-type': 'application/json','Access-Control-Allow-Origin':'*'}),
                      mode: 'cors',
                      cache: 'default',
                      body:  JSON.stringify(voto)};
    let url = 'http://127.0.0.1:8080/voto';

    fetch(url, myInit).then(function(response) {
        if(response.status == 200){
            window.location.href = 'compartilhar.html';
        }
        else{
            alert("Voto não computado!\n Motivo: " + response.text());
        }
        console.log(response);
      });

}


// window.onload = function (event){


// };





