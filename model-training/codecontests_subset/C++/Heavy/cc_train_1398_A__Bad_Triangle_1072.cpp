#include <bits/stdc++.h>
using namespace std;
double pi = acos(-1);
long long i, j;
long long mx = (1ll << 48) - 1, fb[100];
bool ff[100010];
long long gcd(long long x, long long y) { return y ? gcd(y, x % y) : x; }
long long C(long long n, long long m) {
  if (m < 0 || m > n) return 0;
  long long ans = 1;
  for (long long i = 1; i <= m; i++) ans = ans * (n - m + i) / i;
  return ans;
}
long long binaryPow(long long a, long long b) {
  long long ans = 1;
  while (b > 0) {
    if (b & 1) {
      ans = ans % 998244353 * a;
    }
    a = a * a % 998244353;
    b >>= 1;
  }
  return ans % 998244353;
}
long long niyuan(long long a, long long b) {
  return (a * binaryPow(b, 998244353 - 2)) % 998244353;
}
void exgcd(int a, int b, int &d, int &x, int &y) {
  if (!b) {
    d = a;
    x = 1;
    y = 0;
  } else {
    exgcd(b, a % b, d, y, x);
    y -= x * (a / b);
  }
}
long long a[6000005];
void gg() {
  long long n;
  scanf("%lld", &n);
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  if (a[1] + a[2] <= a[n])
    cout << 1 << ' ' << 2 << ' ' << n << '\n';
  else
    cout << -1 << '\n';
}
int main() {
  long long t;
  scanf("%lld", &t);
  while (t--) gg();
}
