#include <bits/stdc++.h>
using namespace std;
const int INF = 2e9;
const long long INFLL = 4e18L;
const int MOD = 0;
const int N = 3e5 + 3;
const int BLUE = 1, RED = 2;
int n, k;
char init_state[N];
vector<int> has[N];
int color[N];
vector<int> adj_same[N], adj_diff[N];
struct DSU {
  vector<int> _leader, _size, _forced, _r, _b;
  DSU() {}
  DSU(int _n) {
    _leader.assign(_n + 1, 0);
    for (int i = 1; i <= _n; ++i) _leader[i] = i;
    _size.assign(_n + 1, 1);
    _forced.assign(_n + 1, 0);
    _r.assign(_n + 1, 0);
    for (int i = 1; i <= _n; ++i) _r[i] = color[i] == RED;
    _b.assign(_n + 1, 0);
    for (int i = 1; i <= _n; ++i) _b[i] = color[i] == BLUE;
  }
  int leader(int x) {
    return (_leader[x] == x) ? x : _leader[x] = leader(_leader[x]);
  }
  void unite(int x, int y) {
    x = leader(x);
    y = leader(y);
    if (x == y) return;
    _leader[y] = x;
    if (_forced[y]) _forced[x] = _forced[y];
    _size[x] += _size[y];
    _r[x] += _r[y];
    _b[x] += _b[y];
  }
  int get_ans(int x) {
    x = leader(x);
    if (_forced[x] == RED) return _r[x];
    if (_forced[x] == BLUE) return _b[x];
    return min(_r[x], _b[x]);
  }
};
void dfs(int i, int c) {
  color[i] = c;
  for (int j : adj_same[i])
    if (!color[j]) {
      color[j] = c;
      dfs(j, c);
    }
  for (int j : adj_diff[i])
    if (!color[j]) {
      color[j] = RED + BLUE - c;
      dfs(j, RED + BLUE - c);
    }
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cout << fixed << setprecision(16);
  cin >> n >> k;
  for (int i = 1; i <= n; ++i) cin >> init_state[i];
  for (int i = 1; i <= k; ++i) {
    int nb;
    cin >> nb;
    while (nb--) {
      int j;
      cin >> j;
      has[j].push_back(i);
    }
  }
  for (int i = 1; i <= n; ++i) {
    if ((int)has[i].size() < 2) continue;
    int x = has[i].front();
    int y = has[i].back();
    if (init_state[i] == '0') {
      adj_diff[x].push_back(y);
      adj_diff[y].push_back(x);
    } else if (init_state[i] == '1') {
      adj_same[x].push_back(y);
      adj_same[y].push_back(x);
    }
  }
  for (int i = 1; i <= k; ++i)
    if (!color[i]) dfs(i, RED);
  DSU dsu(k);
  int ans = 0;
  for (int i = 1; i <= n; ++i) {
    if ((int)has[i].size() == 1) {
      int x = has[i].front();
      int lx = dsu.leader(x);
      ans -= dsu.get_ans(lx);
      if (init_state[i] == '0')
        dsu._forced[lx] = color[x];
      else if (init_state[i] == '1')
        dsu._forced[lx] = RED + BLUE - color[x];
      ans += dsu.get_ans(lx);
    } else if ((int)has[i].size() == 2) {
      int x = has[i].front();
      int y = has[i].back();
      int lx = dsu.leader(x);
      int ly = dsu.leader(y);
      if (lx != ly) {
        ans -= dsu.get_ans(lx);
        ans -= dsu.get_ans(ly);
        dsu.unite(lx, ly);
        ans += dsu.get_ans(dsu.leader(lx));
      }
    }
    cout << ans << endl;
  }
}
