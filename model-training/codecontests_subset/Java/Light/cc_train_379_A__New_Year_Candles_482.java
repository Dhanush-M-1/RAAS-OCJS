function f(a,b,c){
    if (a==0){ return 0; }
    else { return a + f(Math.floor((a+c)/b), b, (a+c)%b); }
}
a = readline().split(' ').map(Number);
print(f(a[0], a[1], 0));
