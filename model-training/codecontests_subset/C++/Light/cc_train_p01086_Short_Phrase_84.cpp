#include<bits/stdc++.h>
#define N 45
using namespace std;
int n,l[N],L[N],ans;
int d[5]={5,7,5,7,7};
string s;

int main(){
  while(1){
    cin>>n;
    if(!n)break;
    for(int i=1;i<=n;i++){
      cin>>s,l[i]=s.size();
      L[i]=L[i-1]+l[i];
    }
    ans=0;
    for(int i=1;i<=n;i++){
      int idx=0,s=i;
      for(int j=i;j<=n;j++){
	if(L[j]-L[s-1]==d[idx])idx++,s=j+1;
	if(!ans&&idx==5)ans=i;
      }
    }
    cout<<ans<<endl;
  }
  return 0;
}