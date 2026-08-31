#include <bits/stdc++.h>
using namespace std;
const int N = (int)2e5 + 5;
const int inf = (int)1e9 + 7;
int n;
int s[N];
vector<int> g[N];
void dfs(int v, int p) {
  s[v] = 1;
  for (int i : g[v]) {
    if (i == p) {
      continue;
    }
    dfs(i, v);
    s[v] += s[i];
  }
}
void dfs2(int v, int p) {
  for (int i : g[v]) {
    if (i == p) continue;
    if (s[i] % 2 == 0) {
      dfs2(i, v);
    }
  }
  printf("%d\n", v);
  for (int i : g[v]) {
    if (i == p) continue;
    if (s[i] % 2 == 1) {
      dfs2(i, v);
    }
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    int x;
    scanf("%d", &x);
    if (x) {
      g[x].push_back(i);
      g[i].push_back(x);
    }
  }
  if (n % 2 == 0) {
    printf("NO\n");
    return 0;
  }
  printf("YES\n");
  dfs(1, 1);
  dfs2(1, 1);
  return 0;
}
