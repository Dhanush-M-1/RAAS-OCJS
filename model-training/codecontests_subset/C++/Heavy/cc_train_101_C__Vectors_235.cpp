#include <bits/stdc++.h>
using namespace std;
long long int mod = 1e9 + 7;
long long int mul(long long int a, long long int b) {
  return ((a % mod) * (b % mod)) % mod;
}
long long int add(long long int a, long long int b) {
  return ((a % mod) + (b % mod)) % mod;
}
long long int sub(long long int a, long long int b) {
  return ((a % mod) - (b % mod) + mod) % mod;
}
long long int po(long long int a, long long int b) {
  if (b == 0) {
    return 1;
  }
  long long int t = po(a, b / 2);
  if (b % 2) {
    return mul(t, mul(t, a));
  } else {
    return mul(t, t);
  }
}
long long int x1;
long long int x2;
long long int x3;
long long int yy1;
long long int y2;
long long int y3;
bool f(long long int X, long long int Y) {
  long long int d = x3 * x3 + y3 * y3;
  long long int dx = X * x3 + Y * y3;
  long long int dy = x3 * Y - y3 * X;
  if (d == 0) {
    if (dx == 0 && dy == 0 && X == 0 && Y == 0)
      return true;
    else
      return false;
  } else {
    if (dx % d == 0 && dy % d == 0)
      return true;
    else
      return false;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> x1 >> yy1 >> x2 >> y2 >> x3 >> y3;
  long long int m = 8;
  while (m--) {
    long long int X = x2 - x1, Y = y2 - yy1;
    if (f(X, Y)) {
      cout << "YES\n";
      exit(0);
    }
    long long int x = yy1, y = -x1;
    x1 = x, yy1 = y;
  }
  cout << "NO\n";
  return 0;
}
