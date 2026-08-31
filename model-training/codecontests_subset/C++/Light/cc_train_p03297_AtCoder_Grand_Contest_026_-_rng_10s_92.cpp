#include "bits/stdc++.h"
using namespace std;
#define int long long
int mod=1e9+7;

int gcd(int a,int b){
  if(a<b)gcd(b,a);
  int r;
  while((r=a%b)){
    a=b;
    b=r;
  }
  return b;
}

signed main(){
  int t;
  cin>>t;
  for(int i=0;i<t;i++){
    int a,b,c,d;
    cin>>a>>b>>c>>d;
    if(b>a||b>d){
      cout<<"No"<<endl;
    }else if(c>=b){
      cout<<"Yes"<<endl;
    }else{
      int g=gcd(b,d);
      if(b-g+(a%g)>c){
        cout<<"No"<<endl;
      }else{
        cout<<"Yes"<<endl;
      }
    }
  }
}
