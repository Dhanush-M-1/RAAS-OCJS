#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
const long long maxn = 3e6;
const long long mod = 1e9 + 7;
const long double PI = acos((long double)-1);
long long pw(long long a, long long b, long long md = mod) {
  long long res = 1;
  while (b) {
    if (b & 1) {
      res = (a * res) % md;
    }
    a = (a * a) % md;
    b >>= 1;
  }
  return (res);
}
int n;
vector<int> adj[maxn];
int par[maxn];
bool sik[maxn];
void solve(int v) {
  cout << v << '\n';
  sik[v] = 1;
  for (auto u : adj[v])
    if (!sik[u] and u != par[v]) solve(u);
}
int dfs(int v) {
  int s = 0;
  for (auto u : adj[v])
    if (u != par[v]) par[u] = v, s += dfs(u);
  if (s % 2) solve(v);
  return (++s);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> par[i];
    if (!par[i]) continue;
    adj[i].push_back(par[i]);
    adj[par[i]].push_back(i);
  }
  memset(par, 0, sizeof par);
  ;
  if (n % 2 == 0) return (cout << "NO", 0);
  ;
  cout << "YES" << '\n';
  dfs(1);
  solve(1);
  return (0);
}
