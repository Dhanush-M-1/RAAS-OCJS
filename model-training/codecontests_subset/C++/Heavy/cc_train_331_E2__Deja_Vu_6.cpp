#include <bits/stdc++.h>
using namespace std;
const int N = 55;
int n, m, Tm;
long long ans[N << 1];
struct st {
  int from, nxt, to, siz;
  vector<int> p;
} ed[N * N];
int head[N], num;
void add(int from, int to) {
  ed[++num].to = to, ed[num].from = from;
  ed[num].nxt = head[from];
  head[from] = num;
}
vector<int> E, A, S[2];
int tot_len;
bool fg;
int dfs(int x, int typ, int dep) {
  if (!fg) S[typ].push_back(x);
  if (E.size() == A.size()) {
    tot_len += dep;
    return x;
  }
  if (dep == 2 * n) return 0;
  for (int u, i = head[x]; i; i = ed[i].nxt) {
    u = ed[i].to;
    if (((i & 1) != typ) || (u != E[A.size()])) continue;
    A.push_back(u);
    for (auto v : ed[i].p) E.push_back(v);
    return dfs(u, typ, dep + 1);
  }
  return 0;
}
int dp[N][N][N << 1][2], f[N][N << 1][2];
const int mod = 1e9 + 7;
void MD(int &x) { x = (x >= mod) ? x - mod : x; }
struct St {
  int nxt, to, dis, typ;
} Ed[N * N];
int Head[N], Num;
void Add(int from, int to, int dis, int typ) {
  if (!from || !to) return;
  swap(from, to);
  Ed[++Num].to = to, Ed[Num].dis = dis, Ed[Num].typ = typ;
  Ed[Num].nxt = Head[from];
  Head[from] = Num;
}
vector<int> V0[N];
int main() {
  fg = 1;
  int u, v, k;
  scanf("%d%d", &n, &m);
  for (int x, i = 1; i <= m; i++) {
    scanf("%d%d%d", &u, &v, &k), add(u, v);
    if (!k) V0[v].push_back(u);
    while (k--) scanf("%d", &x), ed[num].p.push_back(x);
    add(v, u);
    ed[num].siz = ed[num - 1].siz = ed[num - 1].p.size();
    for (int j = ed[num - 1].siz - 1; j >= 0; j--)
      ed[num].p.push_back(ed[num - 1].p[j]);
  }
  for (int i = 1; i <= 2 * m; i += 2) {
    int flg = -1;
    for (int j = 0; j < ed[i].siz - 1; j++)
      if (ed[i].p[j] == ed[i].from && ed[i].p[j + 1] == ed[i].to) {
        flg = j;
        break;
      }
    if (!(~flg)) continue;
    E.clear(), A.clear(), S[0].clear(), S[1].clear(), tot_len = 1;
    for (int j = flg - 1; j >= 0; j--) E.push_back(ed[i].p[j]);
    int L = dfs(ed[i].from, 0, 0);
    E.clear(), A.clear();
    for (int j = flg + 2; j < ed[i].siz; j++) E.push_back(ed[i].p[j]);
    int R = dfs(ed[i].to, 1, 0);
    if (L && R && tot_len <= 2 * n) {
      if (!fg) {
        printf("%d\n", S[0].size() + S[1].size()),
            fg = 1, reverse(S[0].begin(), S[0].end());
        for (auto u : S[0]) printf("%d ", u);
        for (auto u : S[1]) printf("%d ", u);
        putchar(10);
      }
      Add(L, R, tot_len, 2);
    }
  }
  if (!fg) printf("0\n\n"), fg = 1;
  for (int x, i = 1; i <= 2 * m; i += 2)
    if (ed[i].p.size() && ed[i].p[0] == ed[i].to) {
      A.clear(), E.clear();
      for (int j = 1; j < ed[i].siz; j++) E.push_back(ed[i].p[j]);
      tot_len = 0, x = dfs(ed[i].to, 1, 1), Add(ed[i].from, x, tot_len, 1);
    }
  for (int x, i = 2; i <= 2 * m; i += 2)
    if (ed[i].p.size() && ed[i].p[0] == ed[i].to) {
      A.clear(), E.clear();
      for (int j = 1; j < ed[i].siz; j++) E.push_back(ed[i].p[j]);
      tot_len = 0, x = dfs(ed[i].to, 0, 1), Add(x, ed[i].from, tot_len, 0);
    }
  for (int i = 1; i <= n; i++) dp[i][i][0][0] = 1;
  for (int len = 1; len <= 2 * n; len++)
    for (int x = 1; x <= n; x++)
      for (int y = 1; y <= n; y++)
        for (int i = Head[y]; i; i = Ed[i].nxt) {
          if (len < Ed[i].dis) continue;
          if (Ed[i].typ == 2)
            dp[x][y][len][1] += dp[x][Ed[i].to][len - Ed[i].dis][0];
          else if (!Ed[i].typ)
            dp[x][y][len][0] += dp[x][Ed[i].to][len - Ed[i].dis][0];
          else
            dp[x][y][len][1] += dp[x][Ed[i].to][len - Ed[i].dis][1];
          MD(dp[x][y][len][0]), MD(dp[x][y][len][1]);
        }
  for (int i = 1; i <= n; i++) f[i][0][0] = 1;
  for (int len = 1; len <= 2 * n; len++)
    for (int y = 1; y <= n; y++) {
      for (auto u : V0[y]) f[y][len][0] += f[u][len - 1][1], MD(f[y][len][0]);
      for (int u = 1; u <= n; u++)
        for (int k = 1; k <= len; k++)
          f[y][len][1] += (long long)f[u][len - k][0] * dp[u][y][k][1] % mod,
              MD(f[y][len][1]);
    }
  for (int len = 1; len <= 2 * n; len++) {
    for (int i = 1; i <= n; i++) f[0][len][1] += f[i][len][1], MD(f[0][len][1]);
    printf("%d\n", f[0][len][1]);
  }
  return 0;
}
