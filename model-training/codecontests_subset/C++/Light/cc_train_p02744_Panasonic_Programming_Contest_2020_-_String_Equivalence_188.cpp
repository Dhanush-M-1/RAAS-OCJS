#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int n;

void dfs(string s,char mx)
{
if(s.size()==n)
{
    cout<<s<<endl;
    return ;}
else 
{
for (char c='a';c<=mx+1;c++)
{string t;
t =s;
t+=c;
dfs(t,max(mx,c));

}

}


}

int main()
{
cin>>n;
dfs("",'a'-1);
return 0;

}