#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  scanf("%i %i", &n, &m);
  vector<vector<int> > graf(n);
  vector<int> par(n), coins(n);
  for (int i = 0; i < m; i++) {
    int u, v;
    scanf("%i %i", &u, &v);
    u--;
    v--;
    graf[max(u, v)].push_back(min(u, v));
    coins[u]++;
    coins[v]++;
  }
  vector<pair<pair<int, int>, int> > edgeSol;
  for (int i = 0; i < n; i++) {
    map<int, int> taken;
    vector<int> up, down;
    for (auto p : graf[i]) {
      taken[coins[p]] = 1;
      if (par[p])
        up.push_back(p);
      else
        down.push_back(p);
    }
    if (!taken[coins[i]]) {
      for (auto p : up) edgeSol.push_back({{p, i}, 1});
      for (auto p : down) edgeSol.push_back({{p, i}, 1});
      continue;
    }
    bool nasao = 0;
    for (int j = 1; j <= up.size(); j++) {
      if (!taken[coins[i] + j]) {
        coins[i] += j;
        for (auto p : down) edgeSol.push_back({{p, i}, 1});
        for (int k = 0; k < up.size(); k++) {
          if (k < j)
            edgeSol.push_back({{up[k], i}, 2}), par[up[k]] ^= 1;
          else
            edgeSol.push_back({{up[k], i}, 1});
        }
        nasao = 1;
        break;
      }
    }
    if (!nasao) {
      for (int j = 1; j <= down.size(); j++) {
        if (!taken[coins[i] - j]) {
          coins[i] -= j;
          for (auto p : up) edgeSol.push_back({{p, i}, 1});
          for (int k = 0; k < down.size(); k++) {
            if (k < j)
              edgeSol.push_back({{down[k], i}, 0}), par[down[k]] ^= 1;
            else
              edgeSol.push_back({{down[k], i}, 1});
          }
          nasao = 1;
          break;
        }
      }
    }
    assert(nasao);
  }
  vector<int> lst;
  for (int i = 0; i < n; i++)
    if (par[i]) lst.push_back(i);
  printf("%i ", lst.size());
  for (auto p : lst) printf("%i ", p + 1);
  printf("\n");
  for (auto p : edgeSol)
    printf("%i %i %i\n", p.first.first + 1, p.first.second + 1, p.second);
  return 0;
}
