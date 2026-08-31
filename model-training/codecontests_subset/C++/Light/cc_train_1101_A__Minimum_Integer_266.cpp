#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f, mod = 1000000007;
const long long INF = 0x3f3f3f3f3f3f3f3fLL;
const double pi = acosl(-1.), eps = 1e-9;
inline int power(int a, int b, int m = mod, int ans = 1) {
  for (; b; b >>= 1, a = 1LL * a * a % m)
    if (b & 1) ans = 1LL * ans * a % m;
  return ans;
}
int main() {
  int Q;
  cin >> Q;
  int L, R, d;
  while (Q--) {
    cin >> L >> R >> d;
    if (d < L)
      cout << d << endl;
    else {
      if (R < d)
        cout << d << endl;
      else
        cout << (R - (R % d) + d) << endl;
    }
  }
  return 0;
}
