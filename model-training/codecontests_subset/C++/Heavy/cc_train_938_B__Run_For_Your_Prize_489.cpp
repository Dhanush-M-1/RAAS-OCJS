#include <bits/stdc++.h>
using namespace std;
stringstream ss, ss1, ss2, ssx[1001];
string s, s1, s2, sx[1001];
char c[10001], c1, c2, cx[1001];
long long n, k, m, i, j, q, w, e, x, y, z, mx = -1e9, mn = +1e9, ans, sum,
                                           a[1000001], b[1000001];
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> a[i];
    x = a[i];
    b[x] = x;
  }
  for (i = 2, sum = 1, ans = 0, j = 999999; i <= 500002; i++, j--, sum++) {
    if (i == 2) ans = 0;
    if (b[i] != 0) {
      ans++;
    }
    if (b[j] != 0) {
      ans++;
    }
    if (ans == n) {
      cout << sum << endl;
      return 0;
    }
  }
  cout << sum << endl;
  return 0;
}
