#include <bits/stdc++.h>
using namespace std;
int a[1024], n, x, fr[1024], dp[1024], i, j, pl;
int main() {
  cin >> n >> x;
  dp[0] = 1;
  for (i = 1; i <= n; i++) {
    cin >> a[i];
    fr[a[i]]++;
  }
  for (i = 1; i <= n; i++)
    if (!fr[i]) {
      int c = 0, flag = -1;
      for (j = i; j; j = a[j]) {
        if (j == x) flag = c;
        c++;
      }
      if (flag >= 0) {
        pl = c - flag;
        continue;
      }
      for (j = n; j >= c; j--) dp[j] |= dp[j - c];
    }
  for (i = 0; i <= n; i++)
    if (dp[i]) cout << i + pl << endl;
}
