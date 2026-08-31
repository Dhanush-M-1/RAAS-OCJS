#include <bits/stdc++.h>
using namespace std;
using ll=long long;
ll N;
void dfs(string s, char mx){
  if(s.size()==N)
    cout<<s<<endl;
  else{
    for(char c='a'; c<=mx; c++)
      dfs(s+c, c==mx ? mx+1: mx);
  }
}
int main(){
  cin>>N;
  dfs("",'a');
}
