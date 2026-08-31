#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long pmod(long long n, long long a, long long m) {
  long long ans = 1;
  long long k = n;
  while (a) {
    if (a % 2 == 1) {
      ans = ((ans % m) * (k % m)) % m;
    }
    k = ((k % m) * (k % m)) % m;
    a /= 2;
  }
  return ans;
}
void solve() {
  long long mod = 1e+9;
  mod += 7;
  long long a, b, c;
  cin >> a >> b >> c;
  long long u = a * c - b * c;
  long long k = u / b;
  if (u % b != 0) k++;
  cout << k;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int tc = 1;
  while (tc--) {
    solve();
  }
}
