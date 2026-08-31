#include <bits/stdc++.h>
using namespace std;
int n, bi = 1, ans, x[200005];
vector<int> v[200005];
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int tmp;
    scanf("%d", &tmp);
    v[tmp].push_back(i);
  }
  for (int i = 2; i <= n; i++)
    if (v[i].size() >= v[bi].size()) bi = i;
  for (int i : v[bi]) x[i + 1]++;
  for (int i = 0; i < n; i++) x[i + 1] += x[i];
  set<int> s(v[bi].begin(), v[bi].end());
  for (int i = 1; i <= n; i++) {
    if (i == bi) continue;
    if (v[i].empty()) continue;
    set<int> check{0, n};
    vector<int> add;
    for (int j : v[i]) {
      check.insert(j);
      check.insert(j + 1);
      auto ia = s.lower_bound(j);
      auto ib = ia;
      for (int k = 0; k < 2; k++) {
        if (ia != s.begin()) {
          ia--;
          add.push_back(*ia);
          check.insert(*ia);
          check.insert(*ia + 1);
        }
        if (ib != s.end()) {
          add.push_back(*ib);
          check.insert(*ib);
          check.insert(*ib + 1);
          ib++;
        }
      }
      if (ia != ib) s.erase(ia, ib);
    }
    for (int j : add) s.insert(j);
    map<int, int> m;
    int at = 0;
    for (int j : check) {
      int tmp = x[j] - at;
      auto p = m.insert({tmp, j});
      if (!p.second) ans = max(ans, j - p.first->second);
      if (at != v[i].size() && v[i][at] == j) at++;
    }
  }
  printf("%d\n", ans);
}
