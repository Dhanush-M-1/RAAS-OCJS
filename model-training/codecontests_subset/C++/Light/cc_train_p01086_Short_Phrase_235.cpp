#include<bits/stdc++.h>
using namespace std;
int n,l[45],L[45],a,d[5]={5,7,5,7,7};
string s;

int main(){
  while(1){
    cin>>n;
    if(!n)break;
    for(int i=1;i<=n;i++){
      cin>>s,l[i]=s.size();
      L[i]=L[i-1]+l[i];
    }
    a=0;
    for(int i=1;i<=n;i++){
      int x=0,s=i;
      for(int j=i;j<=n;j++){
	if(L[j]-L[s-1]==d[x])x++,s=j+1;
	if(!a&&x==5)a=i,cout<<a<<endl;
      }
    }
  }
  return 0;
}