//'The navigation list element (ul inside nav) is missing the following classes "list"',
//'The last link in the navigation list should have the text "Localhost" but "Unordered" was found instead.',
//'The last link in the navigation list should have the URL "http://localhost:3000/" but "file:///submission/user/original-index.html#unordered" was found instead'


//4 Remove the class navi from the todo list (unordered list, ul, with the id em{todo}). Do not remove any other classes from the list!

var luokka = document.getElementById("todo");
luokka.classList.remove("navi");


//1 Add a class list to the navigation link list (unordered list, ul) inside nav element.


var elements = document.getElementsByClassName("navi");
elements[0].className += " list";

//var lisaaLuokka = document.getElement("navi");
//lisaaLuokka.classList.add("list");


//2 Create a new link (anchor tag, a) as the last item inside the navigation link list. The link must have http://localhost:3000/ as its target address (href attribute) and the text Localhost inside. Remember to put the anchor tag inside a list item (li) tag.

var ulist = document.querySelector("ul");
var newListItem = document.createElement("li");
var newAnchor = document.createElement("a");
newAnchor.textContent = "Localhost";
newAnchor.setAttribute('href', "http://localhost:3000/");
newListItem.appendChild(newAnchor);
ulist.appendChild(newListItem);


// 3 Insert a new list item (li tag) with the text Item 0 as the first element of the ordered list (ol) with the id ordered. Note that the text has the number zero as its last character.
var li = document.createElement("li");
li.innerHTML = "Item 0";
document.getElementById("ordered").prepend(li);






//5 Delete the second list item from the todo list. The the text inside the item is Item 2.

var ul = document.getElementById('todo');
var liToKill = ul.childNodes[3];
liToKill.parentNode.removeChild( liToKill );