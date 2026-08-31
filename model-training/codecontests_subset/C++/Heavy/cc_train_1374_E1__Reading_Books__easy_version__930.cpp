#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1e9 + 7;
const long long MOD2 = 998244353;
const float pi = 3.141592653;
long long power(long long a, long long b) {
  if (b == 0) return 1;
  long long p = power(a, b / 2);
  if (b & 1)
    return p * p * a;
  else
    return p * p;
}
void solve() {
  long long n, k;
  cin >> n >> k;
  vector<long long> a, b, c;
  for (long long i = 0; i < n; i++) {
    long long o, t, f;
    cin >> o >> t >> f;
    if (t == 1 && f == 1)
      c.push_back(o);
    else if (t == 1)
      a.push_back(o);
    else if (f == 1)
      b.push_back(o);
  }
  if (a.size() + c.size() < k || b.size() + c.size() < k) {
    cout << -1;
    return;
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  long long ans = 0, count = 0, index1 = 0, index2 = 0;
  while (1) {
    if (index2 == min(a.size(), b.size()) || index1 == c.size()) break;
    if (a[index2] + b[index2] <= c[index1]) {
      ans += a[index2] + b[index2];
      index2++;
    } else {
      ans += c[index1];
      index1++;
    }
    count++;
    if (count == k) break;
  }
  if (index1 < c.size()) {
    while (count < k) {
      ans += c[index1];
      index1++;
      count++;
    }
  }
  if (index2 < min(a.size(), b.size())) {
    while (count < k) {
      count++;
      ans += (a[index2] + b[index2]);
      index2++;
    }
  }
  cout << ans;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t = 1;
  while (t--) {
    solve();
    cout << "\n";
  }
  return 0;
}
