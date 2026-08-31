var input = readline().split('+');
input.sort(compairNumeric);
input = input.join('+');
print(input);
function compairNumeric(a,b){
    if(a>b)return 1;
    if(a<b)return -1;
}