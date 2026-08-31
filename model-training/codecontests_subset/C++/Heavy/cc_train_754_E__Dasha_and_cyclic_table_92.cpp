#include <bits/stdc++.h>
using namespace std;
int n, m, r, c;
bitset<2 * ((int)402)> a[26][((int)402)], ans[((int)402)];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++) {
      char c;
      cin >> c;
      a[c - 'a'][i][j] = a[c - 'a'][i][j + m] = 1;
      ans[i][j] = 1;
    }
  cin >> r >> c;
  for (int i = 0; i < r; i++)
    for (int j = 0; j < c; j++) {
      char c;
      cin >> c;
      if (c == '?') continue;
      for (int p = 0; p < n; p++)
        ans[p] &= (a[c - 'a'][(p + i) % n] >> (j % m));
    }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) cout << ans[i][j];
    cout << "\n";
  }
  return 0;
}
