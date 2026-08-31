#include <bits/stdc++.h>
using namespace std;
int n, A[111];
map<int, set<int>> idxs;
set<int> app;
int main(void) {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &A[i]);
    app.insert(A[i]);
    idxs[A[i]].insert(i);
  }
  int q;
  scanf("%d", &q);
  while (q--) {
    int k, pos;
    scanf("%d%d", &k, &pos);
    int cnt = 0;
    set<int> ii;
    for (auto it = app.rbegin(); it != app.rend(); ++it) {
      int now = *it;
      cnt += idxs[now].size();
      if (cnt >= k) {
        cnt -= idxs[now].size();
        cnt = k - cnt;
        auto it = idxs[now].begin();
        while (cnt--) {
          ii.insert(*it);
          ++it;
        }
        break;
      }
      for (int i : idxs[now]) ii.insert(i);
    }
    auto it = ii.begin();
    while (--pos) ++it;
    printf("%d\n", A[*it]);
  }
  return 0;
}
