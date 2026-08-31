#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 5;
int vecinos[MAXN];
int prof[MAXN];
int n;
set<int> arbol[MAXN];
void dfs(int i, int p, int profund) {
  prof[i] = profund;
  for (int h : arbol[i]) {
    if (h == p) continue;
    dfs(h, i, profund + 1);
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  int raiz;
  for (int i = (0); i < (n); i++) {
    int p;
    cin >> p;
    p--;
    if (p != -1) {
      arbol[p].insert(i);
      vecinos[p]++;
      arbol[i].insert(p);
      vecinos[i]++;
    } else {
      raiz = i;
    }
  }
  dfs(raiz, -1, 0);
  set<pair<int, int> > q;
  for (int i = (0); i < (n); i++) {
    if (vecinos[i] % 2 == 0) {
      q.insert({-prof[i], i});
    }
  }
  vector<int> eliminados;
  while (!q.empty()) {
    auto actual = *q.begin();
    q.erase(q.begin());
    int act = actual.second;
    if (vecinos[act] % 2) continue;
    for (int h : arbol[act]) {
      vecinos[h]--;
      arbol[h].erase(arbol[h].find(act));
      if (vecinos[h] % 2 == 0) {
        q.insert({-prof[h], h});
      }
    }
    arbol[act].clear();
    eliminados.push_back(act);
  }
  if ((int)(eliminados).size() != n) {
    cout << "NO\n";
  } else {
    cout << "YES\n";
    for (int e : eliminados) {
      cout << e + 1 << "\n";
    }
  }
}
