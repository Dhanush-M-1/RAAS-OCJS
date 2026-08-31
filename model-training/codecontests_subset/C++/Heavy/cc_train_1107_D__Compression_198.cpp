#include <bits/stdc++.h>
using namespace std;
char s[5250];
int b[5250][5250];
int main() {
  int n, i, j, k;
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> s;
    for (int j = 0; j < n; j++) {
      int val;
      if (s[j] >= '0' && s[j] <= '9')
        val = s[j] - '0';
      else
        val = s[j] - 'A' + 10;
      b[i][j * 4 + 1] = val / 8 % 2;
      b[i][j * 4 + 2] = val / 4 % 2;
      b[i][j * 4 + 3] = val / 2 % 2;
      b[i][j * 4 + 4] = val % 2;
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      b[i][j] = b[i][j] + b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1];
    }
  }
  for (i = n; i >= 1; i--) {
    if (n % i != 0) continue;
    int flag = 1;
    for (j = i; j <= n; j += i) {
      for (k = i; k <= n; k += i) {
        int sum = b[j][k] - b[j - i][k] - b[j][k - i] + b[j - i][k - i];
        if (sum != 0 && sum != i * i) {
          flag = 0;
          break;
        }
      }
    }
    if (flag == 1) {
      cout << i << endl;
      return 0;
    }
  }
}
