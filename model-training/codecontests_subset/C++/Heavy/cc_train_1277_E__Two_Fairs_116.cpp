#include <bits/stdc++.h>
using namespace std;
int t, n, m, a, b;
set<int> ss1, ss2;
const int N = 2e5 + 1;
vector<int> e[N];
int c[N];
void dfs(int p, int cc) {
  c[p] = cc;
  for (auto v : e[p]) {
    if (c[v] != 0) continue;
    if (v == a || v == b) continue;
    dfs(v, cc);
  }
  return;
}
int main() {
  std::ios::sync_with_stdio(0);
  std::cin.tie(0);
  while (cin >> t) {
    while (t--) {
      cin >> n >> m >> a >> b;
      for (int i = (1); i < (n + 1); i++) {
        e[i].clear();
        c[i] = 0;
      }
      for (int i = (1); i < (m + 1); i++) {
        int x, y;
        cin >> x >> y;
        e[x].push_back(y);
        e[y].push_back(x);
      }
      for (int i = (1); i < (n + 1); i++)
        if (c[i] == 0 && i != a && i != b) dfs(i, i);
      ss1.clear();
      ss2.clear();
      for (auto v : e[a]) ss1.insert(c[v]);
      for (auto v : e[b]) ss2.insert(c[v]);
      long long c1, c2;
      c1 = c2 = 0;
      for (int i = (1); i < (n + 1); i++) {
        if (ss1.find(c[i]) != ss1.end() && ss2.find(c[i]) == ss2.end()) c1++;
        if (ss1.find(c[i]) == ss1.end() && ss2.find(c[i]) != ss2.end()) c2++;
      }
      cout << c1 * c2 << '\n';
    }
  }
  return 0;
}
