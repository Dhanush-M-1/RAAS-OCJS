#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n, m;
  cin >> n >> m;
  vector<long long> a(n), b(m);
  for (long long i = 0; i < n; i++) cin >> a[i];
  for (long long i = 0; i < m; i++) cin >> b[i];
  vector<long long>::iterator it;
  for (long long i = 0; i < n; i++) {
    it = find(b.begin(), b.end(), a[i]);
    if (it != b.end()) {
      cout << "YES" << endl;
      cout << 1 << " " << a[i] << endl;
      return;
    } else
      continue;
  }
  cout << "NO" << endl;
}
int main() {
  long long tt;
  cin >> tt;
  while (tt--) solve();
  return 0;
}
