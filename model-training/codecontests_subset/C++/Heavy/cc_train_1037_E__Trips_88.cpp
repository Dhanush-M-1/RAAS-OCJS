#include <bits/stdc++.h>
using namespace std;
const int MAXN = 200100;
int n, m, k;
vector<pair<int, int> > veze;
vector<pair<int, int> > graf[MAXN];
void load() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 0; i < m; i++) {
    int a, b;
    scanf("%d%d", &a, &b);
    a--;
    b--;
    veze.push_back(pair<int, int>(a, b));
    graf[a].push_back(pair<int, int>(b, i));
    graf[b].push_back(pair<int, int>(a, i));
  }
}
int deg[MAXN];
set<pair<int, int> > S;
void printSet() {
  for (auto it = S.begin(); it != S.end(); it++) {
    printf("%d : %d\n", it->second, it->first);
  }
  printf("\n");
}
void solve() {
  for (int i = 0; i < m; i++) {
    deg[veze[i].first]++;
    deg[veze[i].second]++;
  }
  for (int i = 0; i < n; i++) S.insert(pair<int, int>(deg[i], i));
  while (!S.empty() && S.begin()->first < k) {
    int v = S.begin()->second;
    S.erase(pair<int, int>(deg[v], v));
    for (pair<int, int> p : graf[v]) {
      int u = p.first;
      if (S.find(pair<int, int>(deg[u], u)) == S.end()) continue;
      S.erase(pair<int, int>(deg[u], u));
      deg[u]--;
      S.insert(pair<int, int>(deg[u], u));
    }
  }
  vector<int> sol;
  for (int i = m - 1; i >= 0; i--) {
    sol.push_back(S.size());
    int a = veze[i].first;
    int b = veze[i].second;
    if (S.find(pair<int, int>(deg[a], a)) != S.end() &&
        S.find(pair<int, int>(deg[b], b)) != S.end()) {
      S.erase(pair<int, int>(deg[a], a));
      S.erase(pair<int, int>(deg[b], b));
      deg[a]--;
      deg[b]--;
      S.insert(pair<int, int>(deg[a], a));
      S.insert(pair<int, int>(deg[b], b));
      while (!S.empty() && S.begin()->first < k) {
        int v = S.begin()->second;
        S.erase(pair<int, int>(deg[v], v));
        for (pair<int, int> p : graf[v]) {
          if (p.second >= i) continue;
          int u = p.first;
          if (S.find(pair<int, int>(deg[u], u)) == S.end()) continue;
          S.erase(pair<int, int>(deg[u], u));
          deg[u]--;
          S.insert(pair<int, int>(deg[u], u));
        }
      }
    }
  }
  for (int i = m - 1; i >= 0; i--) printf("%d\n", sol[i]);
}
int main() {
  load();
  solve();
  return 0;
}
