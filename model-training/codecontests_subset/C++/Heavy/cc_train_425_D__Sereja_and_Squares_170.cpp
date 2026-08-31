#include <bits/stdc++.h>
#pragma GCC optimize("Ofast,no-stack-protector")
#pragma GCC target("avx")
using namespace std;
const int MAX_N = 100000 + 7;
unordered_set<long long> bst;
vector<int> rx[MAX_N], ry[MAX_N];
int main() {
  int n;
  scanf("%d", &n);
  vector<pair<int, int> > ps;
  for (int i = 0; i < n; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    rx[y].push_back(x);
    ry[x].push_back(y);
    ps.emplace_back(x, y);
    bst.insert(x * MAX_N + y);
  }
  for (int i = 0; i < MAX_N; i++) {
    sort(rx[i].begin(), rx[i].end());
    sort(ry[i].begin(), ry[i].end());
  }
  sort(ps.begin(), ps.end());
  int ans = 0;
  for (pair<int, int> p : ps) {
    int ptr_rx =
        lower_bound(rx[p.second].begin(), rx[p.second].end(), p.first) -
        rx[p.second].begin();
    int ptr_ry = lower_bound(ry[p.first].begin(), ry[p.first].end(), p.second) -
                 ry[p.first].begin();
    if (ptr_rx <= ptr_ry) {
      for (int i = 0; i < ptr_rx; i++) {
        int d = p.first - rx[p.second][i];
        if (bst.count(p.first * MAX_N + (p.second - d)) &&
            bst.count((p.first - d) * MAX_N + (p.second - d)))
          ans++;
      }
    } else {
      for (int i = 0; i < ptr_ry; i++) {
        int d = p.second - ry[p.first][i];
        if (bst.count(((p.first - d) * MAX_N + p.second)) &&
            bst.count((p.first - d) * MAX_N + (p.second - d)))
          ans++;
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
