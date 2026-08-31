#include <bits/stdc++.h>
using namespace std;
const long long N = 1e6;
set<long long> g[N];
long long a[N];
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  long long n, m, lol, kol = 0;
  cin >> n >> m;
  for (long long i = 0; i < n; i++) {
    cin >> a[i];
  }
  lol = a[n - 1];
  for (long long i = 0; i < m; i++) {
    long long l, r;
    cin >> l >> r;
    g[r].insert(l);
  }
  long long kek = n - 1;
  for (long long i = n - 2; i >= 0; i--) {
    for (long long j = i + 1; j <= kek; j++) {
      if (g[a[j]].find(a[j - 1]) == g[a[j]].end()) {
        break;
      } else {
        swap(a[j - 1], a[j]);
        if (a[j - 1] == lol) {
          kek = j - 1;
          break;
        }
      }
    }
  }
  for (long long i = 0; i < n; i++) {
    if (a[i] == lol) {
      cout << n - i - 1;
      return 0;
    }
  }
}
