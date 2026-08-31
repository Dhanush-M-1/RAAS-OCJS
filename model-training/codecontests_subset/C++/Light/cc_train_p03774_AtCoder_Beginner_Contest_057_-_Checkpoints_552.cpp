#include <bits/stdc++.h>
using namespace std;
int main(){
  int N,M;
  cin>>N>>M;
  vector<int> A(N),B(N);
  for(int i=0;i<N;i++){
    cin>>A.at(i)>>B.at(i);
  }
  vector<int> C(M),D(M);
  for(int i=0;i<M;i++){
    cin>>C.at(i)>>D.at(i);
  }
  for(int i=0;i<N;i++){
    int small=1000000000;
    int ans;
    for(int j=0;j<M;j++){
      int dis=abs(A.at(i)-C.at(j))+abs(B.at(i)-D.at(j));
      if(dis<small){
        small=dis;
        ans=j;
      }
    }
    cout<<ans+1<<endl;
  }
}