#include <bits/stdc++.h>
using namespace std;
constexpr int maxn = 1e5 + 100;
struct IO {
 private:
  static constexpr int ibufsiz = 1 << 20;
  char ibuf[ibufsiz + 1], *inow = ibuf, *ied = ibuf;
  static constexpr int obufsiz = 1 << 20;
  char obuf[obufsiz + 1], *onow = obuf;
  const char *oed = obuf + obufsiz;

 public:
  char getchar() {
    if (inow == ied) {
      ied = ibuf + sizeof(char) * fread(ibuf, sizeof(char), ibufsiz, stdin);
      *ied = '\0';
      inow = ibuf;
    }
    return *inow++;
  }
  template <typename T>
  void read(T &x) {
    static bool flg;
    flg = 0;
    x = 0;
    char c = getchar();
    while (!isdigit(c)) flg = c == '-' ? 1 : flg, c = getchar();
    while (isdigit(c)) x = x * 10 + c - '0', c = getchar();
    if (flg) x = -x;
  }
  template <typename T, typename... Y>
  void read(T &x, Y &...X) {
    read(x);
    read(X...);
  }
  int readi() {
    static int res;
    read(res);
    return res;
  }
  long long readll() {
    static long long res;
    read(res);
    return res;
  }
  void flush() {
    fwrite(obuf, sizeof(char), onow - obuf, stdout);
    fflush(stdout);
    onow = obuf;
  }
  void putchar(const char c) {
    *onow++ = c;
    if (onow == oed) {
      fwrite(obuf, sizeof(char), obufsiz, stdout);
      onow = obuf;
    }
  }
  template <typename T>
  void write(T x, const char split = '\0') {
    static unsigned char buf[32];
    if (x < 0) putchar('-'), x = -x;
    int p = 0;
    do {
      buf[++p] = x % 10;
      x /= 10;
    } while (x);
    for (int i = p; i >= 1; i--) putchar(buf[i] + '0');
    if (split != '\0') putchar(split);
  }
  void puts(char const *str, const char split = '\n') {
    while (*str) putchar(*(str++));
    putchar(split);
  }
  void lf() { putchar('\n'); }
  ~IO() { fwrite(obuf, sizeof(char), onow - obuf, stdout); }
} io;
mt19937 rnd(19260817);
vector<int> G[maxn], ans;
void addedge(const int u, const int v) { G[u].push_back(v); }
int n, m, flg, vis[maxn], instk[maxn];
void dfs1(const int u) {
  instk[u] = 1;
  vis[u] = 1;
  for (int v : G[u]) {
    if (!vis[v])
      dfs1(v);
    else if (!instk[v]) {
      flg = 1;
      break;
    }
  }
  instk[u] = 0;
}
bool chk(const int x) {
  flg = 0;
  for (int i = 1; i <= n; i++) vis[i] = 0;
  dfs1(x);
  return !flg;
}
int ok[maxn], delta[maxn], dep[maxn];
void dfs2(const int u) {
  vis[u] = 1;
  for (int v : G[u]) {
    if (!vis[v])
      dep[v] = dep[u] + 1, dfs2(v);
    else {
      delta[u]++;
      delta[v]--;
    }
  }
}
int ret[maxn];
void dfs3(const int u) {
  vis[u] = 1;
  for (int v : G[u]) {
    if (!vis[v]) {
      dfs3(v);
      assert(ret[v]);
      if (dep[ret[v]] < dep[ret[u]]) ret[u] = ret[v];
      delta[u] += delta[v];
    } else if (dep[v] < dep[ret[u]])
      ret[u] = v;
  }
}
void dfs4(const int u) {
  vis[u] = 1;
  if (delta[u] == 1 && ok[ret[u]]) ok[u] = 1;
  for (int v : G[u]) {
    if (!vis[v]) dfs4(v);
  }
}
void solve(const int rt) {
  for (int i = 1; i <= n; i++) ok[i] = vis[i] = delta[i] = ret[i] = 0;
  ok[rt] = 1;
  dep[0] = 114514;
  dfs2(rt);
  for (int i = 1; i <= n; i++) vis[i] = 0;
  dfs3(rt);
  for (int i = 1; i <= n; i++) vis[i] = 0;
  dfs4(rt);
  for (int i = 1; i <= n; i++)
    if (ok[i]) ans.push_back(i);
}
void solve() {
  for (int i = 1; i <= n; i++) G[i].clear();
  ans.clear();
  io.read(n, m);
  for (int u, v, i = 1; i <= m; i++) io.read(u, v), addedge(u, v);
  uniform_int_distribution<int> gen(1, n);
  int rt = -1;
  for (int i = 1; i <= 100; i++) {
    const int x = gen(rnd);
    if (chk(x)) {
      rt = x;
      break;
    }
  }
  if (rt == -1) return (void)io.puts("-1");
  solve(rt);
  if (ans.size() * 5 < n) return (void)io.puts("-1");
  for (int x : ans) io.write(x, ' ');
  io.lf();
}
int main() {
  int t = io.readi();
  while (t--) solve();
  return 0;
}
