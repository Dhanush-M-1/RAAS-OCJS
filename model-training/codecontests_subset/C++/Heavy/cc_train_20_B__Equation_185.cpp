#include <bits/stdc++.h>
int nextInt() {
  int x;
  scanf("%d", &x);
  return x;
}
double nextDouble() {
  double x;
  scanf("%lf", &x);
  return x;
}
long long nextLong() {
  long long x;
  scanf("%I64d", &x);
  return x;
}
char nextChar() {
  char x;
  scanf("%c", &x);
  return x;
}
void newLine() { printf("\n"); }
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
long long lcm(long long a, long long b) { return (a * b) / gcd(a, b); }
long long pow(long long a, long long b, long long MOD) {
  long long x = 1, y = a;
  while (b > 0) {
    if (b % 2 == 1) {
      x = (x * y);
      if (x > MOD) x %= MOD;
    }
    y = (y * y);
    if (y > MOD) y %= MOD;
    b /= 2;
  }
  return x;
}
int countSetBit(long long n) {
  int ans = 0;
  while (n != 0) {
    n -= (n & -n);
    ++ans;
  }
  return ans;
}
long long mod = 1e9 + 7;
const int N = 30;
const int M = 55;
const double eps = 1e-6;
using namespace std;
int dp[N][N] = {0};
int g[N][N];
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  cout << fixed << setprecision(10);
  if (a == 0 && b == 0 && c == 0) {
    cout << -1 << endl;
    return 0;
  }
  if (a == 0 && b == 0 && c != 0) {
    cout << 0 << endl;
    return 0;
  }
  if (a == 0 && b != 0) {
    cout << "1\n" << -c / b << endl;
    return 0;
  }
  if (a != 0 && b == 0) {
    if (-1.0 * c / a == 0)
      cout << "1\n0.000000" << endl;
    else if (-1.0 * c / a < 0)
      cout << 0 << endl;
    else
      cout << "2\n"
           << sqrt(-1.0 * c / a) << "\n"
           << -1.0 * sqrt(-1.0 * c / a) << endl;
    return 0;
  }
  double delta = b * b - 4 * a * c;
  if (delta < 0) {
    cout << 0 << endl;
    return 0;
  }
  double sq = sqrt(delta);
  double x1 = (-b - sq) / (2 * a);
  double x2 = (-b + sq) / (2 * a);
  if (x1 - x2 > eps) swap(x1, x2);
  if (delta == 0)
    cout << "1\n" << x1 << endl;
  else {
    cout << "2\n" << x1 << "\n" << x2 << endl;
  }
}
