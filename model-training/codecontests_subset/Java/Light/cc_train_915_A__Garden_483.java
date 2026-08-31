var arr = readline().split(' ');
var arrSpeedBuckets = readline().split(' ');

var amountBuckets = arr[0];
var lengthGarden = arr[1];

var result = Infinity;
for (var i = 0; i < arrSpeedBuckets.length; i++) {
    var hours = lengthGarden / arrSpeedBuckets[i];
    if ((hours ^ 0) === hours && 0 < hours && hours < result) {
        result = hours;
    }
}
print(result);


