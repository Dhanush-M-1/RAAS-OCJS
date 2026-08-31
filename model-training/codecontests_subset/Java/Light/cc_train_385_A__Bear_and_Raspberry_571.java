var line1 = readline().split(' ');
var n =  parseInt(line1[0]);
var rent = parseInt(line1[1]);
var rates = readline().split(' ');
var profit = 0;
for(var i = 0; i<n-1;i++){
    if(parseInt(rates[i])-parseInt(rates[i+1]) > rent && parseInt(rates[i])-parseInt(rates[i+1]) - rent > profit){
        profit = parseInt(rates[i])-parseInt(rates[i+1]) - rent;
    }
}

print(profit);