#include <bits/stdc++.h>
using namespace std;
set<int> trip;
set<int> vec[200010];
struct node {
  int u, v;
} mf[200010];
int n, m, k;
int ans[200010];
void remove(int x) {
  set<int>::iterator it;
  if (vec[x].size() < k && trip.count(x)) {
    trip.erase(x);
    for (it = vec[x].begin(); it != vec[x].end(); it++) {
      int i = *it;
      vec[i].erase(x);
      remove(i);
    }
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    vec[u].insert(v);
    vec[v].insert(u);
    mf[i] = node{u, v};
  }
  for (int i = 1; i <= n; i++) trip.insert(i);
  for (int i = 1; i <= n; i++) remove(i);
  for (int i = m; i > 0; i--) {
    ans[i] = trip.size();
    int u = mf[i].u, v = mf[i].v;
    vec[u].erase(v);
    vec[v].erase(u);
    remove(u);
    remove(v);
  }
  for (int i = 1; i <= m; i++) {
    printf("%d\n", ans[i]);
  }
  return 0;
}
