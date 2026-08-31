#include <bits/stdc++.h>
using namespace std;

int main(){
  int N,M;
  cin>>N>>M;
  using pii=pair<int,int>;
  vector<pii> A(N),B(M);
  for(pii &i:A)
    cin>>i.first>>i.second;
  for(pii &i:B)
    cin>>i.first>>i.second;
  for(pii i:A){
    int k=0,l=400000001;
    for(int j=0;j<M;j++){
      int p=abs(B[j].first-i.first)+abs(B[j].second-i.second);
      if(l>p){
        l=p;
        k=j;
      }
    }
    cout<<k+1<<endl;
  }
}