#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long int i, j, k, n, m;
  cin >> n >> m;
  vector<long long int> a(n), b(m);
  for (auto &i : a) cin >> i;
  ;
  for (auto &i : b) cin >> i;
  ;
  map<long long int, long long int> m2;
  for (i = 0; i < n; i++) m2[a[i]]++;
  for (i = 0; i < m; i++) {
    if (m2[b[i]]) {
      cout << "YES\n";
      cout << 1 << " " << b[i] << '\n';
      return;
    }
  }
  cout << "NO\n";
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int t = 1;
  cin >> t;
  while (t--) solve();
  return 0;
}
