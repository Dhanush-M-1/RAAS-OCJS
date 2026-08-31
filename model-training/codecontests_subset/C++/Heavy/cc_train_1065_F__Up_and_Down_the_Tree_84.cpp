#include <bits/stdc++.h>
using namespace std;
auto const Random_Address = [] {
  char* c;
  c = new char;
  delete c;
  return uint64_t(c);
};
uint64_t const SEED = chrono::steady_clock::now().time_since_epoch().count() *
                      (Random_Address() bitor 1);
mt19937 Rng(SEED);
constexpr int Mask(int i) { return 1 << i; }
constexpr int Getb(int x, int i) { return x >> i bitand 1; }
template <size_t N>
bitset<N> Bits(int x) {
  return bitset<N>(x);
}
template <class X, class Y>
bool minimize(X& x, Y const& y) {
  return y < x ? x = y, 1 : 0;
}
template <class X, class Y>
bool maximize(X& x, Y const& y) {
  return y > x ? x = y, 1 : 0;
}
int const maxN = 1e6;
int const maxK = 1e6;
int const infi = 1e9 + 7;
int N, K;
vector<int> adj[maxN + 3];
int f[maxN + 3], g[maxN + 3], h[maxN + 3], d[maxN + 3];
void dfs(int u) {
  if (adj[u].empty()) {
    h[u] = d[u];
    f[u] = g[u] = 1;
    return;
  }
  int _max = 0;
  h[u] = infi;
  for (int v : adj[u]) {
    d[v] = d[u] + 1;
    dfs(v);
    minimize(h[u], h[v]);
    if (h[v] - d[u] <= K) {
      f[u] += f[v];
      g[u] += f[v];
      maximize(_max, g[v] - f[v]);
    } else
      maximize(_max, g[v]);
  }
  g[u] += _max;
  return;
}
int main() {
  cin.tie(nullptr)->sync_with_stdio(false);
  cin >> N >> K;
  for (int v = 2; v <= N; v++) {
    int u;
    cin >> u;
    adj[u].push_back(v);
  }
  dfs(1);
  cout << g[1];
  return 0;
}
