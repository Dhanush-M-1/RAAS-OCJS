#include <bits/stdc++.h>
using namespace std;
int n, ans, i, j, n_4, a;
bool m[2][5300];
char c;
inline int gcd(int a, int b) {
  while (a) {
    a ^= b ^= a ^= b %= a;
  }
  return b;
}
int main() {
  scanf("%d", &n);
  ans = n;
  n_4 = n / 4;
  for (i = 0; i < n; ++i) {
    for (j = 0; j < n; j += 4) {
      while (((c = getchar()) > '9' || c < '0') && (c < 'A' || c > 'F'))
        ;
      if ('0' <= c && '9' >= c)
        a = c - '0';
      else
        a = c - 'A' + 10;
      m[i & 1][j] = a >> 3;
      m[i & 1][j + 1] = a >> 2 & 1;
      m[i & 1][j + 2] = a >> 1 & 1;
      m[i & 1][j + 3] = a & 1;
      if (i != 0 && (m[i & 1][j] != m[!(i & 1)][j] ||
                     m[i & 1][j + 1] != m[!(i & 1)][j + 1] ||
                     m[i & 1][j + 2] != m[!(i & 1)][j + 2] ||
                     m[i & 1][j + 3] != m[!(i & 1)][j + 3]))
        ans = gcd(ans, i);
      if (m[i & 1][j] != m[i & 1][j - 1]) ans = gcd(ans, j);
      if ((a & 12) % 3) ans = gcd(ans, j + 1);
      if ((a & 6) % 3) ans = gcd(ans, j + 2);
      if ((a & 3) % 3) ans = gcd(ans, j + 3);
    }
    if (ans == 1) break;
  }
  printf("%d", ans);
}
