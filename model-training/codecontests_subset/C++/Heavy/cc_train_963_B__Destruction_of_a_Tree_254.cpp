#include <bits/stdc++.h>
using namespace std;
int p[200200];
vector<int> g[200200];
int size[200200];
vector<int> res;
void dfs(int v) {
  size[v] = 1;
  for (int i = 0; i < g[v].size(); i++) {
    dfs(g[v][i]);
    size[v] += size[g[v][i]];
  }
}
void solve(int v, bool f = 0) {
  int cnt = 0;
  for (int i = 0; i < g[v].size(); i++) {
    if (size[g[v][i]] % 2 == 0) {
      cnt++;
    }
  }
  if (size[v] % 2) {
    if (f == 1) {
      printf("NO\n");
      exit(0);
    } else {
      for (int i = 0; i < g[v].size(); i++) {
        if (size[g[v][i]] % 2 == 0) solve(g[v][i], 1);
      }
      res.push_back(v);
      for (int i = 0; i < g[v].size(); i++) {
        if (size[g[v][i]] % 2 == 1) solve(g[v][i]);
      }
    }
  } else {
    if (f == 0) {
      printf("NO\n");
      exit(0);
    } else {
      for (int i = 0; i < g[v].size(); i++) {
        if (size[g[v][i]] % 2 == 0) solve(g[v][i], 1);
      }
      res.push_back(v);
      for (int i = 0; i < g[v].size(); i++) {
        if (size[g[v][i]] % 2 == 1) solve(g[v][i]);
      }
    }
  }
}
int main() {
  int n;
  scanf("%d", &n);
  int v;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &p[i]);
    if (p[i] != 0)
      g[p[i]].push_back(i);
    else
      v = i;
  }
  if (n % 2 == 0) {
    printf("NO\n");
    return 0;
  }
  dfs(v);
  solve(v);
  printf("YES\n");
  for (int i = 0; i < res.size(); i++) {
    printf("%d\n", res[i]);
  }
  return 0;
}
