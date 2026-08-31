#include <bits/stdc++.h>
using namespace std;
bitset<410> f[410][410][26];
string s[410], t[410];
int n, m, p, q;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> m;
  for (int i = 0; i < n; i++) cin >> s[i];
  cin >> p >> q;
  for (int i = 0; i < p; i++) cin >> t[i];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      for (int k = 0; k < m; k++) {
        f[i][k][s[i][j] - 'a'].set((j - k + m) % m);
      }
    }
  }
  for (int i = 0; i < n; i++) {
    bitset<410> res;
    for (int j = 0; j < m; j++) res.set(j);
    for (int ii = 0; ii < p; ii++) {
      int iii = (ii + i) % n;
      for (int jj = 0; jj < q; jj++) {
        if (t[ii][jj] == '?') continue;
        res &= f[(ii + i) % n][jj % m][t[ii][jj] - 'a'];
      }
    }
    for (int j = 0; j < m; j++) putchar(res[j] ? '1' : '0');
    putchar('\n');
  }
  return 0;
}
