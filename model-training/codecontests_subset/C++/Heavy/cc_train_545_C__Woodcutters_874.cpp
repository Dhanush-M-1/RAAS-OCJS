#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
const int inf = 1000009;
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
int n, x[100009], h[100009], done[100009];
int dp(int c, int last, int sum) {
  if (c == n) return sum;
  if (done[c] != -1) return done[c];
  if (last >= x[c]) return 0;
  if (x[c] - h[c] > last) return done[c] = dp(c + 1, x[c], sum + 1);
  int a = dp(c + 1, x[c] + h[c], sum + 1);
  int b = dp(c + 1, x[c], sum);
  return done[c] = max(a, b);
}
int main() {
  cin.tie(0);
  cout.tie(0);
  ios::sync_with_stdio(0);
  memset(done, -1, sizeof done);
  cin >> n;
  for (int i = 0; i < n; i++) cin >> x[i] >> h[i];
  cout << dp(0, -1000000009, 0);
  return 0;
}
