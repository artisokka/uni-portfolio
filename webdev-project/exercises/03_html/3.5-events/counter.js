const totalCount = document.getElementById("counter");
var count = 0;
totalCount.innerHTML = count;

const plussaa = () => {
    const parsed = Number.parseInt(count);
    if (parsed > 4) {
        count = -5;
    }
    else {
        count++;
    }
    totalCount.innerHTML = count;
  };

const miinusta = () => {
    const parsed = Number.parseInt(count);
    if (parsed < -4) {
        count = 5;
    }
    else {
        count--;
    }
    totalCount.innerHTML = count;
  };

const resetoi = () => {
    count = 0;
    totalCount.innerHTML = count;
}

const incrementCount = document.getElementById("increment");
const decrementCount = document.getElementById("decrement");
const resetCount = document.getElementById("reset");

incrementCount.addEventListener("click", plussaa);
decrementCount.addEventListener("click", miinusta);
resetCount.addEventListener("click", resetoi);