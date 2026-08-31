var n = readline();
var str1 = readline().split(" ").reduce((x,y)=>(Number(x)+Number(y)));
var str2 = readline().split(" ").reduce((x,y)=>(Number(x)+Number(y)));
var str3 = readline().split(" ").reduce((x,y)=>(Number(x)+Number(y)));

print(str1-str2);
print(str2-str3);