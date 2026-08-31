#include<bits/stdc++.h>
#define _ ios_base::sync_with_stdio(0);cin.tie(0);
#define REP(i,n) for(int i=0;i<(int)(n);i++)

using namespace std;

int n;
void solve(){
  int i=0;
  for(;n/10>0;i++){
    int s=n,n_=0;
    for(int j=10;;j*=10){
      int u=s/j;
      if(u==0)break;
      int l=s%j;
      n_=max(n_,u*l);
    }
    n=n_;
  }
  cout<<i<<endl;
}

int main(){ _;
  int q;cin>>q;
  REP(i,q){
    cin>>n;
    solve();
  }
}