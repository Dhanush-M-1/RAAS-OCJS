#include <bits/stdc++.h>
using namespace std;
const int Z = (int)1e5 + 111;
const int inf = (int)1e9 + 111;
const long long llinf = (long long)1e18 + 5;
const int MOD = (int)1e9 + 7;
long double need[Z], a[Z], b[Z], c[Z];
vector<int> g[Z];
void dfs(int v) {
  need[v] = a[v] - b[v];
  for (int to : g[v]) {
    dfs(to);
  }
  for (int to : g[v]) {
    if (need[to] < 0) {
      need[v] += need[to];
    } else {
      need[v] += need[to] * c[to];
    }
  }
}
int main() {
  srand(time(0));
  ios_base::sync_with_stdio(false);
  int n;
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> b[i];
  }
  for (int i = 1; i <= n; ++i) {
    cin >> a[i];
  }
  for (int i = 2; i <= n; ++i) {
    int x, k;
    cin >> x >> k;
    g[x].push_back(i);
    c[i] = k;
  }
  dfs(1);
  cout << (need[1] <= 0 ? "YES" : "NO");
  return 0;
}
