#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
const double PI = acos(-1);
long long fast_exp(long long a, long long b) {
  long long res = 1;
  while (b) {
    if (b & 1LL) {
      res *= a;
      res %= 1000000007;
    }
    b >>= 1LL;
    a *= a;
    a %= 1000000007;
  }
  return res;
}
int query(int x, int y) {
  cout << "? " << x << ' ' << y << "\n" << flush;
  int q;
  cin >> q;
  if (q == -2) {
    exit(1);
  }
  return q;
}
signed main(int argc, char* argv[], char* envp[]) {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.precision(20);
  cerr << fixed;
  cout << fixed;
  int a = 0, b = 0, c = 0, d = 0;
  int res = query(c, d);
  for (int i = 29; i >= 0; i--) {
    int q = query(c | (1 << i), d | (1 << i));
    if ((res == -1 and q == 1) or (res == 1 and q == -1)) {
      if (res == -1) {
        b |= (1 << i);
        d |= (1 << i);
      } else if (res == 1) {
        a |= (1 << i);
        c |= (1 << i);
      }
      res = query(c, d);
    } else {
      int q1 = query(c, d | (1 << i));
      if (q1 == 1) {
        a |= (1 << i);
        b |= (1 << i);
        c |= (1 << i);
        d |= (1 << i);
      }
    }
  }
  cout << "! " << a << ' ' << b << endl << flush;
  return 0;
}
