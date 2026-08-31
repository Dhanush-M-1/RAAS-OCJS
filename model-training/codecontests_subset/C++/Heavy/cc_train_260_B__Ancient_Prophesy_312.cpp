#include <bits/stdc++.h>
using namespace std;
string str, s, rezz, datums[40005];
int i, j, k, d, m, y, n, z, rez;
int monthdays[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int mas[40005], bijan[40005];
int main() {
  cin >> str;
  k = str.length() - 9;
  for (i = 0; i < k; ++i) {
    s = str.substr(i, 10);
    m = 0;
    for (j = 0; j < 10; ++j) {
      if (s[j] == '-') {
        ++m;
      }
    }
    if (((m == 2) && (s[2] == '-')) && (s[5] == '-')) {
      d = (s[0] - '0') * 10 + s[1] - '0';
      m = (s[3] - '0') * 10 + s[4] - '0';
      y = (s[6] - '0') * 1000 + (s[7] - '0') * 100 + (s[8] - '0') * 10 + s[9] -
          '0';
      if ((((y >= 2013) && (y <= 2015)) &&
           ((m <= 12) && (d <= monthdays[m]))) &&
          ((d > 0) && (m > 0))) {
        n = (2016 - y) * 10000 + m * 100 + d;
        ++mas[n];
        if (mas[n] == 1) {
          bijan[z] = n;
          datums[z] = s;
          ++z;
        }
        rez = max(rez, mas[n]);
      }
    }
  }
  for (i = 0; i < z; ++i) {
    if (mas[bijan[i]] == rez) {
      cout << datums[i];
    }
  }
  return 0;
}
