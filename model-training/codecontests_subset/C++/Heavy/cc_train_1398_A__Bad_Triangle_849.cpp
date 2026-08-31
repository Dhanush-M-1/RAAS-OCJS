#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e9 + 7;
const long long INF = 1LL << 60;
const long long mod = 1e9 + 7;
const long double eps = 1e-8;
const long double pi = acos(-1.0);
template <class T>
inline bool chmax(T& a, T b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
inline bool chmin(T& a, T b) {
  if (a > b) {
    a = b;
    return 1;
  }
  return 0;
}
void solve() {
  long long n;
  cin >> n;
  vector<long long> a(n);
  for (long long i = 0; i < n; i++) {
    cin >> a[i];
  }
  if (a[0] + a[1] <= a[n - 1]) {
    cout << 1 << " " << 2 << " " << n << endl;
  } else {
    cout << -1 << endl;
  }
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long t;
  cin >> t;
  for (long long i = 0; i < t; i++) solve();
  return 0;
}
