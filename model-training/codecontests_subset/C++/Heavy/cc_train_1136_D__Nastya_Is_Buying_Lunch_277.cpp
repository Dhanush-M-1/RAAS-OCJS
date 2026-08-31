#include <bits/stdc++.h>
using namespace std;
vector<set<int> > g;
int main() {
  int n, m;
  cin >> n >> m;
  vector<int> p(n);
  g.resize(n);
  vector<int> seq(n);
  vector<int> ind(n);
  for (int i = 0; i < n; i++) {
    cin >> p[i];
    p[i]--;
    ind[p[i]] = i;
  }
  for (int i = 0; i < m; i++) {
    int from, to;
    cin >> from >> to;
    from--;
    to--;
    if (ind[to] > ind[from]) g[from].insert(to);
  }
  vector<bool> P(n);
  P[p[n - 1]] = true;
  int psz = 0;
  psz++;
  for (int suf = 1; suf < n; suf++) {
    int count = 0;
    while (!g[p[n - suf - 1]].empty()) {
      int to = *g[p[n - suf - 1]].begin();
      g[p[n - 1 - suf]].erase(g[p[n - 1 - suf]].begin());
      if (P[to]) count++;
    }
    if (count < psz) {
      P[p[n - suf - 1]] = true;
      psz++;
    }
  }
  cout << n - psz;
  return 0;
}
