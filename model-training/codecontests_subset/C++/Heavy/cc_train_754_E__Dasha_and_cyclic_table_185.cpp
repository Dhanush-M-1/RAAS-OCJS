#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
const int maxn = 800 + 50;
int n, m, R, C;
char s[maxn][maxn], f[maxn][maxn], sw[405][405][405];
bitset<400> g[26];
int main(int argc, char* argv[]) {
  n = read(), m = read();
  for (int i = 0; i < n; ++i) scanf("%s", s + i);
  R = read(), C = read();
  for (int i = 0; i < R; ++i) scanf("%s", f + i);
  for (int i = 0; i < n; ++i)
    for (int j = 0, cur = 0; j < m + C; ++j, ++cur) {
      if (cur == m) cur = 0;
      s[i][j] = s[i][cur];
    }
  for (int iv = 0; iv < R; ++iv) {
    char* seq = f[iv];
    bitset<400> swf;
    for (int i = 0; i < 26; ++i) {
      g[i].reset();
      for (int j = 0; j < C; ++j)
        if (seq[j] == '?' || seq[j] - 'a' == i) g[i][j] = 1;
    }
    for (int i = 0; i < n; ++i) {
      swf.reset();
      for (int j = 0; j < m + C; ++j) {
        swf <<= 1;
        swf[0] = 1;
        swf &= g[s[i][j] - 'a'];
        if (swf[C - 1]) sw[i][j - C + 1][iv] = 1;
      }
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      int ok = 1;
      for (int k = 0, cur = i; k < R; ++k, ++cur) {
        if (cur == n) cur = 0;
        ok &= sw[cur][j][k];
      }
      if (ok)
        putchar('1');
      else
        putchar('0');
    }
    puts("");
  }
  return 0;
}
