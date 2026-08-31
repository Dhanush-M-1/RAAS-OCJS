#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
int n;string s;
void dfs(int now,int mx){
    if(now==n){cout<<s<<endl;return;}
    for(int i='a';i<=mx+1;i++) {s[now]=i;dfs(now+1,max(i,mx));}
}
int main() {
    cin>>n;for(int i=0;i<n;i++) s.push_back('a'); 
    dfs(1,'a');
    return 0;
}