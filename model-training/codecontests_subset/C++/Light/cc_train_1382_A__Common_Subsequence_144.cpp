#include <bits/stdc++.h>
using namespace std;
inline void solve() {
  int n, m;
  cin >> n >> m;
  int vf[1005];
  for (int i = 0; i <= 1000; i++) vf[i] = 0;
  int a, b;
  for (int i = 1; i <= n; i++) cin >> a, vf[a]++;
  bool ok = 0;
  int ok1;
  for (int j = 1; j <= m; j++) {
    cin >> b;
    if (vf[b] > 0) {
      ok = 1;
      ok1 = b;
    }
  }
  if (ok == 1) {
    cout << "YES\n1 " << ok1 << "\n";
  } else
    cout << "NO\n";
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
