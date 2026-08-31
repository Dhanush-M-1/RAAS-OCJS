#include <bits/stdc++.h>
using namespace std;
void Solve() {
  int n, m, b[1000], a[1000];
  bool f[10000];
  memset(f, 0, sizeof(f));
  cin >> n >> m;
  for (int i = 0; i < n; ++i) cin >> a[i];
  for (int i = 0; i < m; ++i) {
    cin >> b[i];
    f[b[i]] = 1;
  }
  for (int i = 0; i < n; ++i)
    if (f[a[i]]) {
      cout << "YES" << endl;
      cout << 1 << " " << a[i] << endl;
      return;
    }
  cout << "NO" << endl;
}
int main() {
  int q;
  cin >> q;
  while (q--) Solve();
}
