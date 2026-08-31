#include <bits/stdc++.h>
using namespace std;
int main(){
  int N,M,x;
  cin>>N>>M;
  int a[N],b[N],c[M],d[M],Z[N];
  for(int i=0;i<N;i++) cin>>a[i]>>b[i];
  for(int i=0;i<M;i++) cin>>c[i]>>d[i];
  for(int i=0;i<N;i++){
    x=abs(a[i]-c[M-1])+abs(b[i]-d[M-1]);
    Z[i]=M;
    for(int j=M-1;j>=0;j--){
      int L=abs(a[i]-c[j])+abs(b[i]-d[j]);
      if(x>=L){
        x=L;
        Z[i]=j+1;
      }
    }
  }
  for(int i=0;i<N;i++) cout<<Z[i]<<endl;
}