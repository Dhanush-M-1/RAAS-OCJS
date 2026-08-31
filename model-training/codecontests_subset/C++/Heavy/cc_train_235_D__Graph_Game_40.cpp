#include <bits/stdc++.h>
using namespace std;
int n;
vector<int> depc[3300];
vector<int> adj[3300];
int dep[3300], pos[3300], fa[3300], subsz[3300];
vector<int> st, cycle;
double comprob(int cycleA, int cycleB, int tree1, int tree2) {
  return 2.0 / (cycleA + tree1 + tree2 + 1) +
         2.0 / (cycleB + tree1 + tree2 + 1) -
         2.0 / (cycleA + cycleB + tree1 + tree2);
}
double simprob(int dist) { return 2.0 / (dist + 1); }
bool findcycle(int x, int d) {
  assert(d == st.size());
  if (dep[x] >= 0) {
    if (dep[x] == d - 2) return 0;
    for (int i = dep[x]; i < d; i++) cycle.push_back(st[i]);
    return 1;
  }
  dep[x] = d;
  st.push_back(x);
  for (int i = 0; i < adj[x].size(); i++)
    if (findcycle(adj[x][i], d + 1)) return 1;
  st.pop_back();
  dep[x] = -2;
  return 0;
}
void buildtree(int x) {
  subsz[x] = 1;
  for (int i = 0; i < adj[x].size(); i++)
    if (adj[x][i] != fa[x] && pos[adj[x][i]] < 0) {
      fa[adj[x][i]] = x;
      buildtree(adj[x][i]);
      subsz[x] += subsz[adj[x][i]];
    }
}
double answertree(int x) {
  double res = 0;
  int maxdep = 0;
  for (int i = 0; i < adj[x].size(); i++) {
    if (adj[x][i] != fa[x] && pos[adj[x][i]] < 0) {
      res += answertree(adj[x][i]);
      maxdep = max(maxdep, (int)depc[adj[x][i]].size());
    }
  }
  depc[x].resize(maxdep + 1);
  depc[x][0]++;
  for (int i = 0; i < adj[x].size(); i++)
    if (adj[x][i] != fa[x] && pos[adj[x][i]] < 0) {
      for (int oldd = 1; oldd <= depc[adj[x][i]].size(); oldd++)
        for (int newd = 0; newd <= maxdep; newd++)
          res +=
              simprob(oldd + newd) * depc[x][newd] * depc[adj[x][i]][oldd - 1];
      for (int oldd = 1; oldd <= depc[adj[x][i]].size(); oldd++)
        depc[x][oldd] += depc[adj[x][i]][oldd - 1];
      depc[adj[x][i]].clear();
    }
  return res;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    int u, v;
    cin >> u >> v;
    adj[u].push_back(v);
    adj[v].push_back(u);
  }
  memset(dep, -1, sizeof(dep));
  memset(pos, -1, sizeof(pos));
  memset(fa, -1, sizeof(fa));
  findcycle(0, 0);
  for (int i = 0; i < cycle.size(); i++) pos[cycle[i]] = i;
  for (int i = 0; i < cycle.size(); i++) buildtree(cycle[i]);
  double res = n;
  for (int i = 0; i < cycle.size(); i++) res += answertree(cycle[i]);
  for (int i = 0; i < cycle.size(); i++)
    for (int j = i + 1; j < cycle.size(); j++) {
      for (int di = 0; di < depc[cycle[i]].size(); di++)
        for (int dj = 0; dj < depc[cycle[j]].size(); dj++)
          res += comprob(j - i, cycle.size() - j + i, di, dj) *
                 depc[cycle[i]][di] * depc[cycle[j]][dj];
    }
  printf("%.8lf\n", res);
  return 0;
}
