#include <bits/stdc++.h>
#define r(i,n) for(int i = 0; i<n; i++)
typedef long long ll;
using namespace std;

int main(){
  int n,m;
  cin >> n >> m;
  int a[n],b[n],c[m],d[m],ans[n],ans2[n];
  r(i,n){
    cin >> a[i] >> b[i];
    ans[i]=1000000000;
  }
  r(i,m){
    cin >> c[i]>>d[i];
    r(j,n){
      if(ans[j]>abs(a[j]-c[i])+abs(b[j]-d[i])){
        ans[j]=min(ans[j],abs(a[j]-c[i])+abs(b[j]-d[i]));
        ans2[j]=i+1;
      }
    }
  }
  r(i,n)cout << ans2[i]<<endl;
}