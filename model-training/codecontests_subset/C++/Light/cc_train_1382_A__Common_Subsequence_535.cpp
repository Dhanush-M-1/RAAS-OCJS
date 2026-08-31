#include <bits/stdc++.h>
using namespace std;
const int N = 1100;
long long _, n, m, a[N], b[N], tag;
void solve() {
  cin >> n >> m;
  tag = 0;
  for (int i = 0; i < n; ++i) cin >> a[i];
  for (int i = 0; i < m; ++i) {
    cin >> b[i];
    for (int j = 0; j < n; ++j) {
      if (a[j] == b[i]) tag = a[j];
    }
  }
  if (!tag)
    cout << "NO" << endl;
  else {
    cout << "YES" << endl;
    cout << 1 << " " << tag << endl;
  }
}
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> _;
  while (_--) solve();
}
