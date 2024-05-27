const contacts = document.getElementById("contacts");
const template = document.getElementById("user-card-template");

document.addEventListener('userDataReady', (e) => {
    const obj = JSON.parse(e.detail.jsonText);
    console.log(obj);

    for (var i = 0; i < obj.length; ++i) {

        var u = obj[i];
        let clonedRow = template.content.cloneNode(true);

        clonedRow.querySelector("img").setAttribute('src', u.avatar);

        const altnimi = u.firstName + " " + u.lastName;
        clonedRow.querySelector("img").setAttribute('alt', altnimi);

        clonedRow.querySelector(".homepage").querySelector("a").setAttribute('href', u.homepage);
        clonedRow.querySelector(".homepage").querySelector("a").textContent = u.homepage;

        clonedRow.querySelector(".phone").querySelector('span').textContent = u.phoneNumber;

        

        clonedRow.querySelector(".address").querySelector('p').textContent = u.address.streetAddress;

        clonedRow.querySelector(".address").querySelector('p').nextSibling.nextSibling.textContent = u.address.zipCode + " " + u.address.city;

        clonedRow.querySelector(".address").querySelector('p').nextSibling.nextSibling.nextSibling.nextSibling.textContent = u.address.country;

        clonedRow.querySelector(".email").textContent = u.email;
        clonedRow.querySelector('h1').innerHTML = u.firstName + " " + u.lastName;

        contacts.appendChild(clonedRow);

    }

});

fetchUserData();