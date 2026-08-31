#include <bits/stdc++.h>
using namespace std;
vector<vector<int> > adj(1000001), v(1000001);
int k, d[1000001], a[1000001], parent[1000001];
void ParentDFS(int i) {
  d[i] = 1 + d[parent[i]];
  v[d[i]].push_back(i);
  for (auto j : adj[i]) {
    ParentDFS(j);
  }
}
int AnsDFS(int i) {
  int ans = 0;
  for (auto j : adj[i]) {
    ans = max(ans, AnsDFS(j));
  }
  ans += a[i];
  return ans;
}
int Find(int i, int x, int &s) {
  s += a[i];
  a[i] = 0;
  return (d[i] == x) ? i : parent[i] = Find(parent[i], x, s);
}
int main() {
  int n;
  scanf("%d%d", &n, &k);
  for (int i = 2; i <= n; ++i) {
    scanf("%d", &parent[i]);
    adj[parent[i]].push_back(i);
  }
  ParentDFS(1);
  for (int i = 2; i <= n; ++i) {
    a[i] = (adj[i].size() == 0);
  }
  for (int x = n - 1; x > 0; --x) {
    for (auto i : v[x]) {
      if (adj[i].size()) {
        continue;
      }
      int s = 0, j = Find(i, max(1, d[i] - k), s);
      a[j] = s;
    }
  }
  printf("%d\n", AnsDFS(1));
  return 0;
}
