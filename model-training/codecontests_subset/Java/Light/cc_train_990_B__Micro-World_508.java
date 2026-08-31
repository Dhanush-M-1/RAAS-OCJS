var numbers = readline().split(" ").map(function(x) { return parseInt(x); });
var n = numbers[0], k = numbers[1];
var cells = readline().split(" ").map(function(x) { return parseInt(x); });

cells.sort((a,b) => a-b);

var eat = 0;

var i = 0;
var j = 0;

while (i < cells.length && j < cells.length) {
    if (cells[i]<cells[j] && cells[j]<=cells[i]+k) {
        eat++;
        i++;
    } else {
        if(cells[j]>cells[i]+k) {
            i++
        } else {
            j++
        }
    }
}

print(cells.length - eat);

