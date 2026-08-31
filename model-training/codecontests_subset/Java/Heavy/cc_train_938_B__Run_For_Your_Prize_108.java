var numPriz = readline();
var prizeLoc = readline().split(' ');


function foo(numPriz, prizeLoc) {

    var leftSeconds = 0;
    var rightSeconds = 0;


    var leftPrizeLocObj = {};
    var rightPrizeLocObj = {};



    prizeLoc.forEach(val => {
        if (val <= 500000) {
            leftPrizeLocObj[val + ''] = val;
        }
        else {
            rightPrizeLocObj[val + ''] = val;
        }
    });

    var leftKeys = Object.keys(leftPrizeLocObj);
    leftSeconds = leftPrizeLocObj[leftKeys[leftKeys.length - 1]] - 1 || 0;

    var rightKeys = Object.keys(rightPrizeLocObj);
    rightSeconds = 999999 - rightPrizeLocObj[rightKeys[0]] + 1 || 0;


    //console.log(Math.max(leftSeconds, rightSeconds));
    print(Math.max(leftSeconds, rightSeconds))

}

// foo(3, ['2', '3', '9']);
// foo(2, ['2', '999995'])
foo(numPriz, prizeLoc)