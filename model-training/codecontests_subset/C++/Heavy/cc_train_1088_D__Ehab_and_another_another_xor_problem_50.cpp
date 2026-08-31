#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
const int INF = 0x3f3f3f3f;
using namespace std;
const int mxn = 1e3 + 7;
long long n, t, m, k, l, r;
long long mat[mxn][mxn], prime[mxn], isprime[mxn], phi[mxn];
pair<int, int> a[mxn][mxn];
string str;
char ch;
int check(int l, int r) {
  cout << "? " << l << ' ' << r << endl;
  cin >> k;
  return k;
}
int main() {
  n = 0, m = 0;
  long long res = check(n, m);
  for (int i = 29; i >= 0; i--) {
    l = check(n ^ (1 << i), m);
    r = check(n, m ^ (1 << i));
    if (l == r) {
      if (res == 1)
        n ^= (1 << i);
      else if (res == -1)
        m ^= (1 << i);
      res = l;
    } else if (l == -1)
      n ^= (1 << i), m ^= (1 << i);
  }
  cout << "! " << n << ' ' << m << endl;
}
