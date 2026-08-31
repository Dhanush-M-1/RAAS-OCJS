#include <bits/stdc++.h>
using namespace std;
int n, m, r, c;
bitset<405> ans[405];
bitset<405> pres[27][405];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) ans[i].set();
  for (int i = 1; i <= n; ++i) {
    string s;
    cin >> s;
    for (int j = 0; j <= m - 1; ++j) pres[s[j] - 'a' + 1][i].set(j);
  }
  cin >> r >> c;
  for (int i = 1; i <= r; ++i) {
    string s;
    cin >> s;
    for (int j = 0; j <= c - 1; ++j) {
      if (s[j] == '?') continue;
      for (int row = 1; row <= n; ++row) {
        int cr = (row + i - 1) % n;
        if (!cr) cr = n;
        int ch = s[j] - 'a' + 1;
        ans[row] &=
            ((pres[ch][cr] >> (j % m)) | (pres[ch][cr] << (m - (j % m))));
      }
    }
  }
  for (int i = 1; i <= n; ++i) {
    for (int j = 0; j <= m - 1; ++j) {
      if (ans[i].test(j))
        cout << 1;
      else
        cout << 0;
    }
    cout << '\n';
  }
}
