#include<bits/stdc++.h>
using namespace std;
#define ll long long

int main(){
  int n,m,a,i;
  cin >> n >> m;
  vector<int> broken(n+1,1);
  for(i=0;i<m;i++){
    cin >> a;
    broken.at(a)=0;
  }
  
  vector<ll> s(n+1,0);
  ll p=1000000007;
  s.at(0)=1;
  s.at(1)=1*broken.at(1);
  for(i=2;i<=n;i++){
    s.at(i)=(s.at(i-1)+s.at(i-2))%p*broken.at(i);
  }
  
  cout << s.at(n) << endl;
}