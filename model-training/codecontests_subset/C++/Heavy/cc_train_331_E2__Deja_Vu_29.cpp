#include <bits/stdc++.h>
using namespace std;
const int N = 105, mod = 1e9 + 7;
int n, m;
int head[N], ce, f[N][N][2], ok[N][N], ans[N];
bool flag;
struct edge {
  int fr, to, nxt;
  vector<int> w;
} e[N * N];
vector<int> pot, lans, rans, G[N][N];
struct point {
  int p, v, q, len;
};
vector<point> trans[N];
bool stretch(int u, deque<int> need, int o) {
  while (need.size()) {
    int x = need.front();
    need.pop_front();
    o ? rans.push_back(x) : lans.push_back(x);
    if ((int)rans.size() > 2 * n + 1 || (int)lans.size() > 2 * n + 1) return 0;
    if ((o && !ok[u][x]) || (!o && !ok[x][u])) return 0;
    if (o)
      for (auto v : G[u][x]) need.push_back(v);
    else
      for (int j = (int)G[x][u].size() - 1; ~j; --j) need.push_back(G[x][u][j]);
    u = x;
  }
  return 1;
}
void print() {
  flag = 1;
  printf("%d\n", (int)lans.size() + (int)rans.size());
  for (int i = (int)lans.size() - 1; i >= 0; --i) printf("%d ", lans[i]);
  for (int i = 0; i < rans.size(); ++i) printf("%d ", rans[i]);
  puts("");
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1, u, v, K, x; i <= m; ++i) {
    scanf("%d%d%d", &u, &v, &K);
    pot.clear();
    for (int j = 1; j <= K; ++j) scanf("%d", &x), pot.push_back(x);
    e[++ce] = (edge){u, v, head[u], pot}, head[u] = ce, G[u][v] = pot,
    ok[u][v] = 1;
  }
  for (int i = 1; i <= m; ++i) {
    deque<int> ql, qr;
    bool fl;
    for (int j = 0; j < (int)e[i].w.size() - 1; ++j)
      if (e[i].w[j] == e[i].fr && e[i].w[j + 1] == e[i].to) {
        ql.clear(), lans.clear(), qr.clear(), rans.clear();
        for (int k = 0; k < j; ++k) ql.push_front(e[i].w[k]);
        lans.push_back(e[i].fr), fl = stretch(e[i].fr, ql, 0);
        for (int k = (int)e[i].w.size() - 1; k > j + 1; --k)
          qr.push_front(e[i].w[k]);
        rans.push_back(e[i].to), fl &= stretch(e[i].to, qr, 1);
        if (fl) {
          trans[lans.back()].push_back((point){
              1, rans.back(), 0, (int)lans.size() + (int)rans.size() - 1});
        }
        break;
      }
    if (!e[i].w.size()) trans[e[i].fr].push_back((point){0, e[i].to, 1, 1});
    if (e[i].w.size() && e[i].w[0] == e[i].to) {
      qr.clear(), rans.clear(), rans.push_back(e[i].to);
      for (int j = 1; j < e[i].w.size(); ++j) qr.push_back(e[i].w[j]);
      fl = stretch(e[i].to, qr, 1);
      if (fl)
        trans[e[i].fr].push_back((point){0, rans.back(), 0, (int)rans.size()});
    }
    if (e[i].w.size() && e[i].w.back() == e[i].fr) {
      ql.clear(), lans.clear(), lans.push_back(e[i].fr);
      for (int j = 0; j < (int)e[i].w.size() - 1; ++j) ql.push_front(e[i].w[j]);
      fl = stretch(e[i].fr, ql, 0);
      if (fl)
        trans[lans.back()].push_back((point){1, e[i].to, 1, (int)lans.size()});
    }
  }
  for (int i = 0; i <= n; ++i) f[0][i][1] = 1;
  for (int i = 0; i < 2 * n; ++i) {
    for (int j = 1; j <= n; ++j)
      for (auto T : trans[j])
        if (i + T.len <= 2 * n)
          f[i + T.len][T.v][T.q] =
              (f[i + T.len][T.v][T.q] + f[i][j][T.p]) % mod;
  }
  for (int i = 1; i <= 2 * n; ++i) {
    for (int j = 1; j <= n; ++j) ans[i] = (ans[i] + f[i][j][0]) % mod;
    printf("%d\n", ans[i]);
  }
  return 0;
}
