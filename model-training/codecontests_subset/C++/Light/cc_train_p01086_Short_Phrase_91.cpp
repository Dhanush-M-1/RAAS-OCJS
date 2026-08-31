#include<bits/stdc++.h>
using namespace std;
int main(){
  int n,d[]={5,7,5,7,7},i,j,t,k;
  while(cin>>n,n){
    string s[41];
    for(i=0;i<n;i++)cin>>s[i];
    for(i=0,k=0;k!=5;i++)
      for(j=i,t=s[i].size(),k=0;k!=5;t+=s[++j].size())
	if(t==d[k])k++,t=0;
	else if(t>d[k])break;
    cout<<i<<endl;
  }
  return 0;
}