#include <bits/stdc++.h>
#pragma GCC optimize("Ofast,no-stack-protector,unroll-loops,fast-math,O3")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
int q;
void solve() {
  long long n, l, r, cnt = 0, cur = 0;
  cin >> n >> l >> r;
  for (long long i = 1; i <= n; i++) {
    bool ok = 1;
    if (cur + (n - i) + (n - i) < l) {
      cur += (n - i) + (n - i);
      continue;
    }
    for (long long j = i + 1; j <= n; j++) {
      if (l <= cur + 1 && cur + 1 <= r) cout << i << " ", ++cnt;
      cur++;
      if (l <= cur + 1 && cur + 1 <= r) cout << j << " ", ++cnt;
      cur++;
      if (cur > r) {
        ok = 0;
        break;
      }
    }
    if (!ok) break;
  }
  if (cnt != r - l + 1) cout << 1;
  cout << "\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cout.precision(30);
  cerr.precision(7);
  ;
  cin >> q;
  while (q--) solve();
  return 0;
}
