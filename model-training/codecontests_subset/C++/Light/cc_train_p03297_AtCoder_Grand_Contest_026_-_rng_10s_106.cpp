#include <bits/stdc++.h>
using namespace std;
#define ll long long

ll gcd(ll x, ll y) {
  if(y==0)return x;
  
  return gcd(y,x%y);
}

int main(){
  int n;cin>>n;
  
  for(int i=0;i<n;++i){
    bool pos=true;
    ll a,b,c,d;
    cin>>a>>b>>c>>d;

    ll g=gcd(b,d);
    ll Max_Stock=b-g+a%g;
    if(Max_Stock>c)pos=false;
    if(a<b||d<b)pos=false;
    
    if(pos)cout<<"Yes"<<endl;
    else cout<<"No"<<endl;
  }
}