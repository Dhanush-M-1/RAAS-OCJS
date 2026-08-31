#include<bits/stdc++.h>
using namespace std;
int main(){

  int n,cnt=0;
  cin>>n;

  int a[101];

  for(int i=0;i<n;i++){
    cin>>a[i];
  }


  for(int i=0;i<n;i++){
    int maxi=i;
    for(int j=i+1;j<n;j++){
      if(a[j]<a[maxi]){
	maxi=j;
      }
    }
    if(maxi!=i){
      cnt++;
      swap(a[maxi],a[i]);
    }
  }

  for(int i=0;i<n;i++){
    if(i==n-1){
      cout<<a[i]<<endl;
    }else{
      cout<<a[i]<<" ";
    }
  }

  cout<<cnt<<endl;
  return 0;

}

