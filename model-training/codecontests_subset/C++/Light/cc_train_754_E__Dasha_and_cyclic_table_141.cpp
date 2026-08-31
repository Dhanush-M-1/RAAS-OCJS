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
    x = x * 10 + (ch ^ 48);
    ch = getchar();
  }
  return x * f;
}
const int N = 410;
int n, m, r, c;
bitset<N * N << 2> vis[30], ok;
char s[N][N], t[N][N];
int main() {
  ok.set();
  n = read();
  m = read();
  for (int i = 0; i < n; ++i) scanf("%s", s[i]);
  r = read();
  c = read();
  for (int i = 0; i < r; ++i) scanf("%s", t[i]);
  for (int i = 0; i < n + r; ++i) {
    for (int j = 0; j < m + c; ++j) {
      char ch = s[i % n][j % m];
      vis[ch - 'a'][i * (m + c) + j] = 1;
    }
  }
  for (int i = 0; i < r; ++i) {
    for (int j = 0; j < c; ++j) {
      if (t[i][j] != '?') ok &= (vis[t[i][j] - 'a'] >> (i * (m + c) + j));
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      printf("%d", ok[i * (m + c) + j] ? 1 : 0);
    }
    printf("\n");
  }
  return 0;
}
