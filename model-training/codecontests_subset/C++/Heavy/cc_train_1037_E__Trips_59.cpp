#include <bits/stdc++.h>
using namespace std;
int intcmp(const void *v1, const void *v2) { return *(int *)v1 - *(int *)v2; }
int n, m, k;
vector<pair<int, int>> v1v2index[200010];
int ea[200010], eb[200010];
int d[200010];
int curidx;
bool deleted[200010];
int delcnt[200010];
int delnow;
void dfs(int v) {
  if (deleted[v] || d[v] >= k) {
    return;
  }
  deleted[v] = true;
  ++delnow;
  for (auto [u, idx] : v1v2index[v]) {
    if (idx >= curidx) {
      continue;
    }
    --d[u];
    dfs(u);
  }
}
int main() {
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    int a, b;
    scanf("%d %d", &a, &b);
    v1v2index[a].push_back(make_pair(b, i));
    v1v2index[b].push_back(make_pair(a, i));
    ea[i] = a;
    eb[i] = b;
    d[a]++;
    d[b]++;
  }
  curidx = m;
  for (int i = 1; i < n + 1; i++) {
    dfs(i);
  }
  for (curidx = m - 1; curidx >= 0; curidx--) {
    delcnt[curidx] = delnow;
    if (deleted[ea[curidx]] || deleted[eb[curidx]]) {
      continue;
    }
    d[ea[curidx]]--;
    d[eb[curidx]]--;
    dfs(ea[curidx]);
    dfs(eb[curidx]);
  }
  for (int i = 0; i < m; ++i) {
    printf("%d\n", n - delcnt[i]);
  }
  return 0;
}
