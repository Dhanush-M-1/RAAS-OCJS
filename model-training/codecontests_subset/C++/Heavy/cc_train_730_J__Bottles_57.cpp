#include <bits/stdc++.h>
using namespace std;
long long Set(long long n, long long pos) { return (n = n | 1 << pos); }
long long reset(long long N, long long pos) { return N = N & ~(1 << pos); }
bool check(long long N, long long pos) { return (bool)(N & (1 << pos)); }
long long pow(long long a, long long b, long long mod) {
  long long x = 1, y = a;
  while (b > 0) {
    if (b % 2 == 1) {
      x = (x * y);
      if (x > mod) x %= mod;
    }
    y = (y * y);
    if (y > mod) y %= mod;
    b /= 2;
  }
  return x;
}
long long modInverse(long long a, long long m) { return pow(a, m - 2, m); }
const long long LARGE = powl(10, 18);
long long n;
long long arr[201], brr[201];
long long total = 0;
pair<long long, long long> dp[201][20100];
bool vis[201][20100];
pair<long long, long long> fun(long long idx, long long have) {
  if (idx == n) {
    if (have >= total) {
      return make_pair(0, 0);
    } else
      return make_pair(INT_MAX, INT_MAX);
  }
  if (vis[idx][have] != 0) return dp[idx][have];
  vis[idx][have] = 1;
  pair<long long, long long> ans = make_pair(INT_MAX, INT_MAX);
  ans = min(ans, make_pair(1 + fun(idx + 1, have + brr[idx]).first,
                           -arr[idx] + fun(idx + 1, have + brr[idx]).second));
  ans = min(ans, fun(idx + 1, have));
  return dp[idx][have] = ans;
}
int main() {
  while (cin >> n) {
    total = 0;
    memset(vis, 0, sizeof vis);
    for (int i = 0; i < n; i++) cin >> arr[i], total += arr[i];
    for (int i = 0; i < n; i++) cin >> brr[i];
    pair<long long, long long> ans = fun(0, 0);
    cout << ans.first << " " << total + ans.second << endl;
  }
}
