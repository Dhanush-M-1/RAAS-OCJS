#include <bits/stdc++.h>
using namespace std;
signed main(){
  int n,m,a[55],b[55],c[55],d[55];
  cin>>n>>m;
  for(int i=0;i<n;i++)
    cin>>a[i]>>b[i];

  for(int i=0;i<m;i++)
    cin>>c[i]>>d[i];

  for(int i=0;i<n;i++){
    int ans,data=1;
    for(int j=0;j<m;j++){
      int sma = abs(a[i]-c[j])+abs(b[i]-d[j]);
      if(j == 0)
	ans=sma;
      else if(sma<ans){
	ans=sma;
	data=j+1;
      }
    }
    cout<<data<<endl;
  }
  return(0);
}
