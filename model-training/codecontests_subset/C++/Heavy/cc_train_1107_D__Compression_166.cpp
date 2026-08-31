#include <bits/stdc++.h>
using namespace std;
const int NMAX = 5205;
bitset<NMAX> bit[NMAX];
char s[NMAX];
int a[NMAX][NMAX], n;
inline int Convert(char ch) {
  if ('0' <= ch && ch <= '9') return ch - '0';
  return ch - 'A' + 10;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n;
  int j = 0;
  for (int i = 0; i < n; ++i) {
    cin >> (s + 1);
    for (int k = 1; k <= n / 4; ++k) {
      int val = Convert(s[k]);
      for (int p = 3; p >= 0; --p) {
        if ((val & (1 << p)) == 0)
          bit[i][j++] = 0;
        else
          bit[i][j++] = 1;
      }
      if (j == n) j = 0;
    }
  }
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < n; ++j) {
      int x = 0, y = 0, z = 0;
      if (i - 1 >= 0) x = a[i - 1][j];
      if (j - 1 >= 0) y = a[i][j - 1];
      if (i - 1 >= 0 && j - 1 >= 0) z = a[i - 1][j - 1];
      a[i][j] = x + y - z + bit[i][j];
    }
  for (int p = n; p >= 1; --p) {
    if (n % p != 0) continue;
    bool good = true;
    for (int i = p - 1; i < n && good; i += p)
      for (int j = p - 1; j < n && good; j += p) {
        int x = 0, y = 0, z = 0;
        if (i - p >= 0) x = a[i - p][j];
        if (j - p >= 0) y = a[i][j - p];
        if (i - p >= 0 && j - p >= 0) z = a[i - p][j - p];
        int sum = a[i][j] - x - y + z;
        if (sum != p * p && sum != 0) good = false;
      }
    if (good == true) {
      cout << p << "\n";
      break;
    }
  }
  return 0;
}
