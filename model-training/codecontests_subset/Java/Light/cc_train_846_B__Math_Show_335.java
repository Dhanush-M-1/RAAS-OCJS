function cmp(a,b)
{
    return a-b;
}

var s=readline().split(' ')
var n=+s[0]
var k=+s[1]
var m=+s[2]
var t=readline().split(' ').map(function(v){return +v;})
t.sort(cmp)
var sum=0;
for (var i=0;i<k;i++){sum+=t[i];}
var res=0;
for (var i=0;i<=n;i++)
{
    var kol=i*(k+1);
    var ti=sum*i;
    if (ti>m){break;}
    for (var j=0;j<k;j++)
    {
        for (var x=i;x<n;x++)
        {
            if (ti+t[j]<=m){ti+=t[j];kol++;}
        }
    }
    if (kol>res){res=kol;}
}
print(res)