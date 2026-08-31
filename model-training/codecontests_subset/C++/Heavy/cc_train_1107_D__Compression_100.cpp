#include <bits/stdc++.h>
using namespace std;
char c;
int s[5300][5300], n;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j += 4) {
      cin >> c;
      int x;
      if (c >= '0' && c <= '9')
        x = c - '0';
      else
        x = c - 'A' + 10;
      for (int k = 0; k < 4; k++) {
        s[i][j + k] = (x >> (3 - k)) & 1;
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      s[i][j] += s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
    }
  }
  int flag, i;
  for (i = n; i >= 1; i--) {
    if (n % i) continue;
    flag = 1;
    for (int j = 1; j * i <= n; j++) {
      for (int k = 1; k * i <= n; k++) {
        int sum = s[i * j][i * k] - s[i * (j - 1)][i * k] -
                  s[i * j][i * (k - 1)] + s[i * (j - 1)][i * (k - 1)];
        if (sum != i * i && sum) {
          flag = 0;
          break;
        }
      }
      if (!flag) break;
    }
    if (flag) {
      cout << i << endl;
      return 0;
    }
  }
}
