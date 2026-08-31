#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 9, Q = 120, inf = 1e8 + 9;
int n, m, u, v, c, T, s[N], t[N], dp[N], sub[N], par[N], dist[N];
pair<int, int> p, a[N], bcke[N], edge[N];
vector<int> ans, g[N];
void clear() {
  ans.clear();
  for (int i = 1; i < n + 1; i++) g[i].clear(), dp[i] = 0;
}
int solve(int x) {
  for (int i = 1; i < n + 1; i++) a[i].first = dist[i], a[i].second = i;
  sort(a + 1, a + 1 + n);
  for (int i = 1; i < n + 1; i++)
    if ((sub[a[i].second] == 1 && dp[bcke[a[i].second].second]) || (i == 1))
      dp[a[i].second] = 1;
  for (int i = 1; i < n + 1; i++)
    if (dp[i]) ans.push_back(i);
  return 1;
}
bool check(int x, int fa) {
  bool ans = 1;
  sub[x] = 0, bcke[x].first = N;
  s[x] = c++, dist[x] = fa;
  for (int i = 0; i < g[x].size(); i++)
    if (s[g[x][i]] && !t[g[x][i]]) {
      p = make_pair(dist[g[x][i]], g[x][i]);
      if (p < bcke[x]) bcke[x] = p;
      sub[x]++, sub[g[x][i]]--;
    }
  for (int i = 0; i < g[x].size(); i++)
    if (!s[g[x][i]]) {
      par[g[x][i]] = x, check(g[x][i], fa + 1);
      if (bcke[g[x][i]] < bcke[x]) bcke[x] = bcke[g[x][i]];
      sub[x] += sub[g[x][i]];
    }
  t[x] = c - 1;
  if (fa == 0) {
    par[x] = 0;
    for (int i = 0; i < m; i++)
      if ((s[edge[i].first] < s[edge[i].second] ||
           t[edge[i].second] < s[edge[i].first]) &&
          (par[edge[i].second] != edge[i].first))
        ans = 0;
  }
  return ans;
}
int mv() {
  cin >> n >> m;
  clear();
  for (int i = 0; i < m; i++) {
    scanf("%d%d", &u, &v);
    ;
    edge[i].first = u, edge[i].second = v;
    g[u].push_back(v);
  }
  for (int i = 0; i < Q; i++) {
    fill(s, s + n + 1, 0);
    fill(t, t + n + 1, 0);
    u = ((1ll * rand() * 1ll * rand() + rand()) % n) + 1, c = 1;
    if (check(u, 0)) {
      solve(u);
      break;
    }
  }
  if (ans.size() < n / 5 + (n % 5 > 0))
    cout << -1 << '\n';
  else
    for (int i = 0; i < ans.size(); i++) cout << ans[i] << " ";
  cout << endl;
  ;
  return 0;
}
int main() {
  srand(time(NULL));
  for (scanf("%d", &T); T--;) mv();
}
