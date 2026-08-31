#include <bits/stdc++.h>
using namespace std;
int n;
vector<long long> b, a;
vector<vector<pair<int, int> > > adjlist;
vector<bool> vis;
bool flag = false;
long long dfs(int s) {
  for (int i = 0; i < (int)adjlist[s].size(); i++) {
    int p = adjlist[s][i].first;
    int k = adjlist[s][i].second;
    long long required = dfs(p);
    if (required > 0) {
      b[s] -= required * k;
    }
    if (required < 0) {
      b[s] += (-required);
    }
  }
  vis[s] = true;
  long long tot = a[s] - b[s];
  if (tot < (long long)-2 * 1e17) {
    flag = true;
  }
  return a[s] - b[s];
}
int main() {
  scanf("%d", &n);
  b.assign(n + 10, 0);
  a.assign(n + 10, 0);
  vis.assign(n + 10, false);
  adjlist.assign(n + 10, vector<pair<int, int> >());
  for (int i = 0; i < n; i++) {
    cin >> b[i];
  }
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  int x, k;
  for (int i = 1; i < n; i++) {
    scanf("%d %d", &x, &k);
    adjlist[x - 1].push_back(pair<int, int>(i, k));
  }
  long long ans;
  for (int i = 0; i < n; i++) {
    if (!vis[i]) {
      ans = dfs(i);
      if (flag || ans > 0) {
        printf("NO");
        return 0;
      }
    }
  }
  printf("YES");
  return 0;
}
