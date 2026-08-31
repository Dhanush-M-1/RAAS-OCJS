#include <bits/stdc++.h>
using namespace std;
const int mod = 1000000007;
int power(int x, int y) {
  int res = 1;
  x = x % mod;
  while (y > 0) {
    if (y & 1) res = (res * x) % mod;
    y = y >> 1;
    x = (x * x) % mod;
  }
  return res;
}
int ncr(int n, int r) {
  int res = 1;
  if (r > n - r) r = n - r;
  for (int i = 0; i < r; i++) {
    res *= (n - i);
    res /= (i + 1);
  }
  return res;
}
int gcd(int a, int b) {
  if (a == 0) return b;
  return gcd(b % a, a);
}
int lcm(int a, int b) { return (a / gcd(a, b) * b); }
int max(int a, int b) {
  int ans = a > b ? a : b;
  return ans;
}
int min(int a, int b) {
  int ans = a < b ? a : b;
  return ans;
}
int main() {
  long long n, b, t = 0;
  cin >> n >> b;
  while (n >= b) {
    n = n - b + 1;
    t += b;
  }
  cout << t + n;
}
