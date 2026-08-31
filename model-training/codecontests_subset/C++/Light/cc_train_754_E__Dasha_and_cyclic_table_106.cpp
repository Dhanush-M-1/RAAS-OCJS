#include <bits/stdc++.h>
using namespace std;
long long t, n, m, u, v, q, r, ql, qr, k, l, w, x, y, d, p, c, b, a, s;
const int N = 405;
const int T = 101;
const long long mod = 1e9 + 7;
const long long INF = 1LL << 52LL;
string str[N];
string pat[N];
bitset<N> res[N];
bitset<N> g[N][N];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> m;
  for (int i = 0; i < n; ++i) {
    cin >> str[i];
    for (int j = 0; j < str[i].size(); ++j) {
      g[str[i][j] - 'a'][i].set(j);
      res[i].set(j);
    }
  }
  cin >> r >> c;
  for (int i = 0; i < r; ++i) {
    cin >> pat[i];
  }
  for (int i = 0; i < r; ++i) {
    for (int j = 0; j < c; ++j) {
      if (pat[i][j] == '?') continue;
      for (int k = 0; k < n; ++k) {
        res[((k - i) % n + n) % n] &= (g[pat[i][j] - 'a'][k] >> (j % m)) |
                                      (g[pat[i][j] - 'a'][k] << (m - (j % m)));
      }
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) cout << res[i].test(j);
    cout << '\n';
  }
  return 0;
}
