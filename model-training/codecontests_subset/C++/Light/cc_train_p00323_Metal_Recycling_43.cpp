#include<bits/stdc++.h>
using namespace std;
int a[500000];
int main(){
  int n,x,y;
  cin>>n;
  for(int i=0;i<n;i++){
    cin>>x>>y;
    a[x+y]++;
  }
  for(int i=0;i<500000;i++){
    if(a[i]>1){
      a[i+1]+=a[i]/2;
      if(a[i]%2)a[i]=1;
      else a[i]=0;
    }
  }
  for(int i=0;i<500000;i++){
    if(a[i])cout<<i<<' '<<0<<endl;
  }
}