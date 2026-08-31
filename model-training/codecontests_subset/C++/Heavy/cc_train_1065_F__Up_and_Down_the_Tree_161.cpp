#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
long long lcm(long long a, long long b) { return a * (b / gcd(a, b)); }
pair<int, int> rev[1000005];
int h[1000005];
int d[1000005];
vector<int> g[1000005];
int N, K;
void pre_dfs(int u, int p = -1) {
  rev[u] = pair<int, int>(1000005, 0);
  for (int v : g[u]) {
    if (v == p) continue;
    h[v] = h[u] + 1;
    pre_dfs(v, u);
    if (rev[v].first <= h[u]) {
      rev[u].first = min(rev[u].first, rev[v].first);
      rev[u].second += rev[v].second;
    }
  }
  if (p >= 0 && g[u].size() == 1) {
    rev[u].first = h[u] - K;
    rev[u].second = 1;
  }
}
void sol(int u, int p = -1) {
  d[u] = p >= 0 && g[u].size() == 1;
  for (int v : g[u]) {
    if (v == p) continue;
    sol(v, u);
    int temp = rev[u].second;
    if (rev[v].first <= h[u]) temp -= rev[v].second;
    d[u] = max(d[u], temp + d[v]);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> N >> K;
  for (int i = 1; i <= N - 1; i++) {
    int u;
    cin >> u;
    u--;
    g[i].push_back(u);
    g[u].push_back(i);
  }
  h[0] = 0;
  pre_dfs(0);
  sol(0);
  cout << d[0] << endl;
  return 0;
}
