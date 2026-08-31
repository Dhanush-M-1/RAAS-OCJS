#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization("unroll-loops")
using namespace std;
void solve() {
  long long n, l, r;
  cin >> n >> l >> r;
  vector<long long> pre(n + 1, 0);
  for (int i = 1; i <= n; i++) {
    pre[i] = pre[i - 1] + 2 * (n - i);
  }
  pre[n]++;
  int i = lower_bound(pre.begin(), pre.end(), l) - pre.begin();
  long long lc = pre[i - 1] + 1;
  int j = i + 1;
  if (i == n) {
    cout << "1\n";
    return;
  }
  bool ok = 0;
  if (r == pre[n]) {
    ok = 1;
    r--;
  }
  while (lc <= r) {
    if (lc % 2) {
      if (lc >= l && lc <= r) {
        cout << i << " ";
      }
    } else {
      if (lc >= l && lc <= r) {
        cout << j << " ";
      }
      j++;
    }
    if (j > n) {
      i++;
      j = i + 1;
    }
    lc++;
  }
  if (ok) {
    cout << "1 ";
  }
  cout << "\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int T = 1;
  cin >> T;
  while (T--) {
    solve();
  }
  return 0;
}
