#include<bits/stdc++.h>
#define _ ios_base::sync_with_stdio(0);cin.tie(0);
#define REP(i,n) for(int i=0;i<(int)(n);i++)

using namespace std;
int a[51],b[51],c[51],d[51];
pair<int,int> diff[51];
int main(){ _;
  int n,m;cin>>n>>m;
  REP(i,n) cin>>a[i]>>b[i];
  REP(i,m) cin>>c[i]>>d[i];
  REP(i,n){
    REP(j,m){
      diff[j].first=abs(a[i]-c[j])+abs(b[i]-d[j]);
      diff[j].second=j+1;
    }
    sort(diff,diff+m);
    cout<<diff[0].second<<endl;
  }
}
