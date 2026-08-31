#include<bits/stdc++.h>
using namespace std;
char str[15];
void dfs(int l,int t,int n)
{
    if(l==n)
    {
        printf("%s\n",str);
        return;
    }
    for(int i=0;i<=t+1;i++)
    {
        str[l]='a'+i;
        dfs(l+1,max(t,i),n);
    }
}
int main()
{
    int n;
    scanf("%d",&n);
    dfs(0,-1,n);
    return 0;
}
