#include <bits/stdc++.h>
using namespace std;
int TestMillerRabin[12] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
long long mulmod(long long a, long long b, long long p) {
  long long x = 0, y = a % p;
  while (b > 0) {
    if (b % 2 == 1) x = (x + y) % p;
    y = (1LL * y * 2) % p;
    b = b / 2;
  }
  return x % p;
}
long long fastexp(long long x, long long y, long long p) {
  long long ans = 1;
  while (y > 0) {
    if (y & 1) ans = (1LL * ans * x) % p;
    y = y >> 1;
    x = (1LL * x * x) % p;
  }
  return ans % p;
}
long long fastexpp(long long x, long long y, long long p) {
  long long ans = 1;
  while (y > 0) {
    if (y & 1) ans = mulmod(ans, x, p);
    y = y >> 1;
    x = mulmod(x, x, p);
  }
  return ans % p;
}
long long invmod(long long x, long long p) { return fastexp(x, p - 2, p) % p; }
bool check_composite(long long n, long long a, long long d, int s) {
  long long x = fastexp(a, d, n);
  if (x == 1 || x == n - 1) return false;
  for (int r = 1; r < s; r++) {
    x = (1LL * x * x) % n;
    if (x == n - 1) return false;
  }
  return true;
}
bool isPrime(long long p) {
  if (p <= 1) return false;
  int r = 0;
  long long d = p - 1;
  while (!(d & 1)) {
    d >>= 1;
    r++;
  }
  for (int i = 0; i < 12; i++) {
    int value = TestMillerRabin[i];
    if (p == value) return true;
    if (check_composite(p, value, d, r)) return false;
  }
  return true;
}
int main() {
  int A, B, C;
  cin >> A >> B >> C;
  if (A == 0) {
    if (B == 0) {
      if (C == 0)
        cout << "-1\n";
      else
        cout << "0\n";
    } else {
      cout << 1 << '\n';
      double ans = -1 * (double)C / (double)B;
      printf("%.5lf\n", ans);
    }
  } else {
    long long det = 1LL * B * B - 4LL * A * C;
    if (det > 0) {
      cout << "2\n";
      double ans1 = (-B + sqrt((double)det)) / (2 * (double)A);
      double ans2 = (-B - sqrt((double)det)) / (2 * (double)A);
      if (ans1 > ans2) {
        double aux = ans1;
        ans1 = ans2;
        ans2 = aux;
      }
      printf("%.8lf\n%.8lf\n", ans1, ans2);
      return 0;
    }
    if (det == 0) {
      cout << "1\n";
      double ans = -1 * (double)B / (2 * (double)A);
      printf("%.8lf\n", ans);
    } else {
      cout << "0\n";
    }
  }
  return 0;
}
