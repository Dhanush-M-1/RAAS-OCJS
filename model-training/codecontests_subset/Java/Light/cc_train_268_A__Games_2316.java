'use strict';
const n = parseInt(readline());
let array = [];
let counter = 0;

for (let i = 0; i < n; i++) {
  array.push(readline().split(' ').map(value => parseInt(value)));
}

for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) {
    if (j !== i && array[i][0] === array[j][1]) {
      counter++;
    }
  }
}

write(counter);