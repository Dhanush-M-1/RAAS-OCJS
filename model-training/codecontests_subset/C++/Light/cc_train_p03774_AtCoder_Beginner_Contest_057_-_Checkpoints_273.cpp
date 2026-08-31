#include<bits/stdc++.h>
using namespace std;

int a[100],b[100], c[100], d[100], ans[100], mini[100];
int main(void){
 int n, m; cin >> n >> m;
 for(int i=0;i<n;i++) cin >> a[i] >> b[i];
 for(int i=0;i<m;i++) cin >> c[i] >> d[i];
 for(int i=0;i<n;i++){
  mini[i] = INT_MAX;
 for(int j=0;j<m;j++){
  if (abs(a[i]-c[j])+abs(b[i]-d[j])<mini[i]) {ans[i] = j+1; mini[i] = abs(a[i]-c[j])+abs(b[i]-d[j]);}
  }
  cout << ans[i] << endl;
 }
 return 0;
}