#include<bits/stdc++.h>
using namespace std;
int main(){
  int n,m;
  cin>>n>>m;
  int a[n],b[n];
  for(int i=0;i<n;i++){
    cin>>a[i]>>b[i];
  }
  int c[m],d[m];
  for(int i=0;i<m;i++){
    cin>>c[i]>>d[i];
  }
  for(int i=0;i<n;i++){
    int ma=1000000000,mb;
    for(int j=0;j<m;j++){
      if(abs(a[i]-c[j])+abs(b[i]-d[j])<ma){
        ma=abs(a[i]-c[j])+abs(b[i]-d[j]);
        mb=j+1;
      }
    }
    cout<<mb<<endl;
  }
}