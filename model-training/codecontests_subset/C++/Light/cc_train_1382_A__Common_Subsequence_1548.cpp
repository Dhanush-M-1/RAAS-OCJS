#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n, m;
  cin >> n >> m;
  vector<long long> num(1001, 0);
  for (long long i = (0); i < (n); ++i) {
    long long a;
    cin >> a;
    num[a] = 1;
  }
  for (long long i = (0); i < (m); ++i) {
    long long b;
    cin >> b;
    if (num[b] == 1) num[b] = 2;
  }
  for (long long i = (1); i < (1001); ++i) {
    if (num[i] == 2) {
      cout << "YES\n1 " << i << "\n";
      return;
    }
  }
  cout << "NO"
       << "\n";
}
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long t;
  t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
