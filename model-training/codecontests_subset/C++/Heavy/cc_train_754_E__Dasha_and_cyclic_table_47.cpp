#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const long long infLL = 0x3f3f3f3f3f3f3f3fLL;
const int maxn = 400 + 5;
const int maxs = 4 * 400 * 400 + 5;
int n, m, r, c;
char t[maxn][maxn], p[maxn][maxn];
bitset<maxs> mask[26];
int main() {
  scanf("%d%d", &n, &m);
  for (register int i = 0; i < (n); ++i) scanf("%s", t[i]);
  scanf("%d%d", &r, &c);
  for (register int i = 0; i < (r); ++i) scanf("%s", p[i]);
  for (register int i = 0; i < (n + r); ++i)
    for (register int j = 0; j < (m + c); ++j)
      mask[t[i % n][j % m] - 'a'].set(i * (m + c) + j);
  bitset<maxs> ret;
  ret.set();
  for (register int i = 0; i < (r); ++i)
    for (register int j = 0; j < (c); ++j)
      if (p[i][j] != '?') {
        ret &= mask[p[i][j] - 'a'] >> (i * (m + c) + j);
      }
  for (register int i = 0; i < (n); ++i) {
    for (register int j = 0; j < (m); ++j)
      putchar('0' + ret.test(i * (m + c) + j));
    puts("");
  }
  return 0;
}
