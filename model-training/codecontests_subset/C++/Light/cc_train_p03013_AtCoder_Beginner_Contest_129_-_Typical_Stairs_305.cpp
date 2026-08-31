#include <bits/stdc++.h>
using namespace std;

int main() {
  int N,K,A=0;
  cin>>N>>K;
  vector<int> p(K+1);
  for(int i=0;i<K;i++){
    cin>>p.at(i);
  }
  vector<int> q(N+1);
  q.at(0)=1;
  q.at(1)=1;
  if(p.at(A)==1){
    A++;
    q.at(1)=0;
  }
  for(int i=2;i<=N;i++){
    if(p.at(A)==i){
      A++;
    }
    else{
      q.at(i)=(q.at(i-1)+q.at(i-2))%1000000007;
    }
  }
  cout<<q.at(N)<<endl;
}