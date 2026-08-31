#include <bits/stdc++.h>
using namespace std;
const long long MOD = 998244353;
long long n, a[100010], num[20], ans = 0, pw[30];
long long di(long long x) {
  long long ret = 0;
  while (x > 0) {
    ret++;
    x /= 10;
  }
  return ret;
}
int main() {
  pw[0] = 1;
  for (int i = 1; i <= 25; i++) pw[i] = pw[i - 1] * 10 % MOD;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    num[di(a[i])]++;
  }
  for (int i = 0; i < n; i++) {
    for (int j = 1; j <= 10; j++) {
      int x, now = a[i], ndn = 0;
      while (now > 0) {
        x = now % 10;
        now /= 10;
        if (j >= ndn + 1)
          ans = (ans + (pw[ndn * 2] + pw[ndn * 2 + 1]) * x * num[j]) % MOD;
        else
          ans = (ans + pw[ndn + j] * x * num[j] * 2) % MOD;
        ndn++;
      }
    }
  }
  cout << ans << endl;
  return 0;
}
