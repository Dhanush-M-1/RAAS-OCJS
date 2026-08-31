#include<bits/stdc++.h>
using namespace std;
int main(){
  int n,m;
  int a[55],b[55],c[55],d[55];
  cin>>n>>m;
  for(int i=0;i<n;i++)cin>>a[i]>>b[i];
  for(int i=0;i<m;i++)cin>>c[i]>>d[i];
  for(int i=0;i<n;i++){
    int ans;
    int min=1e9;
    for(int j=0;j<m;j++){
      int t=abs(a[i]-c[j])+abs(b[i]-d[j]);
      if(t<min){
	min=t;
	ans=j+1;
      }
    }
    cout<<ans<<endl;
  }
  return 0;
}
