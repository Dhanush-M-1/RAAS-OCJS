#include <bits/stdc++.h>
using namespace std;
bitset<405> a[405][26], ans[405];
string pat[405];
int main() {
  ios_base::sync_with_stdio(false);
  int n, m;
  cin >> n >> m;
  for (int i = 0; i <= n - 1; i++) {
    string s;
    cin >> s;
    for (int j = 0; j <= m - 1; j++) a[i][s[j] - 'a'].set(j), ans[i].set(j);
  }
  int r, c;
  cin >> r >> c;
  for (int i = 0; i <= r - 1; i++) {
    cin >> pat[i];
  }
  for (int i = 0; i <= r - 1; i++) {
    for (int j = 0; j <= c - 1; j++)
      if (pat[i][j] != '?') {
        for (int k = 0; k <= n - 1; k++)
          ans[(k - i % n + n) % n] &= ((a[k][pat[i][j] - 'a'] >> (j % m)) |
                                       (a[k][pat[i][j] - 'a'] << (m - j % m)));
      }
  }
  for (int i = 0; i <= n - 1; i++) {
    for (int j = 0; j <= m - 1; j++) {
      if (ans[i].test(j))
        cout << "1";
      else
        cout << "0";
    }
    cout << "\n";
  }
  return 0;
}
