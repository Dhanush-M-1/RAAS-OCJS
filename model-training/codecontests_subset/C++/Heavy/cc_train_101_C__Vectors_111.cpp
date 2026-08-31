#include <bits/stdc++.h>
using namespace std;
bool valid(long long num, long long den) {
  if (den == 0) {
    return num == 0;
  } else {
    return (num % den) == 0;
  }
}
long long gcd(long long a, long long b) {
  if (b == 0) {
    return a;
  } else {
    return gcd(b, a % b);
  }
}
bool valid(long long a, long long b, long long c) {
  if (a == 0 && b == 0) {
    return c == 0;
  }
  if (a < 0) {
    a = -a;
  }
  if (b < 0) {
    b = -b;
  }
  return c % gcd(a, b) == 0;
}
int main() {
  long long ax, ay, bx, by, cx, cy;
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  long long a_x = -ay, a_y = ax;
  long long c_x = -cy, c_y = cx;
  for (long long a = -1; a <= 1; ++a) {
    for (long long a_ = -1; a_ <= 1; ++a_) {
      if (abs(a) + abs(a_) == 1) {
        long long X = bx - a * ax - a_ * a_x;
        long long Y = by - a * ay - a_ * a_y;
        long long num1 = X * c_y - Y * c_x;
        long long den1 = cx * c_y - cy * c_x;
        long long num2 = X * cy - Y * cx;
        long long den2 = c_x * cy - c_y * cx;
        bool ok;
        if (den1 != 0 && den2 != 0) {
          ok = (num1 % den1) == 0 && (num2 % den2) == 0;
        } else {
          if (cx == 0 && c_x == 0) {
            ok = X == 0 && valid(cy, c_y, Y);
          } else if (cy == 0 && c_y == 0) {
            ok = Y == 0 && valid(cx, c_x, X);
          } else {
            if (cx == 0) {
              ok = (X % c_x) == 0 && (Y % c_y) == 0 && X / c_x == Y / c_y;
            } else if (c_x == 0) {
              ok = (X % cx) == 0 && (Y % cy) == 0 && X / cx == Y / cy;
            } else {
              ok = valid(cx, c_x, X) && X * cy == Y * cx;
            }
          }
        }
        if (ok) {
          cout << "YES" << endl;
          return 0;
        }
      }
    }
  }
  cout << "NO" << endl;
  return 0;
}
