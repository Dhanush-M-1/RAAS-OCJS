#include<bits/stdc++.h>
using namespace std;
#define INF 1000000000
int main(){
  int n,m;
  int a[59],b[59],c[59],d[59];
  cin>>n>>m;
  for(int i=0;i<n;i++){
    cin>>a[i]>>b[i];
  }
  for(int i=0;i<m;i++){
    cin>>c[i]>>d[i];
  }
  for(int i=0;i<n;i++){
    int t=INF,ans;
    for(int j=0;j<m;j++){
      if(abs(a[i]-c[j])+abs(b[i]-d[j])<t){
	t=abs(a[i]-c[j])+abs(b[i]-d[j]);
	ans=j+1;
      }
    }
    cout<<ans<<endl;
  }
  return(0);
}
