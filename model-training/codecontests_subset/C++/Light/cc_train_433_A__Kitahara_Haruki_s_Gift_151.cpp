#include <bits/stdc++.h>
using namespace std;
const long long INF = 1 << 28;
long long gcd(long long m, long long n) {
  long long r;
  while (n != 0) {
    r = m % n;
    m = n;
    n = r;
  }
  return m;
}
long long expmod(long long a, long long b) {
  long long x = 1, y = a;
  while (b > 0) {
    if (b & 1) x = (x * y) % 1000000007;
    y = (y * y) % 1000000007;
    b >>= 1;
  }
  return (x) % 1000000007;
}
long long inv(long long n) { return expmod(n, 1000000007 - 2); }
int main() {
  int n;
  cin >> n;
  int a = 0, b = 0;
  int sum = 0;
  for (int i = 0; i < n; i++) {
    int temp;
    cin >> temp;
    if (temp == 100)
      a++;
    else
      b++;
  }
  b = b % 2;
  if (b == 1) {
    if (a <= 1) {
      cout << "NO" << endl;
      return 0;
    }
    a = a - 2;
  }
  if (a % 2 == 1) {
    cout << "NO" << endl;
  } else
    cout << "YES" << endl;
  return 0;
}
