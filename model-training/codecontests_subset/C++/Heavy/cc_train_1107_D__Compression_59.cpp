#include <bits/stdc++.h>
using namespace std;
string a[5205];
string x[505];
int main() {
  x['0'] = "0000";
  x['1'] = "0001";
  x['2'] = "0010";
  x['3'] = "0011";
  x['4'] = "0100";
  x['5'] = "0101";
  x['6'] = "0110";
  x['7'] = "0111";
  x['8'] = "1000";
  x['9'] = "1001";
  x['A'] = "1010";
  x['B'] = "1011";
  x['C'] = "1100";
  x['D'] = "1101";
  x['E'] = "1110";
  x['F'] = "1111";
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    string xx;
    cin >> xx;
    a[i] += "0";
    for (int j = 0; j < xx.size(); j++) a[i] += x[xx[j]];
  }
  for (int i = 1; i <= n; i++) {
    if (n % i != 0) continue;
    int f = 0;
    for (int j = 1; j <= n; j += n / i) {
      for (int k = 1; k <= n; k += n / i) {
        for (int jj = j; jj < j + n / i; jj++) {
          for (int kk = k; kk < k + n / i; kk++) {
            if (a[jj][kk] != a[j][k]) {
              f = 1;
              break;
            }
          }
          if (f) break;
        }
        if (f) break;
      }
      if (f) break;
    }
    if (!f) {
      printf("%d", n / i);
      return 0;
    }
  }
  return 0;
}
