#include<bits/stdc++.h>
using namespace std;
#define MOD 1000000007
#define BIG 1000000010
#define repi(i,x,n) for(int i=x;i<n;i++)
#define rep(i,n) repi(i,0,n)
#define repn(i,n) for(int i=n;i>=0;i--)
typedef long long int ll;


int main(){
  int n;
  string s[40];
  int a[40];
  int check[5]={5,7,5,7,7};
  int cnt=0;
  bool b=false;
  while(1){
    cin>>n;
    if(n==0) break;
    b=false;
    rep(i,n){
      cin>>s[i];
      a[i]=s[i].size();
    }
    rep(i,n){
      cnt=0;
      int now=0;
      rep(j,5){
	cnt+=a[i+now];
	if(cnt<check[j]) j--;
	else if(cnt>check[j]) break;
	else cnt=0;
	if(j==4){cout<<i+1<<endl;b=true;break;}
	now++;
      }
      if(b) break;
    }
  }
    
  

  return 0;
}




