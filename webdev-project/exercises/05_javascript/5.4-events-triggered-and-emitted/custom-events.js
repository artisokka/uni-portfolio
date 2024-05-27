// nopan value
// event.detail.value
const totalCount = document.getElementById("totals");
const yksi = document.getElementById("ones");
const kaksi = document.getElementById("twos");
const kolme = document.getElementById("threes");
const nelja = document.getElementById("fours");
const viisi = document.getElementById("fives");
const kuusi = document.getElementById("sixes");

const dice = document.getElementById("roll-button");


var count = 0;
var kaikki = 0;
var ykkoset = 0;
var kakkoset = 0;
var kolmoset = 0;
var neloset = 0;
var vitoset = 0;
var kutoset = 0;

let rollBtn = document.getElementById('roll-button').addEventListener('click', event => {
    rollDice();
});

document.addEventListener('rollDice', function(e) {
    console.log(e.detail.value);
    const luku = e.detail.value;
    var template = "";

    kaikki++;
    
    if (luku === 1) {
        ykkoset++;
        //var yksi = 
        yksi.querySelector('p').childNodes[0].nodeValue = ykkoset;
        template = document.getElementById("template1");
        
    }
    if (luku === 2) {
        kakkoset++;
        //var yksi = 
        kaksi.querySelector('p').childNodes[0].nodeValue = kakkoset;
        template = document.getElementById("template2");
    }
    if (luku === 3) {
        kolmoset++;
        //var yksi = 
        kolme.querySelector('p').childNodes[0].nodeValue = kolmoset;
        template = document.getElementById("template3");
    }
    if (luku === 4) {
        neloset++;
        //var yksi = 
        nelja.querySelector('p').childNodes[0].nodeValue = neloset;
        template = document.getElementById("template4");
    }
    if (luku === 5) {
        vitoset++;
        //var yksi = 
        viisi.querySelector('p').childNodes[0].nodeValue = vitoset;
        template = document.getElementById("template5");
    }
    if (luku === 6) {
        kutoset++;
        //var yksi = 
        kuusi.querySelector('p').childNodes[0].nodeValue = kutoset;
        template = document.getElementById("template6");
    }
    
    let clonedRow = template.content.cloneNode(true); 
    dice.innerHTML = "";
    dice.appendChild(clonedRow);

    totalCount.querySelector('span').childNodes[0].nodeValue = kaikki;
});


 /* document.getElementById('roll-button').onclick = function() {
    var event = new Event('rollDice');
    // Dispatch the event.
    heitaNoppaa.dispatchEvent(event);
  };*/

//heitaNoppaa.dispatchEvent(eventti);




