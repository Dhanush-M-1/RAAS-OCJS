#include <bits/stdc++.h>
using namespace std;

int main(){
  int n,m; cin>>n>>m;
  int sx[n],sy[n];
  for(int i=0;i<n;i++){
    cin>>sx[i]>>sy[i];
  }int x[m],y[m];
  for(int i=0;i<m;i++){
    cin>>x[i]>>y[i];
  }for(int i=0;i<n;i++){
    int ans,minnum=1000000000;
    for(int j=0;j<m;j++){
      int log=minnum;
      minnum=min(minnum,abs(sx[i]-x[j])+abs(sy[i]-y[j]));
      if(minnum!=log){
        ans=j+1;
      }
    }cout<<ans<<endl;
  }
}