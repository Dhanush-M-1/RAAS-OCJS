#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
const long long mod = 998244353;
int a[N];
int vis[20], n;
long long sum[20];
long long powmod(long long a, long long b) {
  long long res = 1;
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
int cal(int x) {
  int res = 0;
  while (x) {
    x /= 10;
    res++;
  }
  return res;
}
long long go(int x) {
  long long res = 0;
  stack<long long> q1, q2, q3;
  while (x) {
    long long d = x % 10;
    x /= 10;
    q1.push(d);
  }
  long long d = 0;
  q3.push(0);
  while (q1.size()) {
    d++;
    q2.push(q1.top());
    q3.push((q3.top() * 10 % mod + 2 * q1.top() % mod) % mod);
    q1.pop();
  }
  q3.pop();
  d = 1;
  long long tmp = 0;
  while (q2.size() > 1) {
    long long d1 = q2.top();
    long long d2 = q3.top();
    d1 = (d1 * 10 % mod + d1) % mod * powmod(100, d - 1) % mod + tmp;
    d1 %= mod;
    d2 = d2 * powmod(100, d) % mod;
    d2 %= mod;
    tmp = d1;
    res = (res + (d1 + d2) * vis[d] % mod) % mod;
    q2.pop();
    q3.pop();
    d++;
  }
  long long d1 = q2.top();
  long long d2 = q3.top();
  d1 = (d1 * 10 % mod + d1) % mod * powmod(100, d - 1) % mod + tmp;
  d1 %= mod;
  d2 = d2 * powmod(100, d) % mod;
  d2 %= mod;
  tmp = d1;
  res = (res + (d1 + d2) * sum[d] % mod) % mod;
  q2.pop();
  q3.pop();
  d++;
  return res;
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> a[i];
    vis[cal(a[i])]++;
  }
  int j = 0;
  sort(a + 1, a + 1 + n);
  long long ans = 0;
  sum[10] = vis[10];
  for (int i = 9; i >= 1; --i) {
    sum[i] = (sum[i + 1] + vis[i]) % mod;
  }
  j = 0;
  for (int i = 1; i <= n; ++i) {
    ans = (ans + go(a[i])) % mod;
  }
  printf("%lld\n", ans % mod);
  return 0;
}
