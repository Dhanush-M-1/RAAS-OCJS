#include <bits/stdc++.h>
using namespace std;
void prime(long long int a, long long int &ans, vector<long long int> &v) {
  for (long long int i = 2; i * i <= a; i++) {
    while (a % i == 0) {
      ans++;
      if (v.size() < 2) v.push_back(i);
      a = a / i;
    }
  }
  if (a > 1) ans++;
  if (a > 1 && v.size() < 2) v.push_back(a);
}
long long int mod;
long long int expmod(long long int a, long long int b) {
  if (b == 1) return a;
  if (b == 0) return 1;
  long long int m1 = expmod(a, b / 2) % mod;
  if (b % 2) return ((m1 * m1) % mod * a % mod) % mod;
  return (m1 * m1) % mod;
}
long long int gcd(long long int a, long long int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long int lcm(long long int a, long long int b) {
  return (a * b) / gcd(a, b);
}
int main() {
  long long int n;
  cin >> n;
  long long int ans = 0;
  vector<long long int> v;
  prime(n, ans, v);
  if (n == 1 || ans == 1)
    cout << 1 << endl << 0;
  else if (ans > 2)
    cout << 1 << endl, cout << v[0] * v[1];
  else
    cout << 2;
}
