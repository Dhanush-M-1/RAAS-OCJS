#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
long long powmod(long long a, long long b) {
  long long res = 1;
  a %= mod;
  assert(b >= 0);
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
const int N = 1e5 + 10;
int n;
long long l, r;
long long sum[N];
int cal(long long x) {
  if (x > sum[n - 1]) return 1;
  int idx = lower_bound(sum, sum + n, x) - sum;
  int num = x - sum[idx - 1];
  if (num & 1) return idx;
  return idx + num / 2;
}
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    scanf("%d%lld%lld", &n, &l, &r);
    for (int i = 1; i < n; i++) {
      sum[i] = sum[i - 1] + 2ll * (n - i);
    }
    for (long long i = l; i <= r; i++) {
      printf("%d ", cal(i));
    }
    puts("");
  }
  return 0;
}
