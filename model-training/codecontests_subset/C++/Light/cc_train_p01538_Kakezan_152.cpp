//Kakezan
#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
int flag[10000000];

ll next(ll x){
  ll y=x%10;
  ll ret=0;
  ll cnt=10;
  x/=10;
  while(x!=0){
    if(ret<x*y)ret=x*y;
    y=(x%10)*cnt+y;
    x/=10;
    cnt*=10;
  }
  return ret;
}

int main(){
  int Q;
  cin>>Q;
  for(int i=0; i<Q; i++){
    memset(flag, 0, sizeof(flag));
    int N;
    cin>>N;
    ll cnt=0;
    while(true){
      flag[N]=1;
      if(N<10){cout<<cnt<<endl; break;}
      N=next(N);
      if(flag[N]==1){cout<<"-1"<<endl; break;}
      cnt++;
    }
  }
  return 0;
}