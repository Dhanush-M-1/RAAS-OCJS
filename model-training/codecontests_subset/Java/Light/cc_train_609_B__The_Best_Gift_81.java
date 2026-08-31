var summaryBooks = readline().split(' ')[0];
var array = readline().split(' ');
var categories = {};
var combinations = 0;

for (var i = 0; i < array.length; i++){
    if (categories[array[i]] === undefined)
        categories[array[i]] = 1;
    else
        categories[array[i]]++;
}

for (category in categories){
    summaryBooks -= categories[category];
    combinations += categories[category]*summaryBooks;
}

print(combinations);