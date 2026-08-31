#include<iostream>
#include<vector>
#include<set>
using namespace std;
int main(){
  int n,m; cin>>n>>m;
  vector<long long> v(n+1);
  set<int> a;
  for(int i=0;i<m;i++) { int ai;cin>>ai;a.insert(ai); }
  v[0]=1;
  v[1]=a.count(1)?0:1;
  for(int i=2;i<=n;i++){
    v[i]=a.count(i)?0:(v[i-1]+v[i-2])%1000000007;
  }
  cout<<v[n]<<endl;
  return 0;
}
