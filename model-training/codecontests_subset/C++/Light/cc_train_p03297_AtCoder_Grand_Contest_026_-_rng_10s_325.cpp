#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
  ll t;
  cin>>t;
  for(ll i=0;i<t;i++){
    ll a,b,c,d;
    cin>>a>>b>>c>>d;
    if(a<b) {
      cout<<"No"<<endl;
      continue;
    }
    else if(b>d){
      cout<<"No"<<endl;
      continue;
    }
    else if(b<=c){
      cout<<"Yes"<<endl;
      continue;
    }
    ll fb=b;
    if(b<d) swap(b,d);
    while(b%d!=0){
      ll md=b%d;
      b=d;
      d=md;
    }
    ll max_v=fb-d+(a%d);
    if(max_v>c) cout<<"No"<<endl;
    else cout<<"Yes"<<endl;
  }
}
