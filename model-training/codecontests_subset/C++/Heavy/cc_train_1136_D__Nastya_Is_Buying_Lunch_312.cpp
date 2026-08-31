#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  int n, m;
  scanf("%d %d", &n, &m);
  map<int, int> M{};
  int cnt = 0;
  for (int i = 0; i < (n); i++) {
    int p;
    scanf("%d", &p);
    M[p] = cnt++;
  }
  vector<set<int>> N(n, set<int>{});
  for (int i = 0; i < (m); i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    u = M[u];
    v = M[v];
    if (u < v) {
      N[v].insert(u);
    }
  }
  vector<int> P(n);
  int p = n - 1;
  int trSum = 0;
  int res = 0;
  while (true) {
    if (p < 1) {
      break;
    }
    trSum++;
    for (int neigh : N[p]) {
      P[neigh]++;
    }
    p--;
    while (p >= 0 && P[p] == trSum) {
      res++;
      p--;
    }
  }
  printf("%d", res);
}
