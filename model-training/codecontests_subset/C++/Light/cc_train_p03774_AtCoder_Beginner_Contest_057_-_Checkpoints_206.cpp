#include <bits/stdc++.h>
using namespace std;
 
int main() {
  int N,M;cin>>N>>M;
  vector<int> a(N);
  vector<int> b(N);
  vector<int> c(M);
  vector<int> d(M);
  for(int i=0; i<N; i++)cin>>a[i]>>b[i];
  for(int i=0; i<M; i++)cin>>c[i]>>d[i];
  for(int i=0; i<N; i++){
    vector<pair<int,int>> h(M);
    
    for(int j=0; j<M; j++){
      h[j]=make_pair(abs(a[i]-c[j])+abs(b[i]-d[j]),j);
    }
    sort(h.begin(),h.end());
    cout<<h[0].second+1<<endl;
    
  }
}