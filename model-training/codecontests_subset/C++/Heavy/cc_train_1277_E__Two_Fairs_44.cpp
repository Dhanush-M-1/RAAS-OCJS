#include <bits/stdc++.h>
using namespace std;
char buf[1 << 20], *_ = buf, *__ = buf;
template <class T>
inline bool read(T &x) {
  x = 0;
  char c = (_ == __ && (__ = (_ = buf) + fread(buf, 1, 1 << 20, stdin), _ == __)
                ? EOF
                : *_++);
  bool f = 0;
  while (c < 48 || c > 57) {
    if (c == EOF) return 0;
    f ^= (c == '-'),
        c = (_ == __ &&
                     (__ = (_ = buf) + fread(buf, 1, 1 << 20, stdin), _ == __)
                 ? EOF
                 : *_++);
  }
  while (47 < c && c < 58)
    x = (x << 3) + (x << 1) + (c ^ 48),
    c = (_ == __ && (__ = (_ = buf) + fread(buf, 1, 1 << 20, stdin), _ == __)
             ? EOF
             : *_++);
  if (f) x = -x;
  return 1;
}
template <class T>
inline bool read(T &a, T &b) {
  return read(a) && read(b);
}
const long long MAXN = 2e5 + 8;
vector<int> mp[MAXN];
int n, m, a, b;
int color[MAXN], vis[MAXN];
int e;
void dfs(int x, int col) {
  if (x == e) return;
  color[x] += col;
  vis[x] = col;
  for (int y : mp[x])
    if (vis[y] ^ col) dfs(y, col);
}
int main() {
  int t;
  read(t);
  while (t--) {
    read(n, m), read(a, b);
    for (int i = 0; i <= n; ++i) color[i] = 0, vis[i] = 0, mp[i].clear();
    for (int i = 0, x, y; i < m; ++i) {
      read(x, y);
      mp[x].emplace_back(y);
      mp[y].emplace_back(x);
    }
    e = b, dfs(a, 1);
    e = a, dfs(b, 2);
    long long x = 0, y = 0;
    for (int i = 1; i <= n; ++i) {
      if (color[i] == 1) x++;
      if (color[i] == 2) y++;
    }
    printf("%I64d\n", (x - 1) * (y - 1));
  }
  return 0;
}
