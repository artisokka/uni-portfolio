const form = document.getElementById("form");
const contacts = document.getElementById("contacts");
const template = document.getElementById("contact-template");

form.addEventListener("submit", laheta);

function laheta(event) {
    event.preventDefault();
    
    const formData = new FormData(form);

    //var formData = new FormData(document.querySelector('form'));
    const nimi = formData.get('name');
    const sp = formData.get('email');
    const url = formData.get('homepage');

    //var newAnchor = document.createElement("a");

    let clonedRow = template.content.cloneNode(true); 

    let nimikentta = clonedRow.querySelector("h2");
    let sposti = clonedRow.querySelector(".email");
    let kotisivu = clonedRow.querySelector(".homepage");
    

    nimikentta = nimi;
    sposti = sp;
    kotisivu = url;

    clonedRow.querySelector(".homepage").querySelector("a").setAttribute('href', url);
    clonedRow.querySelector(".homepage").querySelector("a").textContent = url;

    clonedRow.querySelector(".email").textContent = sp;
    clonedRow.querySelector("h2").textContent = nimi;

    contacts.appendChild(clonedRow);

    form.reset();
  };

