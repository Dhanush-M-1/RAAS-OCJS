#include <bits/stdc++.h>
using namespace std;
template <class T>
void read(T& x) {
  cin >> x;
}
template <class H, class... T>
void read(H& h, T&... t) {
  read(h);
  read(t...);
}
template <class A>
void read(A* x, int size) {
  for (int i = (0); (1) > 0 ? i < (size) : i > (size); i += (1)) read(x[i]);
}
template <class A>
void read(vector<A>& x) {
  for (auto& a : x) read(a);
}
template <class T>
void print(T& x) {
  cout << x << ' ';
}
template <class H, class... T>
void print(H h, T... t) {
  print(h);
  print(t...);
}
template <class A>
void print(A* x, int size) {
  for (int i = (0); (1) > 0 ? i < (size) : i > (size); i += (1)) print(x[i]);
  cout << '\n';
}
template <class A>
void print(vector<A>& x) {
  for (auto& a : x) print(a);
}
template <class H, class... T>
void debug(H h, T... t) {
  print(h, t...);
  cout << endl;
}
const int d4i[4] = {-1, 0, 1, 0}, d4j[4] = {0, 1, 0, -1};
const int d8i[8] = {-1, -1, 0, 1, 1, 1, 0, -1},
          d8j[8] = {0, 1, 1, 1, 0, -1, -1, -1};
const int N = 100010, mod = 1e9 + 7;
int n, ans = 1;
long long src[N], tar[N], INF = 2e17;
vector<pair<int, int>> g[N];
bool overflow(long long p, long long q, long long x) {
  if (p > INF / q or q > INF / p) return 1;
  if (p * q - x > INF) return 1;
  return 0;
}
void dfs(int s, int p = 0, int w = 0) {
  for (auto nn : g[s]) dfs(nn.first, s, nn.second);
  if (!ans) return;
  if (p and src[s] != tar[s]) {
    if (src[s] < tar[s]) {
      if (overflow(tar[s] - src[s], 1LL * w, src[p])) {
        ans = 0;
        return;
      }
      src[p] -= (tar[s] - src[s]) * w;
    } else
      src[p] += src[s] - tar[s];
    src[s] = tar[s];
  }
  if (src[s] < tar[s]) ans = 0;
}
void solve() {
  read(n);
  for (int i = (0); (1) > 0 ? i < (n) : i > (n); i += (1)) read(src[i + 1]);
  for (int i = (0); (1) > 0 ? i < (n) : i > (n); i += (1)) read(tar[i + 1]);
  int v, w;
  for (int i = (0); (1) > 0 ? i < (n - 1) : i > (n - 1); i += (1)) {
    read(v, w);
    g[v].push_back({i + 2, w});
  }
  dfs(1);
  cout << (ans ? "YES" : "NO");
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  solve();
}
