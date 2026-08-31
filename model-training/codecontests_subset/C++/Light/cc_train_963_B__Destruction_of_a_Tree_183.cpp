#include <bits/stdc++.h>
using namespace std;
vector<int> g[210000];
int n, x, f[210000], size[210000];
void dfs(int x, int fa) {
  f[x] = fa;
  size[x] = 1;
  for (int i = 0; i < g[x].size(); i++) {
    int t = g[x][i];
    if (t != fa) {
      dfs(t, x);
      size[x] += size[t];
    }
  }
}
void find(int x) {
  for (int i = 0; i < g[x].size(); i++) {
    int t = g[x][i];
    if (t != f[x])
      if (size[t] % 2 == 0) find(t);
  }
  cout << x << endl;
  for (int i = 0; i < g[x].size(); i++) {
    int t = g[x][i];
    if (t != f[x])
      if (size[t] % 2 == 1) find(t);
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &x);
    if (x) {
      g[x].push_back(i);
      g[i].push_back(x);
    }
  }
  if (n % 2 == 1) {
    cout << "YES" << endl;
    dfs(1, 0);
    find(1);
  } else
    cout << "NO";
  return 0;
}
