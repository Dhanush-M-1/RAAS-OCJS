#include <bits/stdc++.h>
using namespace std;
bitset<400> iseq[26][400];
bitset<400> sol[400];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m, r, c, i, j, k;
  char ch;
  cin >> n >> m;
  for (i = 0; i < n; ++i) {
    sol[i].flip();
    for (j = 0; j < m; ++j) {
      cin >> ch;
      iseq[ch - 'a'][i].set(j);
    }
  }
  cin >> r >> c;
  for (i = 0; i < r; ++i)
    for (j = 0; j < c; ++j) {
      cin >> ch;
      if (ch == '?') continue;
      for (k = 0; k < n; ++k) {
        sol[k] &= iseq[ch - 'a'][(k + i) % n] >> j % m |
                  iseq[ch - 'a'][(k + i) % n] << (m - j % m);
      }
    }
  for (i = 0; i < n; ++i) {
    for (j = 0; j < m; ++j) cout << sol[i][j];
    cout << '\n';
  }
}
