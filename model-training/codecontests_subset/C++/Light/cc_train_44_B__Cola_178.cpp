#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int n;
  cin >> n;
  int a, b, c;
  cin >> a >> b >> c;
  int ans = 0;
  for (int x = 0; x <= a; x++)
    for (int y = 0; y <= b; y++) {
      if (x % 2) continue;
      int l = x * 0.5 + y;
      int req = n - l;
      if (req % 2 || req < 0) continue;
      req /= 2;
      if (req <= c) ans++;
    }
  cout << ans << endl;
}
