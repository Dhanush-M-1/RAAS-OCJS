#include <bits/stdc++.h>
using namespace std;
long long power(long long x, long long y, long long p) {
  long long res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
void solve() {
  long long k, n, i;
  cin >> k;
  string s;
  cin >> s;
  n = s.length();
  if (k > n) {
    cout << -1;
    return;
  }
  map<char, long long> m;
  for (auto c : s) m[c]++;
  string ans;
  for (auto val : m) {
    if (val.second % k) {
      cout << -1;
      return;
    } else
      ans.append(val.second / k, val.first);
  }
  for (i = 1; i <= k; i++) cout << ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t;
  t = 1;
  while (t--) solve();
  return 0;
}
