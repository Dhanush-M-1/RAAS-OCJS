#include<bits/stdc++.h>
using namespace std;

int main(){
  int N,M;
  int a[50],b[50],c[50],d[50];
  cin>>N>>M;
  for(int i=0;i<N;i++)
    cin>>a[i]>>b[i];
  
  for(int i=0;i<M;i++)
    cin>>c[i]>>d[i];

  for(int i=0;i<N;i++){
    int mini=1e9;
    int ans;
    for(int j=0;j<M;j++){
      int dist=abs(a[i]-c[j])+abs(b[i]-d[j]);
      if(mini>dist){
        mini=dist;
        ans=j;
      }
    }
    cout<<ans+1<<endl;
  }
  return 0;
}
