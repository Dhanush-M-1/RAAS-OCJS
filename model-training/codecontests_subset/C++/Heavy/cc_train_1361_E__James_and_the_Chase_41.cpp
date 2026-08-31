#include <bits/stdc++.h>
using namespace std;
inline char ch() {
  static char s[1 << 16], *S, *T;
  return (S == T) && (T = (S = s) + fread(s, 1, 1 << 16, stdin), S == T) ? EOF
                                                                         : *S++;
}
template <typename T>
void read(T &x) {
  x = 0;
  int f(1);
  char c = ch();
  for (; !isdigit(c); c = ch())
    if (c == '-') f = -1;
  for (; isdigit(c); c = ch()) x = x * 10 + c - '0';
  x *= f;
}
template <typename T, typename... Args>
inline void read(T &x, Args &...args) {
  read(x);
  read(args...);
}
template <typename T>
void write(T x, char f = '\n') {
  if (x < 0) putchar('-'), x = -x;
  if (x > 9) write(x / 10, '\0');
  putchar('0' + x % 10);
  if (f != '\0') putchar(f);
}
const int maxn = 100003;
const int maxm = 200005;
int n, m, hd[maxn], cnt, Ok;
int tested[maxn], vis[maxn], fg[maxn];
int Cant[maxn], dep[maxn], low[maxn];
struct edge {
  int ed, nxt;
} e[maxm];
inline void star(int u, int v) {
  e[++cnt] = (edge){v, hd[u]};
  hd[u] = cnt;
}
void Dfs(int x) {
  vis[x] = 1;
  for (int i = hd[x]; i; i = e[i].nxt) {
    int y = e[i].ed;
    if (vis[y] == 2)
      return Ok = 0, void();
    else if (!vis[y])
      Dfs(y);
    if (!Ok) return;
  }
  vis[x] = 2;
}
void Dfs1(int x) {
  vis[x] = 1;
  low[x] = x;
  for (int i = hd[x]; i; i = e[i].nxt) {
    int y = e[i].ed;
    if (!vis[y]) {
      dep[y] = dep[x] + 1;
      Dfs1(y);
      fg[x] += fg[y];
      if (dep[low[y]] < dep[low[x]]) low[x] = low[y];
    } else {
      ++fg[x];
      --fg[y];
      if (dep[y] < dep[low[x]]) low[x] = y;
    }
  }
  if (fg[x] > 1) Cant[x] = 1;
}
void Dfs2(int x) {
  vis[x] = 1;
  if (low[x] == x && x != Ok) Cant[x] = 1;
  if (!Cant[x] && Cant[low[x]]) Cant[x] = 1;
  for (int i = hd[x]; i; i = e[i].nxt) {
    int y = e[i].ed;
    if (!vis[y]) Dfs2(y);
  }
}
void Calc(int x) {
  Ok = x;
  for (int i(1); i <= n; ++i) vis[i] = 0;
  Dfs1(x);
  for (int i(1); i <= n; ++i) vis[i] = 0;
  Dfs2(x);
  int Num = 0;
  for (int i(1); i <= n; ++i)
    if (!Cant[i]) ++Num;
  if (5 * Num >= n) {
    for (int i(1); i <= n; ++i)
      if (!Cant[i]) write(i, ' ');
    puts("");
  } else
    puts("-1");
}
bool Judge(int x) {
  for (int i(1); i <= n; ++i) vis[i] = 0;
  Ok = 1;
  Dfs(x);
  if (!Ok) return 0;
  for (int i(1); i <= n; ++i)
    if (!vis[i]) return 0;
  return 1;
}
void Init() {
  for (int i(1); i <= n; ++i)
    hd[i] = tested[i] = vis[i] = 0, low[i] = fg[i] = Cant[i] = dep[i] = 0;
  cnt = Ok = 0;
}
void Solve() {
  read(n, m);
  for (int i(1); i <= m; ++i) {
    int u, v;
    read(u, v);
    star(u, v);
  }
  for (int zzt(1); zzt <= 100; ++zzt) {
    int x = 1LL * rand() * rand() % n + 1;
    while (tested[x]) x = rand() % n + 1;
    if (Judge(x)) return Calc(x), Init(), void();
  }
  puts("-1");
  Init();
}
int main() {
  srand(time(0));
  int T;
  read(T);
  while (T--) Solve();
  return 0;
}
