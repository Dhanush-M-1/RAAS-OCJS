#include<bits/stdc++.h>
using namespace std;
int main(){
  int i,j,a[100],n,minj,count=0;
  cin>>n;
  for(i=0;i<n;i++){
    cin>>a[i];
  }
  
  for(i=0;i<n;i++){
    minj=i;
    for(j=i;j<n;j++)if(a[j]<a[minj])minj=j;
    if(i!=minj){
      swap(a[i],a[minj]);
      count++;
    }
  }
  
  for(i=0;i<n;i++){
    if(i==n-1)cout<<a[i];
    else cout<<a[i]<<" ";
  }
  cout<<endl;
  cout<<count<<endl;
  return 0;
}

    


