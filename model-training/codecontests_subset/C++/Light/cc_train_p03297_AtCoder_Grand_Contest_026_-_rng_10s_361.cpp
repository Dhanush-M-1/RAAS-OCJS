#include <bits/stdc++.h>
using namespace std;
#define rep(i,n) for(int i=0;i<(n);i++)
#define ll long long
int main(){
  int T;
  cin>>T;
  ll A,B,C,D;
  rep(i,T){
    cin>>A>>B>>C>>D;
    ll ans=1;
    if(A<B||B>D) ans=0;
    else if(B>C){
      ll E=B,r=D%B;
      while(r){
        D=E;
        E=r;
        r=D%E;
      }
      if(max((B-1)/E*E,(B-(A%B)-1)/E*E+A%B)>C) ans=0;
    }
    cout<<(ans?"Yes":"No")<<endl;
  }
}