#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
const int INF = 1e9;
const int MAX = 2e5 + 6;
vector<long long> v[MAX];
bool vis[MAX];
long long a, b;
void dfs(long long x) {
  vis[x]++;
  if (x == b) return;
  for (auto i : v[x]) {
    if (vis[i] == 0) dfs(i);
  }
}
void dfs1(long long x) {
  vis[x]++;
  if (x == a) return;
  for (auto i : v[x]) {
    if (vis[i] == 0) dfs1(i);
  }
}
int main() {
  long long t;
  cin >> t;
  while (t--) {
    long long n, m, x, y;
    cin >> n >> m >> a >> b;
    for (int i = 1; i <= n; i++) v[i].clear();
    while (m--) {
      cin >> x >> y;
      v[x].push_back(y);
      v[y].push_back(x);
    }
    for (int i = 1; i <= n; i++) vis[i] = 0;
    dfs(a);
    x = 0;
    y = 0;
    for (int i = 1; i <= n; i++) {
      if (vis[i] == 0) x++;
      vis[i] = 0;
    }
    dfs1(b);
    for (int i = 1; i <= n; i++) {
      if (vis[i] == 0) y++;
    }
    cout << x * y << "\n";
  }
}
