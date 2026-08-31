#include <bits/stdc++.h>
using namespace std;
int n, m;
vector<int> nxt[500001];
vector<int> sol;
int vis[500001], sta[500001], par[500001], h[500001];
int ok;
void DFS(int u, int he) {
  vis[u] = sta[u] = 1;
  h[u] = he;
  for (int i = 0; i < nxt[u].size(); i++) {
    int nt = nxt[u][i];
    if (!vis[nt]) {
      par[nt] = u;
      DFS(nt, he + 1);
    } else if (!sta[nt]) {
      ok = 0;
    }
  }
  sta[u] = 0;
}
int sum[500001];
int has[500001], tars[500001];
pair<int, int> DFS2(int u) {
  int cnt = 0, tar = -1;
  for (int i = 0; i < nxt[u].size(); i++) {
    int nt = nxt[u][i];
    if (par[nt] == u) {
      pair<int, int> res = DFS2(nt);
      cnt += res.first;
      if (tar == -1 || h[tar] > h[res.second]) tar = res.second;
    } else {
      cnt++;
      if (tar == -1 || h[tar] > h[nt]) tar = nt;
      sum[nt]++;
    }
  }
  cnt -= sum[u];
  if (cnt == 0) tar = -1;
  has[u] = (cnt == 1);
  tars[u] = tar;
  return make_pair(cnt, tar);
}
void DFS3(int u, int ori) {
  if (u == ori) {
    has[u] = 1;
  } else if (has[u]) {
    has[u] = has[tars[u]];
  }
  for (int i = 0; i < nxt[u].size(); i++) {
    int nt = nxt[u][i];
    if (par[nt] == u) DFS3(nt, ori);
  }
}
bool check(int u) {
  ok = 1;
  for (int i = 1; i <= n; i++) vis[i] = sta[i] = 0;
  DFS(u, 0);
  return ok;
}
void others(int u) {
  par[u] = -1;
  for (int i = 1; i <= n; i++) sum[i] = 0;
  DFS2(u);
  DFS3(u, u);
  for (int i = 1; i <= n; i++)
    if (i != u && has[i]) sol.push_back(i);
}
void solve() {
  mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
  sol.clear();
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    nxt[u].push_back(v);
  }
  int good = -1;
  if (n <= 100) {
    for (int i = 1; i <= n; i++)
      if (check(i)) {
        good = i;
        break;
      }
  } else {
    for (int i = 1; i <= 100; i++) {
      int x = (rng() % n) + 1;
      if (check(x)) {
        good = x;
        break;
      }
    }
  }
  if (good == -1) {
    puts("-1");
    for (int i = 1; i <= n; i++) nxt[i].clear();
    for (int i = 1; i <= n; i++) par[i] = -1;
    return;
  }
  sol.push_back(good);
  others(good);
  sort(sol.begin(), sol.end());
  if (sol.size() * 5 < n) {
    puts("-1");
  } else {
    for (int i = 0; i < sol.size(); i++)
      printf("%d%c", sol[i], (i + 1 == sol.size() ? '\n' : ' '));
  }
  for (int i = 1; i <= n; i++) nxt[i].clear();
  for (int i = 1; i <= n; i++) par[i] = -1;
}
int main() {
  int t;
  scanf("%d", &t);
  while (t--) solve();
}
