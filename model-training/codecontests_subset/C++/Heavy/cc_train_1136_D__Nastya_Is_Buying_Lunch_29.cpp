#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const long long LINF = 0x3f3f3f3f3f3f3f3fll;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, m;
  cin >> n >> m;
  vector<int> idtP(n);
  vector<int> pIdt(n);
  for (int I = 0; I < n; I++) {
    cin >> idtP[I];
    idtP[I]--;
    pIdt[idtP[I]] = I;
  }
  vector<set<int> > volta(n);
  set<pair<int, int> > ultimoViz;
  int u, v;
  for (int I = 0; I < m; I++) {
    cin >> u >> v;
    u--;
    v--;
    volta[u].insert(v);
  }
  set<int> naoDa;
  for (int I = n - 2; I >= 0; I--) {
    if (volta[idtP[I]].find(idtP[n - 1]) == volta[idtP[I]].end()) {
      naoDa.insert(idtP[I]);
    } else {
      if (volta[idtP[I]].size() >= naoDa.size()) {
        int cont = 0;
        for (int el : volta[idtP[I]]) {
          if (naoDa.find(el) != naoDa.end()) {
            cont++;
          }
        }
        if (cont != naoDa.size()) {
          naoDa.insert(idtP[I]);
        }
      } else {
        naoDa.insert(idtP[I]);
      }
    }
  }
  cout << n - 1 - naoDa.size() << '\n';
  return 0;
}
