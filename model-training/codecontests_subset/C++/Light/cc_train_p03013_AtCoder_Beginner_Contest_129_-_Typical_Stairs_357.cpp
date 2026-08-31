#include <bits/stdc++.h>
using namespace std;
int mod=1000000007;
int main(){
  int n,m;
  cin >> n >> m;
  vector<int> a(m);
  vector<int> d(n+1,-1);
  d[0]=1;
  d[1]=1;
  for(int i=0;i<m;i++){
    cin >> a[i];
    d[a[i]]=0;
  }
  for(int i=2;i<=n;i++){
    if(d[i]!=0){
      d[i]=(d[i-1]+d[i-2])%mod;
    }
  }
  cout << d[n] << endl;
}