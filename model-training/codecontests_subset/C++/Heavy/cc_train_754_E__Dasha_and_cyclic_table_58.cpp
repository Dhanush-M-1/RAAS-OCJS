#include <bits/stdc++.h>
#pragma GCC optimize(3)
using namespace std;
bool Finish_read;
template <class T>
inline void read(T &x) {
  Finish_read = 0;
  x = 0;
  int f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    if (ch == EOF) return;
    ch = getchar();
  }
  while (isdigit(ch)) x = x * 10 + ch - '0', ch = getchar();
  x *= f;
  Finish_read = 1;
}
template <class T>
inline void print(T x) {
  if (x / 10 != 0) print(x / 10);
  putchar(x % 10 + '0');
}
template <class T>
inline void writeln(T x) {
  if (x < 0) putchar('-');
  x = abs(x);
  print(x);
  putchar('\n');
}
template <class T>
inline void write(T x) {
  if (x < 0) putchar('-');
  x = abs(x);
  print(x);
}
const int maxn = 405, alphabet = 26;
bitset<maxn> vis[alphabet][maxn], ans[maxn];
int n, m, r, c;
char now[maxn];
inline int fix(int p, int mod) {
  while (p < 0) p += mod;
  while (p >= mod) p -= mod;
  return p;
}
int main() {
  read(n), read(m);
  for (int i = 0; i < n; ++i) {
    scanf("%s", now);
    for (int j = 0; j < m; ++j) vis[now[j] - 'a'][i][j] = 1;
  }
  for (int i = 0; i < n; ++i) ans[i].set();
  read(r), read(c);
  for (int i = 0; i < r; ++i) {
    scanf("%s", now);
    for (int j = 0; j < c; ++j) {
      if (now[j] == '?') continue;
      int p = now[j] - 'a', plsx = fix(-i, n), plsy = fix(-j, m);
      for (int k = 0; k < n; ++k) {
        int px = k + plsx;
        if (px >= n) px -= n;
        ans[px] &= (vis[p][k] >> (m - plsy)) | (vis[p][k] << plsy);
      }
    }
  }
  for (int i = 0; i < n; ++i, puts(""))
    for (int j = 0; j < m; ++j) printf("%d", ans[i][j] ? 1 : 0);
  return 0;
}
