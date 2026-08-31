#include <bits/stdc++.h>
using namespace std;
const int MX = 405;
int n, m, r, c;
bitset<MX> bs[26][MX], res[MX];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m;
  for (int i = 0; i < int(n); i++)
    for (int j = 0; j < int(m); j++) {
      char c;
      cin >> c;
      bs[c - 'a'][i][j] = 1;
      res[i][j] = 1;
    }
  cin >> r >> c;
  for (int i = 0; i < int(r); i++)
    for (int j = 0; j < int(c); j++) {
      char h;
      cin >> h;
      if (h != '?') {
        int oy = ((((-j) % (m)) + (m)) % (m));
        for (int k = 0; k < n; k++)
          res[((((k - i) % (n)) + (n)) % (n))] &=
              (bs[h - 'a'][k] << oy) | (bs[h - 'a'][k] >> (m - oy));
      }
    }
  for (int i = 0; i < int(n); i++) {
    for (int j = 0; j < int(m); j++) cout << int(res[i][j]);
    cout << '\n';
  }
  return 0;
}
