#include <bits/stdc++.h>
using namespace std;

int main(){
  int N,M;
  cin>>N>>M;
  unordered_set<int> a;
  for(int i=0;i<M;i++){
    int j;
    cin>>j;
    a.insert(j);
  }
  int j=0,k=1;
  for(int i=0;i<N;i++){
    k+=j;
    j=k-j;
    if(a.count(i+1))
      k=0;
    if(k/1000000007)
      k%=1000000007;
    if(j/1000000007)
      j%=1000000007;
  }
  cout<<k<<endl;
}