#include <bits/stdc++.h>
using namespace std;
vector<vector<int>> E;
vector<int> G;
vector<int> h;
void dfs(int cur) {
  if (G[cur] != -1) return;
  set<int> S;
  for (int i = 0; i < (E[cur].size()); ++i) {
    int to = E[cur][i];
    dfs(to);
    S.insert(G[to]);
  }
  for (int i = 0; i < (1000000001); ++i) {
    if (!(S.count(i))) {
      G[cur] = i;
      break;
    }
  }
}
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  h.resize(n);
  for (int i = 0; i < (n); ++i) scanf("%d", &h[i]);
  E.resize(n);
  G.resize(n, -1);
  for (int i = 0; i < (m); ++i) {
    int u, v;
    scanf("%d %d", &u, &v);
    u--;
    v--;
    E[u].push_back(v);
  }
  for (int i = 0; i < (n); ++i) {
    dfs(i);
  }
  vector<int> Gs(1000, 0);
  for (int i = 0; i < (n); ++i) {
    Gs[G[i]] ^= h[i];
  }
  for (int i = 999; i >= 0; i--) {
    if (Gs[i] == 0) continue;
    int maxi = -1, ind = -1;
    for (int j = 0; j < (n); ++j) {
      if (G[j] == i) {
        if ((Gs[i] ^ h[j]) < h[j]) {
          h[j] = Gs[i] ^ h[j];
          Gs[i] = 0;
          ind = j;
          break;
        }
      }
    }
    h[ind] = Gs[i] ^ h[ind];
    Gs[i] = 0;
    for (int j = 0; j < (E[ind].size()); ++j) {
      int to = E[ind][j];
      h[to] = Gs[G[to]] ^ h[to];
      Gs[G[to]] = 0;
    }
    cout << "WIN" << endl;
    for (int j = 0; j < (n); ++j) {
      if (j != 0) printf(" ");
      printf("%d", h[j]);
    }
    cout << endl;
    return 0;
  }
  cout << "LOSE" << endl;
  return 0;
}
