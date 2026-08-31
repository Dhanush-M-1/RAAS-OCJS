#include <bits/stdc++.h>
using namespace std;
const int inf = 2e9;
const long double eps = 0.00000000001;
int n, m;
vector<int> E[300000];
int tab[300000];
int vis[300000];
int levelId[300000];
int levelXor[300000];
void dfs(int a) {
  vis[a] = true;
  vector<int> L;
  for (int v : E[a]) {
    if (!vis[v]) {
      dfs(v);
    }
    L.push_back(levelId[v]);
  }
  L.push_back(inf);
  sort(L.begin(), L.end());
  L.resize(unique(L.begin(), L.end()) - L.begin());
  int level = 0;
  while (level == L[level]) {
    level++;
  }
  levelId[a] = level;
  levelXor[level] ^= tab[a];
}
void countMove(int level) {
  int high = 0;
  for (int i = 0; i <= 30; i++) {
    if (((1 << i) & levelXor[level]) != 0) {
      high = i;
    }
  }
  int a = -1;
  for (int i = 1; i <= n; i++) {
    if (levelId[i] == level) {
      if (((1 << high) & tab[i]) != 0) {
        a = i;
      }
    }
  }
  tab[a] ^= levelXor[level];
  levelXor[level] = 0;
  for (int v : E[a]) {
    if (levelXor[levelId[v]] != 0) {
      tab[v] ^= levelXor[levelId[v]];
      levelXor[levelId[v]] = 0;
    }
  }
}
void solve() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> tab[i];
  }
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    E[u].push_back(v);
  }
  for (int i = 1; i <= n; i++) {
    if (!vis[i]) {
      dfs(i);
    }
  }
  int level = -1;
  for (int i = 0; i <= n; i++) {
    if (levelXor[i] != 0) {
      level = i;
    }
  }
  if (level == -1) {
    cout << "LOSE"
         << "\n";
    return;
  }
  countMove(level);
  cout << "WIN"
       << "\n";
  for (int i = 1; i <= n; i++) {
    cout << tab[i] << " ";
  }
  cout << "\n";
}
void clear() {}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout << fixed << setprecision(10);
  int z = 1;
  for (int i = 0; i < z; i++) {
    solve();
    clear();
  }
}
