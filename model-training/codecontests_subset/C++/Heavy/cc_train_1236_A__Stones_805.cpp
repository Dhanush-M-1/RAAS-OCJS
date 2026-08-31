#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000000000 + 7;
inline int add(int a, int b) {
  a += b;
  if (a >= MOD) a -= MOD;
  return a;
}
inline int sub(int a, int b) {
  a -= b;
  if (a < 0) a += MOD;
  return a;
}
inline int mul(int a, int b) { return (int)((long long)a * b % MOD); }
inline int binpow(int a, int b) {
  int res = 1;
  while (b > 0) {
    if (b & 1) res = mul(res, a);
    a = mul(a, a);
    b /= 2;
  }
  return res;
}
inline int inv(int a) { return binpow(a, MOD - 2); }
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int res = 0;
    if (c <= 2 * b) {
      int tmp = c / 2;
      res += (tmp * 3);
      b -= tmp;
      if (b <= 2 * a) {
        tmp = b / 2;
        res += tmp * 3;
      } else {
        res += 3 * a;
      }
    } else {
      res += 3 * b;
    }
    cout << res << "\n";
  }
  return 0;
}
