#include<bits/stdc++.h>
using namespace std;
int main(){
  int N,M;
  cin>>N>>M;
  int a[N],b[N];
  for(int i=0;i<N;i++){
    cin>>a[i]>>b[i];
  }
  int c[M],d[M];
  for(int i=0;i<M;i++){
    cin>>c[i]>>d[i];
  }
  int ans[N],ma[N];
  for(int i=0;i<N;i++){
    ma[i]=(1<<29);
    for(int j=M-1;j>=0;j--){
      if(ma[i]>=abs(a[i]-c[j])+abs(b[i]-d[j])){
        ma[i]=abs(a[i]-c[j])+abs(b[i]-d[j]);
        ans[i]=j+1;
      }
    }
  }
  for(int i=0;i<N;i++){
    cout<<ans[i]<<endl;
  }
}