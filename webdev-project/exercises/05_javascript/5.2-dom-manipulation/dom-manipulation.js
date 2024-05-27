/**
 * Sort table rows alphabetically based on the values in a column
 *
 * @param {Number} col column index (zero based)
 * @param {HTMLTableElement} table the table to be sorted
 */

 cPrev = -1;

function sortTableByColumn(col, table) {
  // TODO: Implement this function as instructed

  rows = table.rows.length; 
  columns = table.rows[0].cells.length; 

  apu = [...Array(rows)].map(e => Array(columns)); // apuarray

  for (ro=0; ro<rows; ro++) {
      for (co=0; co<columns; co++) {
          apu[ro][co] = document.getElementById("sortable").rows[ro].cells[co].innerHTML;
      }
  }

  th = apu.shift();
  
  if (col !== cPrev) {
      apu.sort(
          function (a, b) {
              if (a[col] === b[col]) {
                  return 0;
              } else {
                  return (a[col] < b[col]) ? -1 : 1;
              }
          }
      );
  } else {
      apu.reverse();
  }
  
  cPrev = col;

  apu.unshift(th);

  for (ro=0; ro<rows; ro++) {
      for (co=0; co<columns; co++) {
          document.getElementById("sortable").rows[ro].cells[co].innerHTML = apu[ro][co];
      }
  }
}

/**
 * DO NOT EDIT THE CODE BELOW!
 *
 * The code below is there just to make it easier to test the code.
 *
 * If your function works correctly you should be able to sort the table
 * simply by clicking any column heading and the table should be immediately
 * sorted by values in that column.
 */

// find the table element
const table = document.getElementById('sortable');

// attach an event listener to each th element's click event
table.querySelectorAll('thead th').forEach((th, i) =>
  th.addEventListener('click', () => {
    sortTableByColumn(i, table);
  })
);