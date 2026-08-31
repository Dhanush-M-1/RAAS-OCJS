if (!readline) {
    var _i = 0;
    var readline = function() {
        _i ++;

        switch (_i) {
            case 1: return '6';
            case 2: return '1 4 3 3 5 7';
            case 3: return '3 7 5 4 3';
            case 4: return '4 3 7 5';
        }
    }

    var write = console.log;
}

var n = +readline();
var a = new Map();
var b = new Map();

readline().split(' ').forEach(function(currentValue) {
    var index = +currentValue;
    a.set(index, (a.get(index) || 0) + 1);
});

readline().split(' ').forEach(function(currentValue) {
    var index = +currentValue;
    b.set(index, (b.get(index) || 0) + 1);
});

var ans = [];

a.forEach(function(currentValue, index) {
    if (currentValue !== b.get(index)) {
        ans.push(index);

        if (currentValue == 1) {
            a.delete(index);
        } else {
            a.set(index, currentValue - 1);
        }
    }
});

b = new Map();

readline().split(' ').forEach(function(currentValue) {
    var index = +currentValue;
    b.set(index, (b.get(index) || 0) + 1);
});

a.forEach(function(currentValue, index) {
    if (currentValue !== b.get(index)) {
        ans.push(index);

        if (currentValue == 1) {
            a.delete(index);
        } else {
            a.set(index, currentValue - 1);
        }
    }
});

write(ans.join('\n'));
