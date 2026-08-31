#include <bits/stdc++.h>
using namespace std;
const int MXN = 1e6 + 30;
long long INF = 1ll << 60;
int N, K;
int dep[MXN], fa[MXN], f[MXN][2], dis[MXN];
std::vector<int> e[MXN];
void dfs(int u, int fu) {
  dep[u] = dep[fu] + 1;
  dis[u] = N;
  for (int v : e[u]) {
    dfs(v, u);
    dis[u] = min(dis[u], dis[v] + 1);
    if (dis[v] + 1 <= K) {
      f[u][1] += f[v][0];
    }
    f[u][1] = max(f[u][1], f[v][1] + f[u][0]);
    if (dis[v] + 1 <= K) {
      f[u][0] += f[v][0];
    }
  }
  dis[u] %= N;
  if (!dis[u]) f[u][0] = f[u][1] = 1;
}
int main() {
  scanf("%d %d", &N, &K);
  for (int i = 2; i <= N; ++i) {
    cin >> fa[i];
    e[fa[i]].push_back(i);
  }
  dfs(1, 0);
  cout << max(f[1][1], f[1][0]) << endl;
  return 0;
}
