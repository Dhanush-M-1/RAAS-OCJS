#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
vector<int> v[N];
int n, m, A, B, t;
int vis[N];
int f[N][2], Aa[2];
int c;
void dfs(int l, int r, int fa) {
  vis[l] = 1;
  if (l == r) {
    return;
  }
  for (auto k : v[l]) {
    if (vis[k]) {
      continue;
    }
    dfs(k, r, fa);
  }
}
int main() {
  ios::sync_with_stdio(false);
  for (cin >> t; t; t--) {
    cin >> n >> m >> A >> B;
    c = 0;
    Aa[0] = Aa[1] = 0;
    for (int i = 1; i <= n; i++)
      v[i].clear(), vis[i] = 0, f[i][0] = f[i][1] = 0;
    for (int i = 1; i <= m; i++) {
      int s, t;
      cin >> s >> t;
      v[s].push_back(t);
      v[t].push_back(s);
    }
    dfs(A, B, A);
    for (int i = 1; i <= n; i++) {
      if (!vis[i]) Aa[c]++;
      vis[i] = 0;
    }
    ++c;
    dfs(B, A, B);
    for (int i = 1; i <= n; i++) {
      if (!vis[i]) Aa[c]++;
    }
    cout << 1ll * Aa[0] * Aa[1] << '\n';
  }
  return 0;
}
