#include <bits/stdc++.h>
using namespace std;

int main(){
  int N,M,i,ans=0,e,a[51],b[51],c[51],d[51];
  cin>>N>>M;
  for(i=0;i<N;i++){
    cin>>a[i]>>b[i];
  }
  for(i=0;i<M;i++){
    cin>>c[i]>>d[i];
  }
  for(int j=0;j<N;j++){
    e=400000001;
      ans=0;
  for(i=0;i<M;i++){
   if(e>abs(a[j]-c[i])+abs(b[j]-d[i])){
     ans=i+1;
     e=abs(a[j]-c[i])+abs(b[j]-d[i]);
   }
  }
    cout<<ans<<endl;
  }
}