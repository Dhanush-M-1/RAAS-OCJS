#include<bits/stdc++.h>
using namespace std;
 
int main(){
  int b[5]={5,7,5,7,7};
  while(1){
    int n,a[41]={};
    int count=0,ans=0,j=0,c=0;
    string str;
    cin>>n;
    if(n==0)break;
 
    for(int i=0;i<n;i++){
      cin>>str;
      a[i]=str.size();
    }
 
    for(int i=0;i<n;i++){
      c+=a[i];
      count++;
      if(c==b[j]){
    j++;
    c=0;
      }
      else if(c>b[j]){
    i-=count-1;
    j=0;
    c=0;
    count=0;
       }
      if(j>4){
    ans=i-(count-1);
    break;
      }
    }
 
    cout<<ans+1<<endl;
  }
  return 0;
}