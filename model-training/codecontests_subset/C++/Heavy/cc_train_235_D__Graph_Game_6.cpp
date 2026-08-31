#include <bits/stdc++.h>
using namespace std;
using LL = long long;
namespace _buff {
const size_t BUFF = 1 << 19;
char ibuf[BUFF], *ib = ibuf, *ie = ibuf;
char getc() {
  if (ib == ie) {
    ib = ibuf;
    ie = ibuf + fread(ibuf, 1, BUFF, stdin);
  }
  return ib == ie ? -1 : *ib++;
}
}  // namespace _buff
LL read() {
  using namespace _buff;
  LL ret = 0;
  bool pos = true;
  char c = getc();
  for (; (c < '0' || c > '9') && c != '-'; c = getc()) {
    assert(~c);
  }
  if (c == '-') {
    pos = false;
    c = getc();
  }
  for (; c >= '0' && c <= '9'; c = getc()) {
    ret = (ret << 3) + (ret << 1) + (c ^ 48);
  }
  return pos ? ret : -ret;
}
const size_t N = 3e3 + 5;
double ans;
int a[N], b[N];
vector<int> g[N], gg[N], sub[N], cyc;
bool vis[N], oncyc[N];
int par[N], dep[N];
void dfs1(int u = 1, int p = 0, int pe = -1) {
  vis[u] = true;
  par[u] = p;
  for (int i : gg[u]) {
    if (i == pe) continue;
    int v = a[i] ^ b[i] ^ u;
    if (vis[v]) {
      if (cyc.empty()) {
        for (int x = u;; x = par[x]) {
          cyc.emplace_back(x);
          oncyc[x] = true;
          if (x == v) break;
        }
      }
    } else {
      dfs1(v, u, i);
    }
  }
}
void dfs2(int rt, int u, int p = 0, int d = 0) {
  sub[par[u] = rt].emplace_back(u);
  dep[u] = d;
  for (int v : g[u]) {
    if (v != p && !oncyc[v]) {
      dfs2(rt, v, u, d + 1);
    }
  }
}
void bfs(int s) {
  static int dis[N];
  memset(dis, -1, sizeof dis);
  queue<int> que;
  que.emplace(s);
  dis[s] = 1;
  while (!que.empty()) {
    int u = que.front();
    que.pop();
    ans += 1. / dis[u];
    for (int v : g[u]) {
      if (!~dis[v] && par[u] == par[v]) {
        dis[v] = dis[u] + 1;
        que.emplace(v);
      }
    }
  }
}
int main() {
  int n = read();
  for (int i = 0; i < n; ++i) {
    int u = a[i] = read() + 1, v = b[i] = read() + 1;
    g[u].emplace_back(v);
    g[v].emplace_back(u);
    gg[u].emplace_back(i);
    gg[v].emplace_back(i);
  }
  dfs1();
  for (int u : cyc) {
    dfs2(u, u);
  }
  for (unsigned i = 0; i < cyc.size(); ++i) {
    for (unsigned j = 0; j < i; ++j) {
      int l1 = i - j + 1, l2 = cyc.size() + 2 - l1;
      for (int u : sub[cyc[i]]) {
        for (int v : sub[cyc[j]]) {
          ans += ((double)(cyc.size() - l1) / (l1 + dep[u] + dep[v]) +
                  (double)(cyc.size() - l2) / (l2 + dep[u] + dep[v]) + 1) /
                 (cyc.size() + dep[u] + dep[v]);
        }
      }
    }
  }
  ans *= 2;
  for (int i = 1; i <= n; ++i) {
    bfs(i);
  }
  printf("%.19f", ans);
  return 0;
}
