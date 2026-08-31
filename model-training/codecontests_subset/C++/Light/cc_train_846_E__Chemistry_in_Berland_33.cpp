#include <bits/stdc++.h>
using namespace std;
using INT = long long;
INT b[101000], a[101000];
vector<pair<int, int> > adj[101000];
INT dfs(int u, int rt = 1) {
  INT tot = b[u] - a[u];
  for (auto p : adj[u]) {
    tot += dfs(p.first, p.second);
    if (tot < -0x3f3f3f3f3f3f3f3f) {
      puts("NO");
      exit(0);
    }
  }
  if (tot >= 0) return tot;
  if (-tot >= (0x3f3f3f3f3f3f3f3f + rt - 1) / rt) {
    puts("NO");
    exit(0);
  }
  return tot * rt;
}
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    scanf("%I64d", b + i);
  }
  for (int i = 1; i <= n; i++) {
    scanf("%I64d", a + i);
  }
  for (int i = 2; i <= n; i++) {
    int x, k;
    scanf("%d %d", &x, &k);
    adj[x].push_back({i, k});
  }
  if (dfs(1) >= 0)
    puts("YES");
  else
    puts("NO");
}
