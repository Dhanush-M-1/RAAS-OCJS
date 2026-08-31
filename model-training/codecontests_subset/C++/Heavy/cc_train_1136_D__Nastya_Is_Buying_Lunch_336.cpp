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
  vector<set<int> > avanca(n);
  set<pair<int, int> > ultimoViz;
  int u, v;
  for (int I = 0; I < m; I++) {
    cin >> u >> v;
    u--;
    v--;
    volta[u].insert(v);
    avanca[v].insert(u);
    if (v == idtP[n - 1]) {
      ultimoViz.insert({{-pIdt[u], u}});
    }
  }
  for (pair<int, int> p : ultimoViz) {
    int el = p.second;
    while (pIdt[el] + 1 != n - 1) {
      if (volta[el].find(idtP[pIdt[el] + 1]) != volta[el].end()) {
        int el2 = idtP[pIdt[el] + 1];
        swap(idtP[pIdt[el]], idtP[pIdt[el] + 1]);
        swap(pIdt[el], pIdt[el2]);
      } else {
        break;
      }
    }
  }
  int cont = 0;
  int p = n - 2;
  while (true) {
    if (avanca[idtP[n - 1]].find(idtP[p]) != avanca[idtP[n - 1]].end()) {
      cont++;
      p--;
    } else {
      break;
    }
  }
  cout << cont << '\n';
  return 0;
}
