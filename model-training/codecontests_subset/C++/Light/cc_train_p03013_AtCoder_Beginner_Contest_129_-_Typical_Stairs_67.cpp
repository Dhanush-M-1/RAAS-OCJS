#include<bits/stdc++.h>
using namespace std;
using ll=long long;

const int MOD=1000000007;

int main(){
  int i,j,cnt=0;
  int n,m;
  cin>>n>>m;
  int a[m];
  for(i=0;i<m;i++)cin>>a[i];
  ll p[n+1];
  for(i=0;i<=n;i++)p[i]=1;
  for(i=0;i<m;i++)p[a[i]]=0;
  for(i=1;i<=n;i++){
    if(p[i]!=0){
      if(i!=1)p[i]=(p[i-1]+p[i-2])%MOD;
      else p[i]=p[i-1];
    }
  }
  cout<<p[n];
}