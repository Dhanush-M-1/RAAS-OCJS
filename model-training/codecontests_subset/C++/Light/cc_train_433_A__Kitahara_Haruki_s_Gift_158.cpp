#include <bits/stdc++.h>
using namespace std;
int f[1000], k[1000][2];
int main() {
  int n, sum = 0, t;
  scanf("%d", &n);
  int k1 = 0, k2 = 0;
  for (int i = 0; i < n; i++) {
    scanf("%d", &t);
    if (t == 100)
      k1++;
    else
      k2++;
  }
  sum = k1 + k2 * 2;
  if (sum % 2 != 0) {
    cout << "NO";
    return 0;
  }
  sum /= 2;
  f[0] = 1;
  k[0][0] = k1;
  k[0][1] = k2;
  for (int i = 0; i <= sum; i++)
    if (f[i]) {
      if (!f[i + 1] && k[i][0]) {
        f[i + 1] = 1;
        k[i + 1][0] = k[i][0] - 1;
        k[i + 1][1] = k[i][1];
      }
      if (!f[i + 2] && k[i][1]) {
        f[i + 2] = 1;
        k[i + 2][0] = k[i][0];
        k[i + 2][1] = k[i][1] - 1;
      }
    }
  if (f[sum])
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
