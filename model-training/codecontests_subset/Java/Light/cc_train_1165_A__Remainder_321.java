var input = readline().split(' ').map(Number);
var n, x, y;
n = input.shift();
x = input.shift();
y = input.shift();
var str = readline();
var res = 0;
for(var i = n - 1; i >= n - x; i--){
    if(str[i] == '1' && Math.abs(n - i - 1) != y){
        res++;
    } else if(str[i] == '0' && Math.abs(n - 1 - i) == y)
        res++;
}
print(res);