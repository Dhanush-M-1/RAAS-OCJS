#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  char c = getchar();
  long long x = 0;
  bool f = 0;
  for (; !isdigit(c); c = getchar()) f ^= !(c ^ 45);
  for (; isdigit(c); c = getchar()) x = (x << 1) + (x << 3) + (c ^ 48);
  if (f) x = -x;
  return x;
}
const long long M = 210;
long long n, a[M][M];
void check(long long x, long long y, long long p) {
  if (a[x][y] != p) cout << x << ' ' << y << endl;
}
signed main() {
  long long T = read();
  while (T--) {
    long long n = read();
    for (long long i = 1; i <= n; i++) {
      string s;
      cin >> s;
      for (long long j = 1; j <= n; j++) a[i][j] = s[j - 1] == '0' ? 0 : 1;
    }
    long long cnt = (a[n][n - 1] ^ 1) + (a[n - 1][n] ^ 1) + a[n - 1][n - 1] +
                    a[n][n - 2] + a[n - 2][n];
    if (cnt <= 2) {
      cout << cnt << endl;
      check(n, n - 1, 1), check(n - 1, n, 1), check(n - 1, n - 1, 0);
      check(n - 2, n, 0), check(n, n - 2, 0);
    } else {
      cout << 5 - cnt << endl;
      check(n, n - 1, 0), check(n - 1, n, 0), check(n - 1, n - 1, 1);
      check(n - 2, n, 1), check(n, n - 2, 1);
    }
  }
  return 0;
}
