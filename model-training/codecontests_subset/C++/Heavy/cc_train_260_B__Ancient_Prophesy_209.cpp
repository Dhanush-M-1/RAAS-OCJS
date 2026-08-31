#include <bits/stdc++.h>
using namespace std;
int d, m, y, k, mx, mxi;
int day[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
bool f;
int dd[5000], mm[5000], yy[5000], s[5000];
int pm(char x) {
  if (((x - 48) >= 0) && ((x - 48) <= 9)) {
    return x - 48;
  } else {
    return -1;
  }
}
int main() {
  string a;
  cin >> a;
  for (int i = 0; i < a.length(); i++) {
    if ((pm(a[i]) != -1) && (pm(a[i + 1]) != -1) && (a[i + 2] == '-') &&
        (pm(a[i + 3]) != -1) && (pm(a[i + 4]) != -1) && (a[i + 5] == '-') &&
        (pm(a[i + 6]) != -1) && (pm(a[i + 7]) != -1) && (pm(a[i + 8]) != -1) &&
        (pm(a[i + 9]) != -1) && (pm(a[i + 3]) * 10 + pm(a[i + 4]) <= 12) &&
        ((pm(a[i]) * 10 + pm(a[i + 1]) <=
          day[pm(a[i + 3]) * 10 + pm(a[i + 4])]))) {
      d = pm(a[i]) * 10 + pm(a[i + 1]);
      m = pm(a[i + 3]) * 10 + pm(a[i + 4]);
      y = pm(a[i + 6]) * 1000 + pm(a[i + 7]) * 100 + pm(a[i + 8]) * 10 +
          pm(a[i + 9]);
      if ((d == 0) || (m == 0)) continue;
      if ((y < 2013) || (y > 2015)) continue;
      f = true;
      for (int j = 0; j < k; j++) {
        if ((dd[j] == d) && (mm[j] == m) && (yy[j] == y)) {
          f = false;
          s[j]++;
        }
      }
      if (f) {
        dd[k] = d;
        mm[k] = m;
        yy[k] = y;
        s[k] = 1;
        k++;
      }
    }
  }
  for (int i = 0; i < k; i++) {
    if (s[i] > mx) {
      mx = s[i];
      mxi = i;
    }
  }
  if (dd[mxi] / 10 == 0) {
    cout << 0 << dd[mxi] << "-";
  } else {
    cout << dd[mxi] << "-";
  }
  if (mm[mxi] / 10 == 0) {
    cout << 0 << mm[mxi] << "-";
  } else {
    cout << mm[mxi] << "-";
  }
  cout << yy[mxi];
  return 0;
}
