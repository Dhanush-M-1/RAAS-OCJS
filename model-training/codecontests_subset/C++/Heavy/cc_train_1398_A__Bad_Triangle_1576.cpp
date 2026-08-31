#include <bits/stdc++.h>
using namespace std;
long long MOD = 998244353;
const long long L_INF = 1LL << 60;
const long long INF = 2147483647;
const double PI = acos(-1);
template <class T>
inline bool chmin(T &a, T b) {
  if (a > b) {
    a = b;
    return true;
  }
  return false;
}
template <class T>
inline bool chmax(T &a, T b) {
  if (a < b) {
    a = b;
    return true;
  }
  return false;
}
template <class T>
void debug(T v) {
  for (long long i = 0; i < v.size(); ++i) cout << v[i] << " ";
  cout << endl;
}
long long pcount(long long x) { return __builtin_popcountll(x); }
const long long dx[8] = {1, 1, 0, -1, -1, -1, 0, 1};
const long long dy[8] = {0, 1, 1, 1, 0, -1, -1, -1};
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    vector<long long> a(n);
    for (long long i = 0; i < n; ++i) cin >> a[i];
    if (a[0] + a[1] <= a[n - 1])
      cout << "1 2 " << n << endl;
    else
      cout << -1 << endl;
  }
}
