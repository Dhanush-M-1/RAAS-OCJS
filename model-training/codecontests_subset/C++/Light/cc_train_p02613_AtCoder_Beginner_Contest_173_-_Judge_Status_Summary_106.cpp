#include <bits/stdc++.h>
using namespace std;
#define rep(i,n) for (int i = 0; i < (n); i++) 
#define all(v) begin(v),end(v)
using ll = long long;

int main() {
  int n;cin>>n;
  map<string,int> m;
  rep(i,n){
    string s;cin>>s;
    m[s]++;
  }
  for(string s:{"AC","WA","TLE","RE"}){
    cout<<s<<" x "<<m[s]<<endl;
  }
}