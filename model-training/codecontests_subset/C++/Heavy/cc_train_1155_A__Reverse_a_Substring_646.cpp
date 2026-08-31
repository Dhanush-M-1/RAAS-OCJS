#include <bits/stdc++.h>
using namespace std;
int dx[] = {1, 0, 0, -1};
int dy[] = {0, -1, 1, 0};
int pct(int x) { return __builtin_popcount(x); }
template <typename T>
T _gcd(T __a, T __b) {
  return !__b ? __a : _gcd(__b, __a % __b);
}
template <typename T>
T _lcm(T __a, T __b) {
  return abs((__a / _gcd(__a, __b)) * __b);
}
template <typename T>
T _pow(T __n, T __p) {
  if (__p <= 1) {
    return (__p == 1) ? __n : 1;
  }
  T R = 1;
  if (__p % 2)
    return __n * _pow(__n, __p - 1);
  else
    R = _pow(__n, __p / 2);
  return R * R;
}
const int MOD = 1e9 + 7;
const int N = 2e5 + 5e2;
string s, tmp;
int n;
void Solve() {
  cin >> n >> s;
  tmp = s;
  sort(tmp.begin(), tmp.end());
  if (tmp == s) {
    cout << "NO" << endl;
  } else {
    cout << "YES" << endl;
    int L, R;
    for (int i = 0; i < n - 1; i++) {
      if (s[i + 1] < s[i]) {
        L = i + 1, R = i + 2;
        break;
      }
    }
    cout << L << ' ' << R << endl;
  }
}
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int Tc = 1;
  while (Tc--) Solve();
  return 0;
}
