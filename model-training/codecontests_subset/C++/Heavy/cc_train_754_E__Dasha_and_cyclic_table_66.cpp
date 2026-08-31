#include <bits/stdc++.h>
using namespace std;
int const N = 410;
int const A = 26;
bitset<N> L[A][N];
string f[N];
string t[N];
bitset<N> ans[N];
bitset<N> rotate(bitset<N> const& a, int size, int x) {
  return (a >> x) | (a << (size - x));
}
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; ++i) cin >> f[i];
  int a, b;
  cin >> a >> b;
  for (int i = 0; i < a; ++i) cin >> t[i];
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < m; ++j) L[f[i][j] - 'a'][i][j] = 1;
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < m; ++j) ans[i][j] = 1;
  for (int x = 0; x < a; ++x) {
    for (int y = 0; y < b; ++y) {
      if (t[x][y] == '?') continue;
      int z = t[x][y] - 'a';
      for (int i = 0; i < n; ++i) {
        ans[(i - x % n + n) % n] &= rotate(L[z][i], m, y % m);
      }
    }
  }
  for (int i = 0; i < n; ++i, cout << '\n')
    for (int j = 0; j < m; ++j) cout << ans[i][j];
}
