#include <bits/stdc++.h>
using namespace std;
inline long long int max(long long int a, long long int b, long long int c) {
  return max(max(a, b), c);
}
inline long long int min(long long int a, long long int b, long long int c) {
  return min(min(a, b), c);
}
inline long long int max(long long int a, long long int b) {
  return (a > b) ? a : b;
}
inline long long int min(long long int a, long long int b) {
  return (a < b) ? a : b;
}
inline long long int add(long long int x, long long int y, long long int mod_) {
  return (x + y >= mod_) ? x + y - mod_ : x + y;
}
inline long long int mul(long long int x, long long int y, long long int mod_) {
  return ((x % mod_) * 1LL * (y % mod_)) % mod_;
}
long long int power(long long int a, long long int n) {
  long long int p = 1;
  while (n > 0) {
    if (n % 2) {
      p = p * a;
    }
    n >>= 1;
    a *= a;
  }
  return p;
}
long long int powm(long long int a, long long int n, long long int mod_) {
  long long int p = 1;
  while (n) {
    if (n % 2) {
      p = mul(p, a, mod_);
    }
    n >>= 1;
    a = mul(a, a, mod_);
  }
  return p % mod_;
}
long long int powi(long long int a, long long int mod_) {
  return powm(a, mod_ - 2, mod_);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  ;
  cout << setprecision(15);
  long long int mn, mx;
  long long int n, m, t, k, i, j, sum = 0, flag = 0, cnt = 0;
  long long int x = 0, y = 0, z, l, r, q;
  int TC = 1;
  while (TC--) {
    double a, b, c;
    cin >> a >> b >> c;
    if (a != 0) {
      if (b * b - 4 * a * c < 0)
        cout << 0;
      else if (b * b - 4 * a * c == 0)
        cout << 1 << '\n' << (-b) / (2.0 * a);
      else {
        cout << "2\n";
        double D = sqrtl(b * b - 4 * a * c);
        double x = (-b + D) / (2.0 * a);
        double y = (-b - D) / (2.0 * a);
        if (x < y) {
          cout << x << '\n' << y;
        } else
          cout << y << '\n' << x;
      }
    } else if (b != 0) {
      cout << 1 << '\n' << (-c / b);
    } else {
      if (c != 0)
        cout << 0;
      else
        cout << -1;
    }
  }
  cerr << "Time : " << 1000 * ((double)clock()) / (double)CLOCKS_PER_SEC
       << "ms\n";
  return 0;
}
