#include <bits/stdc++.h>
using namespace std;
inline void read(int &n) {
  n = 0;
  char ch = getchar();
  while (ch < '0' || ch > '9') ch = getchar();
  while (ch >= '0' && ch <= '9') {
    n = (n << 3) + (n << 1) + ch - '0';
    ch = getchar();
  }
  return;
}
const int N = 2e5 + 10;
int T, n, m, x, y, a, b;
bool l[N], r[N];
vector<int> f[N];
void dfs1(int now, int no) {
  if (now == no) return;
  if (l[now]) return;
  l[now] = 1;
  for (int i = 0; i < f[now].size(); i++) dfs1(f[now][i], no);
  return;
}
void dfs2(int now, int no) {
  if (now == no) return;
  if (r[now]) return;
  r[now] = 1;
  for (int i = 0; i < f[now].size(); i++) dfs2(f[now][i], no);
  return;
}
int main() {
  read(T);
  while (T--) {
    read(n);
    read(m);
    read(a);
    read(b);
    memset(l, 0, sizeof(l));
    memset(r, 0, sizeof(r));
    for (int i = 1; i <= n; i++) f[i].clear();
    while (m--) {
      read(x);
      read(y);
      f[x].push_back(y);
      f[y].push_back(x);
    }
    dfs1(a, b);
    dfs2(b, a);
    x = y = 0;
    l[a] = r[a] = l[b] = r[b] = 0;
    for (int i = 1; i <= n; i++) {
      if (l[i] && !r[i]) x++;
      if (r[i] && !l[i]) y++;
    }
    printf("%lld\n", x * 1ll * y);
  }
  return 0;
}
