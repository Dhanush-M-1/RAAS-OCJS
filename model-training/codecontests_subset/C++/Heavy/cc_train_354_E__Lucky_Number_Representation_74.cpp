#include <bits/stdc++.h>
using namespace std;
int bad[9] = {1, 2, 3, 5, 6, 9, 10, 13, 17};
long long a[20];
int d[20][10];
long long ans[20];
long long ten[20];
int solve(int x, int rem) {
  int i, j, k, tmp, tmp1;
  if (x == -1) {
    if (rem == 0)
      return 1;
    else
      return 0;
  }
  if (d[x][rem] != -1) return d[x][rem];
  tmp = rem * 10 + a[x];
  for (i = 0; i <= 6; i++)
    for (j = 0; j <= 6; j++)
      if (i + j <= 6) {
        if ((tmp - i * 4 - j * 7 >= 0) && (tmp - i * 4 - j * 7 < 10)) {
          tmp1 = solve(x - 1, tmp - i * 4 - j * 7);
          if (tmp1 == 1) {
            for (k = 0; k < 6; k++)
              if (k < i)
                ans[k] += ten[x] * 4;
              else if (k < i + j)
                ans[k] += ten[x] * 7;
            return 1;
          }
        }
      }
  d[x][rem] = 0;
  return 0;
}
int main() {
  int i, l, t, m, tmp;
  long long n;
  ten[0] = 1;
  for (i = 1; i <= 18; i++) ten[i] = ten[i - 1] * 10;
  cin >> t;
  for (l = 0; l < t; l++) {
    cin >> n;
    for (i = 0; i < 9; i++)
      if (n == bad[i]) {
        cout << "-1" << endl;
        break;
      }
    if (i < 9) continue;
    m = 0;
    while (n > 0) {
      a[m] = n % 10;
      m++;
      n /= 10;
    }
    memset(d, -1, sizeof(d));
    memset(ans, 0, sizeof(ans));
    tmp = solve(m - 1, 0);
    if (tmp == 0)
      cout << "-1" << endl;
    else {
      for (i = 0; i < 6; i++) {
        if (i != 0) cout << " ";
        cout << ans[i];
      }
      cout << endl;
    }
  }
}
