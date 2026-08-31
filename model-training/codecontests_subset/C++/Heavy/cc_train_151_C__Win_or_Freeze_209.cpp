#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n;
  cin >> n;
  map<long long, long long> m;
  for (long long i = 2; i * i <= n; i++) {
    while (n % i == 0) {
      m[i]++;
      n /= i;
    }
  }
  if (n > 1) m[n]++;
  long long s = 0, ans = 1, p = 0;
  if (m.size() == 0) {
    cout << 1 << '\n' << 0;
    return;
  }
  for (auto i : m) {
    s += i.second;
    if (p < 2) {
      if (i.second > 1)
        ans = i.first * i.first, p = 2;
      else
        ans *= i.first, p++;
    }
  }
  if (s > 2) {
    cout << 1 << '\n' << ans << '\n';
    return;
  }
  if (s == 2) {
    cout << 2 << '\n';
    return;
  }
  if (s == 1) {
    cout << 1 << '\n' << 0;
    return;
  }
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
