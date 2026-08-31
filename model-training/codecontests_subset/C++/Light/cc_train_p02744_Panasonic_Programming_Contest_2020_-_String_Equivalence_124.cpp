#include <bits/stdc++.h>
using namespace std;
int n;
char s[15];
void dfs(int u,int now) {
    if (u==n) {
        puts(s);
        return;
    }
    for (int i=0;i<=now;++i) {
        s[u]=i+'a';
        dfs(u+1,max(now,i+1));
    }
}
int main()
{
    scanf("%d",&n);
    dfs(0,0);
    return 0;
}
