#include <bits/stdc++.h>
using namespace std;

int main() {
  int n,m;
  cin >> n >> m;
  vector<int> a(n),b(n),c(m),d(m);
  for(int i=0; i<n; i++) {
    cin >> a[i] >> b[i];
  }
  for(int i=0; i<m; i++) {
    cin >> c[i] >> d[i];
  }
  for(int i=0; i<n; i++) {
    int min=abs(a[i]-c[0])+abs(b[i]-d[0]);
    int cnt=1;
    for(int j=1; j<m; j++) {
      int x=abs(a[i]-c[j])+abs(b[i]-d[j]);
      if(min>x) {
        cnt=j+1;
        min=x;
      }
    }
    cout << cnt << endl;
  }
}
