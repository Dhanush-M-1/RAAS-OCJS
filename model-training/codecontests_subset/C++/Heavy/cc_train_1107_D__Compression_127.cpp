#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("O3")
const int mod = (1e9) + 7;
const double eps = 1e-10;
const int siz = 3e5 + 5, siz2 = 33, lg = 21, block = 317, block2 = 1000,
          mxv = 1e6;
const long long idnt[2] = {LLONG_MAX, LLONG_MIN};
int n;
bool arr[5205][5205], diff[5205];
char str[1305];
int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%s", str);
    for (int j = 0; j < n / 4; j++) {
      int val = str[j] >= 'A' ? str[j] - 'A' + 10 : str[j] - '0';
      for (int mask = 1 << 3, k = 1; mask > 0; mask >>= 1, k++) {
        arr[i][j * 4 + k] = (bool)(val & mask);
      }
    }
  }
  diff[n] = true;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      if (i < n && arr[i][j] != arr[i + 1][j]) {
        diff[i] = true;
      }
      if (j < n && arr[i][j] != arr[i][j + 1]) {
        diff[j] = true;
      }
    }
  }
  int g = 0;
  for (int i = 1; i <= n; i++) {
    if (diff[i]) {
      g = gcd(g, i);
    }
  }
  printf("%d\n", g);
  return 0;
}
