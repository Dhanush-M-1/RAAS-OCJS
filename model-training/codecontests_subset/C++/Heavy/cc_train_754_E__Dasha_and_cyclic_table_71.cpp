#include <bits/stdc++.h>
using namespace std;
int n, m, r, c;
bitset<405> res[405], st[26][405];
char a[405][405], b[405][405];
bitset<405> myShift(bitset<405> temp, int shift, int siz) {
  assert(0 <= shift && shift < siz);
  return (temp >> shift) | (temp << (siz - shift));
}
int main() {
  ios_base::sync_with_stdio(false);
  long long precision = numeric_limits<long double>::digits10;
  cin >> n >> m;
  for (long long i = 0; i <= n - 1; i++) {
    for (long long j = 0; j <= m - 1; j++) {
      cin >> a[i][j];
      st[a[i][j] - 'a'][i][j] = 1;
    }
  }
  for (long long i = 0; i <= n - 1; i++) res[i] = ~res[i];
  cin >> r >> c;
  for (long long i = 0; i <= r - 1; i++) {
    for (long long j = 0; j <= c - 1; j++) cin >> b[i][j];
  }
  for (long long i = 0; i <= r - 1; i++) {
    for (long long j = 0; j <= c - 1; j++) {
      if (b[i][j] == '?') continue;
      int temp = b[i][j] - 'a';
      int x = ((-i) % n + n) % n;
      int y = j % m;
      for (long long p = 0; p <= n - 1; p++) {
        res[(p + x) % n] &= myShift(st[temp][p], y, m);
      }
    }
  }
  for (long long i = 0; i <= n - 1; i++) {
    for (long long j = 0; j <= m - 1; j++) cout << res[i][j];
    cout << "\n";
  }
}
