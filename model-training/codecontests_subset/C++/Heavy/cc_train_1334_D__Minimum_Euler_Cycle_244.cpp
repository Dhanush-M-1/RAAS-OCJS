#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    long long len = n * (n - 1) + 1;
    long long i = l;
    for (; i <= r && i <= 2 * (n - 2) + 1; i++) {
      if (i % 2)
        cout << 1 << " ";
      else
        cout << 1 + i / 2 << " ";
    }
    if (i > r) {
      cout << "\n";
      continue;
    }
    map<long long, tuple<long long, long long, long long>> seen;
    long long si = 2 * (n - 2) + 2;
    for (long long k = 2; k <= n - 1; k++) {
      long long len = 2 * (n - k);
      seen[si] = make_tuple(k, len, si + len - 1);
      si += len;
    }
    long long idx = i;
    while (!(seen.count(idx) > 0) && seen.size() != 0) {
      idx--;
    }
    while (i <= r && i <= len - 2) {
      for (; i <= r && i <= get<2>(seen[idx]); i++) {
        long long j = i - idx;
        if (j == 0)
          cout << n << " ";
        else if (j % 2 == 0)
          cout << get<0>(seen[idx]) + (j / 2) << " ";
        else
          cout << get<0>(seen[idx]) << " ";
      }
      idx = i;
    }
    if (i <= r && r <= len) {
      if (i == len - 1 && i <= r) {
        cout << n << " ";
        i++;
      }
      if (i == len && i <= r) cout << 1 << " ";
    }
    cout << "\n";
  }
  return 0;
}
