#include <bits/stdc++.h>
using namespace std;
const int N = 300005;
int n, m, a[N];
vector<int> adj[N], f(N, 0);
int main(int argc, char const *argv[]) {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i]);
  }
  for (int i = 0; i < m; ++i) {
    int u, v;
    scanf("%d %d", &u, &v);
    adj[u].push_back(v);
  }
  int ans = 0, d = 1;
  f[a[n]] = 1;
  for (int i = n - 1; i >= 1; --i) {
    int c = 0;
    for (int v : adj[a[i]]) {
      c += (f[v] == 1);
    }
    if (c == d)
      ans++;
    else {
      f[a[i]] = 1;
      d++;
    }
  }
  printf("%d\n", ans);
  return 0;
}
