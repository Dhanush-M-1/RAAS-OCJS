#include<bits/stdc++.h>
#define int long long
using namespace std;
constexpr int mod=1e9+7;
int n;
void dfs(string s,int t){
    if(s.size()==n){
        cout<<s<<endl;
        return;
    }
    for(int i=0;i<=t;i++)
        dfs(s+char('a'+i),t+(i==t));
}
signed main(){
    cin>>n;
    dfs(string(),0);
}
