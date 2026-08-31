#include<bits/stdc++.h>
using namespace std;
#define rep(i,n) for(int i=0;i<n;i++)
typedef vector<long> vec;

int main(){
  long n,m;cin>>n>>m;
  long st[n+5];
  vec a(m);
  rep(i,m)cin>>a[i];
  st[0]=1;

  for(int i=0;i<n;i++)st[i+1]=1;
  
  for(auto x:a)st[x]=0;
  
  for(int i=0;i<n;i++){
    if(st[i+2]==0)continue;
    st[i+2]=(st[i+1]+st[i])%1000000007;
  }

  
  cout<<st[n]<<endl;

}