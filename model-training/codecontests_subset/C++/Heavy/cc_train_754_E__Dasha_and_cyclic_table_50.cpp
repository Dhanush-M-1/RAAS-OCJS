#include <bits/stdc++.h>
using int64 = long long;
using uchar = unsigned char;
constexpr int maxn(400);
constexpr int sigma(26);
inline int io() {
  static int _;
  return scanf("%d", &_), _;
}
std::bitset<maxn> ans[maxn], pos[sigma][maxn];
char s[maxn][maxn], t[maxn][maxn], buf[maxn * (maxn + 1) + 1];
int main() {
  const int n(io()), m(io());
  for (int i = 0; i != n; ++i) scanf("\n"), fread(s[i], 1, m, stdin);
  const int r(io()), c(io());
  for (int i = 0; i != r; ++i) scanf("\n"), fread(t[i], 1, c, stdin);
  for (int i = 0; i != n; ++i) ans[i].set();
  for (int i = 0; i != n; ++i)
    for (int j = 0; j != m; ++j) pos[s[i][j] - 'a'][i][j] = 1;
  for (int j = 0; j != c; ++j) {
    for (int i = 0; i != r; ++i)
      if (t[i][j] != '?') {
        const int cc = t[i][j] - 'a';
        for (int k = 0, ii = i % n; k != n; ++k, (++ii == n) && (ii = 0))
          ans[k] &= pos[cc][ii];
      }
    for (int k = 0; k != sigma; ++k)
      for (int i = 0; i != n; ++i)
        if (pos[k][i][0])
          pos[k][i] >>= 1, pos[k][i][m - 1] = 1;
        else
          pos[k][i] >>= 1;
  }
  char* pa(buf);
  for (int i = 0; i != n; ++i, *++pa = '\n')
    for (int j = 0; j != m; ++j) *++pa = '0' + ans[i][j];
  fwrite(buf + 1, 1, pa - buf, stdout);
  return 0;
}
