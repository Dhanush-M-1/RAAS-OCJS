#include<bits/stdc++.h>
using namespace std;
int a[200100];
int main(){
  int n,x,y;
  cin>>n;
  for(int i=0;i<n;i++){
    cin>>x>>y;
    a[x+y]++;
  }
  for(int i=0;i<200100;i++)
    if(a[i]>1){
      a[i+1]+=a[i]/2;
      a[i]=a[i]%2?1:0;
    }
  for(int i=0;i<200100;i++)
    if(a[i])cout<<i<<' '<<0<<endl;
}