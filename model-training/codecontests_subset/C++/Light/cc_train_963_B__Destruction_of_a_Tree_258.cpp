#include <bits/stdc++.h>
using namespace std;
const int N = 200000 + 5;
int deg[N];
vector<int> G[N];
bool done[N];
void split(int u, int f) {
  cout << u << '\n';
  done[u] = true;
  for (int v : G[u]) deg[v] ^= 1;
  for (int v : G[u])
    if (v != f and !done[v]) {
      if (!deg[v]) split(v, u);
    }
}
void dfs(int u, int f) {
  for (int v : G[u])
    if (v != f) {
      dfs(v, u);
    }
  if (!deg[u]) split(u, f);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    if (x == 0) continue;
    deg[x] ^= 1;
    deg[i] ^= 1;
    G[x].push_back(i);
    G[i].push_back(x);
  }
  if (n % 2 == 0)
    cout << "NO\n";
  else
    cout << "YES\n", dfs(1, 1);
  return 0;
}
