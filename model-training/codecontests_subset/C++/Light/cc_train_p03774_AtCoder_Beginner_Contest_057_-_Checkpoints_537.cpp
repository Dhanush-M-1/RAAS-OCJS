#include<bits/stdc++.h>
using namespace std;

int main(){
  int n,m;
  cin >> n >> m;
  vector<int> a(n),b(n),c(m),d(m);
  for(int i=0;i<n;++i){
    cin >> a[i] >> b[i];
  }
  for(int j=0;j<m;++j){
    cin >> c[j] >> d[j];
  }
  for(int i=0;i<n;++i){
    int ma=1000000000;
    int x,y;
    int ans=-1;
    for(int j=0;j<m;++j){
      int kyori=abs(a[i]-c[j])+abs(b[i]-d[j]);
      if(ma>kyori){
        ans=j+1;
        ma=kyori;
      }
    }
    cout << ans << endl;
  }
}
