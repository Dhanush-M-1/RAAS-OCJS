#include <bits/stdc++.h>
using namespace std;

int main() {
  long long N,M,x,y,z;
  z=0;
  cin >>N>>M;
  vector<long long>a(N),b(N),c(M),d(M),e(N);
  for(int i=0;i<N;i++){
    cin>>a[i]>>b[i];
  }
    for(int i=0;i<M;i++){
    cin>>c[i]>>d[i];
  }
    for(int i=0;i<N;i++){
z=1000000000;
        for(int j=0;j<M;j++){
   x=abs(a[i]-c[j])+abs(b[i]-d[j]);
          if(x<z){
            e[i]=j+1;
            z=x;
          }
        }
  }
  for(int i=0;i<N;i++){
    cout<<e[i]<<endl;
  }
}