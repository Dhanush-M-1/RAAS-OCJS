#include <bits/stdc++.h>
using namespace std;
using uint = unsigned int;
using ll = long long;
using ull = unsigned long long;
using pii = pair<int, int>;
using pll = pair<ll, ll>;
template <typename T1, typename T2>
ostream &operator<<(ostream &out, const pair<T1, T2> &item) {
  out << '(' << item.first << ", " << item.second << ')';
  return out;
}
template <typename T>
ostream &operator<<(ostream &out, const vector<T> &v) {
  for (const auto &item : v) out << item << ' ';
  return out;
}
const int NMAX = 200010;
int h[NMAX];
int mex[NMAX], xorMex[NMAX];
vector<int> adj[NMAX];
void dfs(int v) {
  set<int> s;
  for (auto u : adj[v]) {
    if (mex[u] == -1) dfs(u);
    s.insert(mex[u]);
  }
  int i;
  for (i = 0; s.count(i); ++i)
    ;
  mex[v] = i;
  xorMex[i] ^= h[v];
}
int main() {
  ios_base::sync_with_stdio(false);
  int i, n, m, a, b;
  cin >> n >> m;
  for (i = 1; i <= n; ++i) cin >> h[i];
  for (i = 1; i <= m; ++i) {
    cin >> a >> b;
    adj[a].push_back(b);
  }
  memset(mex, -1, sizeof mex);
  for (i = 1; i <= n; ++i)
    if (mex[i] == -1) dfs(i);
  for (i = n; i >= 0; --i) {
    if (!xorMex[i]) continue;
    cout << "WIN\n";
    for (int v = 1; v <= n; ++v)
      if (mex[v] == i && h[v] >= (h[v] ^ xorMex[i])) {
        h[v] ^= xorMex[i];
        for (auto u : adj[v]) {
          h[u] ^= xorMex[mex[u]];
          xorMex[mex[u]] = 0;
        }
        break;
      }
    for (int v = 1; v <= n; ++v) cout << h[v] << ' ';
    cout << '\n';
    return 0;
  }
  cout << "LOSE\n";
  return 0;
}
