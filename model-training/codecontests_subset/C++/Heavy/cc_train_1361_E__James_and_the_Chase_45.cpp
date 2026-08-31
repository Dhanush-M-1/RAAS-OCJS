#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5, t = 100;
int T, n, m, lim, cnt[maxn + 5], tot, dfn[maxn + 5], low[maxn + 5],
    rev[maxn + 5], is[maxn + 5];
bool fl, in[maxn + 5], vis[maxn + 5];
vector<int> G[maxn + 5];
void dfs(int u) {
  vis[u] = true, in[u] = true;
  for (int i = 0, v; i < G[u].size(); i++) {
    v = G[u][i];
    if (!vis[v])
      dfs(v);
    else
      fl &= in[v];
  }
  in[u] = false;
}
bool check(int x) {
  fl = true, fill(vis + 1, vis + n + 1, false);
  dfs(x);
  return fl;
}
void work(int u) {
  in[u] = true, dfn[u] = low[u] = ++tot, rev[tot] = u;
  for (int i = 0, v; i < G[u].size(); i++) {
    v = G[u][i];
    if (!in[v])
      work(v), low[u] = min(low[u], low[v]), cnt[u] += cnt[v];
    else
      low[u] = min(low[u], dfn[v]), cnt[u]++, cnt[v]--;
  }
  in[u] = false;
}
void solve(int u) {
  in[u] = true;
  for (int i = 0, v; i < G[u].size(); i++) {
    v = G[u][i];
    if (!in[v]) {
      is[v] = (cnt[v] == 1) & is[rev[low[v]]];
      solve(v);
    }
  }
  in[u] = false;
}
int main() {
  srand(time(0) ^ (unsigned long long)(new char));
  scanf("%d", &T);
  while (T-- > 0) {
    scanf("%d %d", &n, &m);
    lim = (n - 1) / 5 + 1;
    for (int i = (1); i <= int(n); i++) vector<int>().swap(G[i]);
    for (int i = 0, u, v; i < m; i++) {
      scanf("%d %d", &u, &v), G[u].push_back(v);
    }
    int rt = 0;
    for (int k = (1); k <= int(t); k++) {
      int x = (rand() ^ (rand() << 10)) % n + 1;
      if (check(x)) {
        rt = x;
        break;
      }
    }
    if (!rt) {
      puts("-1");
      continue;
    }
    tot = 0, fill(cnt + 1, cnt + n + 1, 0);
    work(rt), is[rt] = true, solve(rt);
    vector<int> vec;
    for (int i = (1); i <= int(n); i++)
      if (is[i]) vec.push_back(i);
    if (vec.size() > (n - 1) / 5) {
      for (int i = (0); i <= int(vec.size() - 1); i++)
        printf("%d%c", vec[i], " \n"[i == vec.size() - 1]);
    } else {
      puts("-1");
    }
  }
  return 0;
}
