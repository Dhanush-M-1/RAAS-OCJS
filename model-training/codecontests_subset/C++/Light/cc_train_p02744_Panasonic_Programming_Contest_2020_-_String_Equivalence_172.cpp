#include<bits/stdc++.h>
using namespace std;

int n;

void dfs(string s, int mx){
    if(s.size()==n){
        cout<<s<<'\n';
        return;
    }
    for(int i=0;i<=mx+1;++i){
        dfs(s+char('a'+i), max(mx, i));
    }
}

int main(){
    cin>>n;
    dfs("a", 0);
}