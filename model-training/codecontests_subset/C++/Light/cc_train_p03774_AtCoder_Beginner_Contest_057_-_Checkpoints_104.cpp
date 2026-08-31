#include<bits/stdc++.h>
using namespace std;
int main(){
  int n,m;
  int a[51], b[51], c[51], d[51];
  cin >> n >> m;
  for(int i=1;i<=n;i++){
    cin >> a[i] >> b[i];
  }
  for(int i=1;i<=m;i++){
    cin >> c[i] >> d[i];
  }
  for(int i=1;i<=n;i++){
    int mn = 300000000;
    int p = -1;
    for(int j=1;j<=m;j++){
      int crr = abs(a[i]-c[j]) + abs(b[i]-d[j]);
      if(crr < mn){
        mn = crr;
        p = j;
      }
    }
    cout << p << endl;
  }
} 