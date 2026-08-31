#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  vector<int> pos(n + 1), order(n + 1);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &pos[i]);
    order[pos[i]] = i;
  }
  vector<set<int>> G(n + 1);
  vector<int> take;
  for (int i = 0; i < m; i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    G[u].insert(v);
    if (v == pos[n]) take.push_back(order[u]);
  }
  sort(begin(take), end(take));
  int to = n;
  int ans = 0;
  while (not take.empty()) {
    int cur = take.back();
    take.pop_back();
    while (cur < to and G[pos[cur]].count(pos[cur + 1])) {
      swap(pos[cur], pos[cur + 1]);
      cur++;
    }
    if (cur == to) to--, ans++;
  }
  printf("%d\n", ans);
  return (0);
}
