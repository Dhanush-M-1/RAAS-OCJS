#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const int MAX = 100005;
long long modexp(long long x, long long n) {
  if (n == 0) return 1LL;
  if (n % 2 == 0) {
    long long y = modexp(x, n / 2) % mod;
    return (y * y) % mod;
  }
  return (x * modexp(x, n - 1) % mod) % mod;
}
long long powr(long long x, long long n) {
  long long ans = 1;
  for (int i = 1; i <= n; i++) ans = ans * x;
  return ans;
}
int main() {
  int n;
  scanf("%d", &n);
  string s;
  cin >> s;
  int f[10] = {0};
  for (int i = 0; i < n; i++) {
    f[s[i] - '0']++;
  }
  int ans = 0;
  while (f[8]) {
    int len = 1;
    f[8]--;
    for (int i = 0; i < 10; i++) {
      if (i == 8 || f[i] == 0) continue;
      if (f[i] < (11 - len)) {
        len += f[i];
        f[i] = 0;
      } else {
        f[i] -= (11 - len);
        len = 11;
        break;
      }
    }
    if (len == 11)
      ans++;
    else if (f[8] >= (11 - len)) {
      f[8] -= (11 - len);
      ans++;
    } else
      break;
  }
  printf("%d\n", ans);
  return 0;
}
