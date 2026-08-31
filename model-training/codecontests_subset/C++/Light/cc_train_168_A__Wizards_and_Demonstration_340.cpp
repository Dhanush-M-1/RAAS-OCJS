#include <bits/stdc++.h>
using namespace std;
const long double PI = 3.1415926535897;
int gcd(int a, int b) {
  if (a == 0) return b;
  return gcd(b % a, a);
}
long long exp(long long base, long long power, int p) {
  if (!base) return 0;
  long long t = exp(base, power / 2, p);
  if (power & 1)
    return t * t * base % p;
  else
    return t * t % p;
}
void solve() {
  int n, x, y;
  cin >> n >> x >> y;
  cout << max(0, (int)ceil(n * y / 100.0) - x);
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) solve();
  return 0;
}
