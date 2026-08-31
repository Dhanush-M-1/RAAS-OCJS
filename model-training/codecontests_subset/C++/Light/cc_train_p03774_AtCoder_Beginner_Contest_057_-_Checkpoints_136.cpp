#include<bits/stdc++.h>
using namespace std;

int dn(int a,int b,int c,int d){
  return abs(c-a)+abs(d-b);
}

int main(){
  int n,m,i,j;
  cin>>n>>m;
  int a[n],b[n],c[m],d[m];
  for(i=0;i<n;i++){
    cin>>a[i]>>b[i];
  }
  for(i=0;i<m;i++){
    cin>>c[i]>>d[i];
  }
  int min[n];
  for(i=0;i<n;i++){
    min[i]=0;
    for(j=0;j<m;j++){
      if(dn(a[i],b[i],c[j],d[j])<dn(a[i],b[i],c[min[i]],d[min[i]]))min[i]=j;
    }
  }
  for(i=0;i<n;i++){
    cout<<min[i]+1<<endl;
  }
}