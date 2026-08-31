#include <bits/stdc++.h>
using namespace std;
int main(){
  int n,m,i,y,ans;
  cin>>n>>m;
  long int a[n],b[n],c[m],d[m];
  for(i=0;i<n;++i){
    cin>>a[i]>>b[i];
  }
  for(i=0;i<m;++i){
    cin>>c[i]>>d[i];
  }
  for(i=0;i<n;++i){
    long min = 400000001;
    for(int j=0;j<m;++j){
      y = (abs(a[i]-c[j])+abs(b[i]-d[j]));
      if(min>y){
        min = y;
        ans = j+1;
      }
    }
    cout<<ans<<endl;
  }
}
