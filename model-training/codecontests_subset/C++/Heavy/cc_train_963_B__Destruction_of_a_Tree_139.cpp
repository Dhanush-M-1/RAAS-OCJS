#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 20;
int n;
struct edge {
  int y, nxt;
} e[N << 1];
int lin[N], len = 1;
int cnt[N], ans[N], pos;
bool mark[N];
inline int read() {
  int s = 0, f = 1;
  char ch;
  for (; ch < '0' || ch > '9'; ch = getchar())
    if (ch == '-') f = -1;
  for (; ch >= '0' && ch <= '9'; ch = getchar())
    s = (s << 1) + (s << 3) + ch - '0';
  return s * f;
}
inline void add(int xx, int yy) {
  e[++len] = (edge){yy, lin[xx]};
  lin[xx] = len;
}
inline void dfs(int x, int fa, bool flag) {
  if (!flag) {
    for (int i = lin[x]; i; i = e[i].nxt) {
      int y = e[i].y;
      if (y == fa) continue;
      if (!mark[y]) dfs(y, x, 0);
    }
  }
  if (!(cnt[x] % 2)) {
    cnt[x] = 0;
    ans[++pos] = x;
    mark[x] = 1;
    for (int i = lin[x]; i; i = e[i].nxt) {
      int y = e[i].y;
      --cnt[y];
      if (y == fa) continue;
      if (!mark[y]) dfs(y, x, 1);
    }
  }
}
int main() {
  n = read();
  for (int i = 1; i <= n; ++i) {
    int x = read();
    if (x) {
      add(i, x);
      add(x, i);
      cnt[i]++;
      cnt[x]++;
    }
  }
  dfs(1, 0, 0);
  if (pos == n) {
    puts("YES");
    for (int i = 1; i <= n; ++i) printf("%d\n", ans[i]);
  } else
    puts("NO");
  return 0;
}
