#include <bits/stdc++.h>
using namespace std;
const int N = 405;
int n, m, r, c;
char s[N][N], p[N][N];
bitset<N> a[26][N], f[N];
int main() {
  ios::sync_with_stdio(0);
  cin >> n >> m;
  for (int i = 0; i < n; ++i) {
    cin >> s[i];
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      a[s[i][j] - 'a'][i].set(j);
      f[i].set(j);
    }
  }
  cin >> r >> c;
  for (int i = 0; i < r; ++i) {
    cin >> p[i];
  }
  for (int i = 0; i < r; ++i) {
    for (int j = 0; j < c; ++j) {
      if (p[i][j] == '?') continue;
      int x = p[i][j] - 'a';
      for (int k = 0; k < n; ++k) {
        f[k] &= (a[x][(k + i) % n] >> j % m) | (a[x][(k + i) % n] << m - j % m);
      }
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      cout << f[i][j];
    }
    cout << '\n';
  }
}
