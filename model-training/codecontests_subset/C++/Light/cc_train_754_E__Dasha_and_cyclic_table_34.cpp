#include <bits/stdc++.h>
using namespace std;
long long gcd(long long x, long long y) {
  if (y == 0) return x;
  return gcd(y, x % y);
}
bitset<805> a[405], b[405][26];
string s[405], c[405];
int main() {
  int n, m;
  cin >> n >> m;
  int i;
  for (i = 0; i < n; i++) cin >> s[i];
  int r, c1;
  cin >> r >> c1;
  int j;
  for (i = 0; i < n; i++) {
    a[i].set();
    for (j = 0; j < m + c1 - 1; j++) {
      int x = s[i][j % m] - 'a';
      b[i][x].set(j);
    }
  }
  for (i = 0; i < r; i++) cin >> c[i];
  for (i = 0; i < r; i++) {
    for (j = 0; j < c1; j++) {
      int x = c[i][j] - 'a';
      if (c[i][j] == '?') continue;
      for (int k = 0; k < n; k++) {
        int h = ((k - i) + n) % n;
        bitset<805> b1 = b[k][x] >> j;
        a[h] &= b1;
      }
    }
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < m; j++)
      if (a[i].test(j))
        cout << "1"
             << "";
      else
        cout << "0"
             << "";
    cout << endl;
  }
  return 0;
}
