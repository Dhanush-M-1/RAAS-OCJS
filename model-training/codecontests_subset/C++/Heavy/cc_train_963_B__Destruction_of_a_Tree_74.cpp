#include <bits/stdc++.h>
using namespace std;
const int maxn = 1000010;
const long long mod = 1e9 + 7;
const long long INF = 100000000000000LL;
const double PI = acos(-1.0);
typedef struct EDGE {
  int v;
  int next;
} Edge;
Edge edge[maxn];
int head[maxn], cnt;
int deg[maxn];
int dp[maxn][2];
vector<int> g[200020];
int indeg[maxn];
void add(int u, int v) {
  edge[cnt].v = v;
  edge[cnt].next = head[u];
  head[u] = cnt++;
}
int dfs(int u, int fa) {
  int sum = 0;
  for (int i = head[u], v; i != -1; i = edge[i].next) {
    v = edge[i].v;
    if (v == fa) continue;
    dfs(v, u);
    sum += dp[v][0];
  }
  if ((deg[u] - sum) % 2 == 0) {
    if (fa == 0) return 1;
    dp[u][0] = 1, indeg[fa]++, g[u].push_back(fa);
  } else {
    if (fa == 0) return 0;
    dp[u][1] = 1, indeg[u]++, g[fa].push_back(u);
  }
  return 1;
}
int solve() {
  memset(dp, 0, sizeof(dp));
  memset(deg, 0, sizeof(deg));
  memset(head, -1, sizeof(head));
  memset(indeg, 0, sizeof(indeg));
  cnt = 0;
  int n;
  cin >> n;
  for (int i = 1, u, v; i <= n; i++) {
    u = i;
    scanf("%d", &v);
    if (!v) continue;
    add(u, v);
    add(v, u);
    deg[u]++;
    deg[v]++;
  }
  if (!dfs(1, 0))
    cout << "NO" << endl;
  else {
    queue<int> q;
    cout << "YES" << endl;
    for (int i = 1; i <= n; i++) {
      if (!indeg[i]) q.push(i);
    }
    while (!q.empty()) {
      int u = q.front();
      q.pop();
      cout << u << endl;
      for (int i = 0; i < g[u].size(); i++) {
        indeg[g[u][i]]--;
        if (indeg[g[u][i]] == 0) q.push(g[u][i]);
      }
    }
  }
  return 0;
}
int main() {
  long long t = 1e18;
  while (t--) {
    if (!solve()) break;
  }
  int mark_EOF;
  if (scanf("%d", &mark_EOF) == EOF) return 0;
  return 0;
}
