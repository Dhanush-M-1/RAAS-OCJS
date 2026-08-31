#include <bits/stdc++.h>
using namespace std;
const int N = 400;
int n, m, r, c;
bitset<2 * N> a[26][N], res[N];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m;
  for (int i = (0); i < (n); ++i)
    for (int j = (0); j < (m); ++j) {
      char ch;
      cin >> ch;
      a[ch - 'a'][i][j] = a[ch - 'a'][i][j + m] = 1, res[i][j] = 1;
    }
  cin >> r >> c;
  for (int i = (0); i < (r); ++i)
    for (int j = (0); j < (c); ++j) {
      char ch;
      cin >> ch;
      if (ch == '?') continue;
      for (int k = (0); k < (n); ++k)
        res[k] &= (a[ch - 'a'][(i + k) % n] >> (j % m));
    }
  for (int i = (0); i < (n); ++i) {
    for (int j = (0); j < (m); ++j) cout << res[i][j];
    cout << "\n";
  }
  return 0;
}
