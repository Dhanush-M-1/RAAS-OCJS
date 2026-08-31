#include <bits/stdc++.h>
using namespace std;
inline long long rint() {
  long long x = 0, f = 1;
  char c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = x * 10 + c - '0';
    c = getchar();
  }
  return x * f;
}
inline long long gcd(long long a, long long b) {
  return (b) ? gcd(b, a % b) : a;
}
inline long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
inline long long pow(long long a, long long b, long long q) {
  long long rtn = 1;
  while (b) {
    if (b & 1) rtn = rtn * a % q;
    a = a * a % q;
    b >>= 1;
  }
  return rtn;
}
inline long long mysqrt(long long n) {
  long long x = sqrt(n);
  while (x * x < n) x++;
  while (x * x > n) x--;
  return x;
}
const long long MOD = 998244353;
int n;
int siz[20], s[20];
vector<int> a[101010];
long long ans;
void upd(long long &a, long long b) {
  a = a + b;
  a %= MOD;
}
void solve(vector<int> &sb) {
  upd(ans, sb[0] * n % MOD);
  upd(ans, sb[0] * n % MOD * 10 % MOD);
  for (int i = (1); i < (sb.size()); i++) {
    long long bas = 1;
    for (int j = (0); j < (i); j++) bas = bas * 10 % MOD;
    for (int j = (1); j < (i); j++) {
      bas = bas * 10 % MOD;
      upd(ans, sb[i] * bas % MOD * siz[j] % MOD * 2 % MOD);
    }
    bas = bas * 10 % MOD;
    upd(ans, sb[i] * bas % MOD * siz[i] % MOD * 2 % MOD);
    upd(ans, sb[i] * bas % MOD * (s[19] - s[i]) % MOD);
    bas = bas * 10 % MOD;
    upd(ans, sb[i] * bas % MOD * (s[19] - s[i]) % MOD);
  }
}
int main() {
  n = rint();
  for (int i = (0); i < (n); i++) {
    int t = rint();
    while (t != 0) {
      a[i].push_back(t % 10);
      t /= 10;
    }
    siz[a[i].size()]++;
  }
  for (int i = (1); i < (20); i++) s[i] = s[i - 1] + siz[i];
  for (int i = (0); i < (n); i++) solve(a[i]);
  cout << ans << "\n";
  return 0;
}
