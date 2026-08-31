#include <bits/stdc++.h>
#define full(c) c.begin(), c.end()
typedef signed long long int ll;
typedef unsigned long long int ull;
using namespace std;

int main(){
  ll i,j,n,m,a[50],b[50],c[50],d[50];
  cin>>n>>m;
  for(i=0; i<n; i++) cin>>a[i],cin>>b[i];
  for(i=0; i<m; i++) cin>>c[i],cin>>d[i];
  for(i=0; i<n; i++){
    ll mi,mx=1000000001;
    for(j=0; j<m; j++){
      ll md=abs(a[i]-c[j])+abs(b[i]-d[j]);
      if(md<mx) mi=j+1,mx=md;
    }
    cout<<mi<<endl;
  }
  return 0;
}