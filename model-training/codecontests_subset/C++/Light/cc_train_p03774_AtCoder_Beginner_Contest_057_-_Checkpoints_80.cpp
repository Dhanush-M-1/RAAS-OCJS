#include <bits/stdc++.h>
using namespace std;
int main(){
  int n,m;
  cin>>n>>m;
  int a[n],b[n],c[m],d[m];
  for(int i=0;i<n;i++){
    cin>>a[i]>>b[i];
  }
  for(int i=0;i<m;i++){
    cin>>c[i]>>d[i];
  }
  for(int i=0;i<n;i++){
    int mi=1000000000,e;
    for(int j=0;j<m;j++){
      if(mi>abs(a[i]-c[j])+abs(b[i]-d[j])){
        mi=abs(a[i]-c[j])+abs(b[i]-d[j]);
        e=j+1;
      }
    }
    cout<<e<<endl;
  }
}
         