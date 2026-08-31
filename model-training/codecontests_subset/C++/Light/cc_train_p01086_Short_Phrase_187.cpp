#include <bits/stdc++.h>
using namespace std;

int main(){
  int n;
  while(cin>>n,n){
    string str[50];
    for(int i=0;i<n;i++)cin>>str[i];


    int num[]={5,7,5,7,7},ans=1000000;
    for(int i=0;i<n;i++){
      for(int j=i,idx=0,cnt=0;j<n;j++){
	cnt+=str[j].size();
	if(cnt==num[idx]) idx++,cnt=0;
	if(cnt>num[idx])break;
	if(idx==5) ans=min(ans,i);
      }    
    }
    cout <<ans+1<<endl;
  }
  return 0;
}