#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  if (a % b == 0) return b;
  return gcd(b, a % b);
}
bool sub_main(long long X, long long Y, long long x, long long y) {
  if (x == 0 && y == 0) {
    if (X == 0 && Y == 0)
      cout << "YES" << endl;
    else
      return false;
    return true;
  }
  long long left = x * x + y * y;
  long long right = x * Y - X * y;
  if (right % left == 0) {
    long long tmp = right / left;
    if (x != 0 && (X + y * tmp) % x == 0) {
      cout << "YES" << endl;
      return true;
    } else if (x == 0 && X + y * tmp == 0 && (Y - x * tmp) % y == 0) {
      cout << "YES" << endl;
      return true;
    }
  }
  return false;
}
int main() {
  long long ax, ay, bx, by, cx, cy;
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  for (long long i = 0; i < ((long long)4); i++) {
    long long tmp = ax;
    ax = -ay;
    ay = tmp;
    if (sub_main(bx - ax, by - ay, cx, cy)) return 0;
  }
  cout << "NO" << endl;
  return 0;
}
