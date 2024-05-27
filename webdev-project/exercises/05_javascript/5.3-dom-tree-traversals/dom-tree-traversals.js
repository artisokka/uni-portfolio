
    //if(document.querySelectorAll('li').children.length > 0) { // jos ul on children tulosta count
        
        /*var liElements = document.querySelector('ul').querySelector('ul').getElementsByTagName("li"); 
        var ulcount = liElements.length;
        //var ulist = document.querySelector("ul");  
        //ulist.append("(" + ulcount + ")");  


        var newElement = document.createElement('text');
        newElement.innerHTML = '(' + ulcount + ')';
        document.querySelector('li').appendChild(newElement);

        console.log('javascript -> ', ulcount);*/
   // }



/*   var firstUL = document.getElementsByTagName('UL')[0]; //assuming the whole list is the first UL in the document
var animalsLI = firstUL.getElementsByTagName('LI')[0];
var animalsLIUL = animalsLI.getElementsByTagName('UL')[0];
var animalsLIs = animalsLI.getElementsByTagName('LI');

var ulcount = animalsLIs.length;

var newElement = document.createElement('text');
        newElement.innerHTML = '(' + ulcount + ')';
        document.querySelector('li').appendChild(newElement);

*/

/*var lis = document.querySelector('ul').querySelector('ul').getElementsByTagName('li');
var animals = document.querySelector('ul');
var ul = document.querySelector('ul').firstChild;


for(var i = 0; i < lis.length; i++)
    if (lis[i].innerHTML == "Animals") {
        var ulcount = lis.length;
        lis[i].innerHTML += "(" + ulcount + ")";
    }

*/

/*var lis = document.querySelector('ul').querySelector('ul').getElementsByTagName('li');

console.log(lis.parentNode());

*/
/*for(var i = 0; i < lis.length; i++)
    if (lis.lastChild) {
        var ulcount = lis.length;
        lis[i].innerHTML += "(" + ulcount + ")";
    }*/

    /*var items = document.getElementsByTagName("ul");
    var ulcount = 0;
    
    for (i = 0; i < items.length; i++) {
        
        ulcount = items[i].querySelectorAll("ul li").length;
        //items.innerHTML += "(" + ulcount + ")";
        
        console.log(items[i]);
        console.log(document.querySelectorAll("ul li").length);
    }*/



    // TÄMÄ TOIMII JOKSEENKIN, LASKEE OIKEIN MUTTEI MERKITSE OIKEAAN PAIKKAAN
    const list = document.querySelectorAll("ul li");
    
	list.forEach(list => {
        
        //console.log('list elem: ', list);
        //count += list.querySelector('ul').childNodes.length;
        //console.log(list.querySelector('li').childNodes[0]);
        
        var count = list.querySelectorAll('li').length;
        if (count > 0) {
            list.childNodes[0].nodeValue += "(" + count + ")";
        }
        
	});

    /*var firstUl = document.querySelector('ul');


    for(var i = 0; i < firstUl.children.length; i++) {
        var count = firstUl.querySelectorAll('li').length;
        var element = firstUl.children[i];
        if(element.tagName === 'LI')
            firstUl.childNodes[0].nodeValue += "(" + count + ")";
      }*/