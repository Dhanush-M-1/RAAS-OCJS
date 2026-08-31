#include <bits/stdc++.h>
using namespace std;
long long power(long long a, long long b, long long mod) {
  long long res = 1;
  a %= mod;
  assert(b >= 0);
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
long long power(long long a, long long b) {
  long long res = 1;
  assert(b >= 0);
  for (; b; b >>= 1) {
    if (b & 1) res = res * a;
    a = a * a;
  }
  return res;
}
long long min(long long a, long long b) { return (a < b) ? a : b; }
long long max(long long a, long long b) { return (a > b) ? a : b; }
long long gcd(long long a, long long b) {
  if (a == 0) return b;
  return gcd(b % a, a);
}
void bwayne() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
bool cmp(long long a, long long b) {
  if (a <= b) return false;
  return true;
}
void solve() {
  long long a, b, c;
  cin >> a >> b >> c;
  int flag = 0;
  long long ans = 0;
  while (1) {
    flag = 0;
    if (c >= 2 && b >= 1) {
      ans += 3;
      flag = 1;
      b -= 1;
      c -= 2;
    } else if (a >= 1 && b >= 2) {
      ans += 3;
      b -= 2;
      a -= 1;
      flag = 1;
    }
    if (flag == 0) {
      break;
    }
  }
  cout << ans << endl;
}
int main() {
  bwayne();
  long long t = 1;
  cin >> t;
  for (long long tt = 1; tt <= t; tt++) {
    solve();
  }
  return 0;
}
