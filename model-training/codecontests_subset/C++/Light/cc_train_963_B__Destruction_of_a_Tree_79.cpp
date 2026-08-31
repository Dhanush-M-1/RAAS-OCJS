#include <bits/stdc++.h>
using namespace std;
int a[200010];
int deg[200010];
vector<int> e[200010];
vector<int> ans;
int d[200010], c[200010];
int dfs2(int v, int p) {
  if (deg[v] & 1) return 0;
  ans.push_back(v);
  d[v] = 1;
  for (int i = 0; i < e[v].size(); i++) {
    if (!d[e[v][i]]) {
      --deg[e[v][i]];
      if (!dfs2(e[v][i], v)) return 0;
    }
  }
  return 1;
}
int dfs(int v, int p = -1) {
  for (int i = 0; i < e[v].size(); i++) {
    if (e[v][i] != p) {
      if (dfs(e[v][i], v) == -1) return -1;
    }
  }
  if (deg[v] & 1) return 0;
  ans.push_back(v);
  d[v] = 1;
  for (int i = 0; i < e[v].size(); i++) {
    if (e[v][i] == p) {
      deg[p]--;
    } else if (!d[e[v][i]]) {
      deg[e[v][i]]--;
      if (!dfs2(e[v][i], v)) return -1;
    }
  }
  return 1;
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    if (!a[i]) continue;
    e[a[i]].push_back(i);
    e[i].push_back(a[i]);
    deg[i]++;
    deg[a[i]]++;
  }
  if (n % 2 == 0) {
    puts("NO");
    return 0;
  }
  if (dfs(1) == 1) {
    puts("YES");
    for (int i = 0; i < ans.size(); i++) {
      printf("%d\n", ans[i]);
    }
  } else {
    puts("NO");
  }
  return 0;
}
