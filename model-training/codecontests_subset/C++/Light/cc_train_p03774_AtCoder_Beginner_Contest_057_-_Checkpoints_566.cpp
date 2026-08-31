#include<bits/stdc++.h>
using namespace std;
#define int long long
signed main(){
  int n,m;
  cin>>n>>m;
  int a[n],b[n],c[m],d[m];
  for(int i=0;i<n;i++) cin>>a[i]>>b[i];
  for(int i=0;i<m;i++) cin>>c[i]>>d[i];
  for(int i=0;i<n;i++){
    int ans=0;
    for(int j=0;j<m;j++){
      if(abs(a[i]-c[j])+abs(b[i]-d[j])<abs(a[i]-c[ans])+abs(b[i]-d[ans]))
	ans=j;
    }
    cout<<ans+1<<endl;
  }
  return 0;
}
