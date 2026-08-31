#include <bits/stdc++.h>
using namespace std;
int n;
int a[100005];
int d[100005];
long long cnt[100];
long long cumsum[100];
long long f[2 * 100005];
long long ans;
int count_digits(int x) {
  if (x == 0) return 1;
  int cnt = 0;
  while (x > 0) {
    cnt++;
    x /= 10;
  }
  return cnt;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  f[0] = 1;
  for (int i = 1; i <= 200002; i++) f[i] = f[i - 1] * 10 % 998244353;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    d[i] = count_digits(a[i]);
    cnt[d[i]]++;
  }
  for (int i = 1; i <= 20; i++) cumsum[i] = cnt[i] + cumsum[i - 1];
  for (int i = 1; i <= n; i++) {
    int d2 = d[i];
    for (int dig = 1; dig <= d2; dig++) {
      long long x = a[i];
      for (int j = 0; j < dig; j++) {
        ans += f[2 * j] * cnt[dig] % 998244353 * (x % 10) % 998244353;
        ans %= 998244353;
        ans += f[2 * j + 1] * cnt[dig] % 998244353 * (x % 10) % 998244353;
        ans %= 998244353;
        x /= 10;
      }
      ans += f[2 * dig] * cnt[dig] % 998244353 * x * 2 % 998244353;
      ans %= 998244353;
    }
    long long x = a[i];
    for (int j = 0; j < d2; j++) {
      ans += f[2 * j] * (n - cumsum[d2]) % 998244353 * (x % 10) % 998244353;
      ans %= 998244353;
      ans += f[2 * j + 1] * (n - cumsum[d2]) % 998244353 * (x % 10) % 998244353;
      ans %= 998244353;
      x /= 10;
    }
  }
  cout << ans % 998244353;
  return 0;
}
