#include <bits/stdc++.h>
using namespace std;

int main() {
  int N,M;
  cin>>N>>M;
  vector<int> p(M);
  vector<int> q(M);
  vector<int> r(N);
  vector<int> s(N);
  for(int i=0;i<N;i++){
    cin>>r[i]>>s[i];
  }
  for(int i=0;i<M;i++){
    cin>>p[i]>>q[i];
  }
  for(int j=0;j<N;j++){
    int a=r[j],b=s[j];
    int Z=0,A=2001924167;
    for(int i=0;i<M;i++){
      if(A>abs(a-p[i])+abs(b-q[i])){
        Z=i+1;
        A=abs(a-p[i])+abs(b-q[i]);
      }
    }
    cout<<Z<<endl;
  }
}

