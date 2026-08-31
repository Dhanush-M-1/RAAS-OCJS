#include <bits/stdc++.h>

using namespace std;

int main(){
  int n,m;
  cin >> n >> m;
  map<int,int> mp;
  vector<long long int>count(n+1,0);
  for(int i=0;i<m;i++){
    int a;
    cin >> a;
    mp[a]=1;
   }
  count[0]=1;
  count[1]=mp[1]==0;
  for(int i=2;i<=n;i++){
      if(mp[i]==1)count[i]=0;
      else count[i]=(count[i-1]+count[i-2])%1000000007;
  }
  cout << count[n];
    
}