#include <bits/stdc++.h>
using namespace std;
long long mod = 1e9 + 7;
long long po(long long x, long long y, long long p) {
  long long res = 1;
  x = x % p;
  if (x == 0) return 0;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
void dfs(vector<vector<long long> > &adj, long long s, long long e,
         vector<long long> &v, vector<bool> &vis) {
  if (s == e) return;
  vis[s] = true;
  for (auto vx : adj[s]) {
    if (!vis[vx]) {
      dfs(adj, vx, e, v, vis);
    }
  }
  v.push_back(s);
}
void solve() {
  long long n, m, a, b;
  cin >> n >> m >> a >> b;
  vector<vector<long long> > adj(n + 1);
  while (m--) {
    long long x, y;
    cin >> x >> y;
    adj[x].push_back(y);
    adj[y].push_back(x);
  }
  vector<long long> v1;
  vector<long long> v2;
  vector<bool> vis(n + 1, false);
  dfs(adj, a, b, v1, vis);
  for (int i = 0; i < n + 1; i++) vis[i] = false;
  dfs(adj, b, a, v2, vis);
  sort((v1).begin(), (v1).end());
  sort((v2).begin(), (v2).end());
  long long n1 = 0, n2 = 0;
  for (long long i = 0; i < v1.size(); i++) {
    if (!binary_search(v2.begin(), v2.end(), v1[i]) and v1[i] != a) {
      n1++;
    }
  }
  for (long long i = 0; i < v2.size(); i++) {
    if (!binary_search(v1.begin(), v1.end(), v2[i]) and v2[i] != b) n2++;
  }
  cout << n1 * n2 << '\n';
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
