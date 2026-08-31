#include<bits/stdc++.h>
using namespace std;
int main(){
  long long n,m,x,nmin,ans;
  int a[59],b[59],c[59],d[59];
  cin>>n>>m;
  for(int i=0;i<n;i++)cin>>a[i]>>b[i];
  for(int i=0;i<m;i++)cin>>c[i]>>d[i];
  for(int i=0;i<n;i++){
    nmin=1000000000;
    for(int j=0;j<m;j++){
      x=abs(a[i]-c[j])+abs(b[i]-d[j]);
      if(nmin>x){
	ans=j+1;
	nmin=x;
      }
    }
    cout<<ans<<endl;
  }
  return(0);
}
