(function () {
    var read = {
        number: function () {
            return +readline();
        },
        arr: function (divider) {
            return readline().split(divider ? divider : '');
        },
        arrNumber: function (divider) {
            return readline()
                .split(divider ? divider : '')
                .map(item => +item);
        }
    }


    var n = read.number();
    var s = read.arr();

    for(var i = 1; i < n; i ++) {
       if(s[i - 1] > s[i]) {
           print('YES');
           print((i) + ' ' + (i + 1));
           return;
       }
    }

    print('NO');



}());