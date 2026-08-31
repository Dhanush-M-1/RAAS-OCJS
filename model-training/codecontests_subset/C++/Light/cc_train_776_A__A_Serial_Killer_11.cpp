#include <bits/stdc++.h>
using namespace std;
long long GCD(long long a, long long b) {
  if (b == 0) return a;
  return GCD(b, a % b);
}
long long LCM(long long a, long long b) {
  long long gcd = GCD(a, b);
  return (a * b) / gcd;
}
int main() {
  long long i, j, k, n, m, t, x, y, s = 0;
  string a, b, c, d;
  cin >> a >> b >> n;
  cout << a << " " << b << endl;
  while (n--) {
    cin >> c >> d;
    if (c == a) {
      a = d;
      cout << a << " " << b << endl;
    } else if (c == b) {
      b = d;
      cout << a << " " << b << endl;
    }
  }
}
