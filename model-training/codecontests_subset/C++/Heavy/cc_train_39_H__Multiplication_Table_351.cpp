#include <bits/stdc++.h>
using namespace std;
int a;
int s[15][15];
int main() {
  cin >> a;
  int n = a - 1;
  for (int i = 0; i <= n - 1; i++) {
    s[0][i] = i + 1;
  }
  for (int i = 0; i <= n - 1; i++) {
    s[i][0] = i + 1;
  }
  for (int i = 1; i <= n - 1; i++) {
    int x = s[i][0];
    for (int j = 1; j <= n - 1; j++) {
      int y = s[0][j];
      s[i][j] = x * y;
      int k = 0, ten = 1, f = s[i][j];
      while (f != 0) {
        int p = f % a;
        k += p * ten;
        f /= a;
        ten *= 10;
      }
      s[i][j] = k;
    }
  }
  for (int i = 0; i <= n - 1; i++) {
    for (int j = 0; j <= n - 1; j++) {
      cout << s[i][j] << " ";
    }
    cout << endl;
  }
  return 0;
}
