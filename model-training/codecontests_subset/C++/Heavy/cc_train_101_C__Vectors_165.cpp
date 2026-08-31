#include <bits/stdc++.h>
using namespace std;
bool solve(long long a, long long b, long long c, long long d, long long e,
           long long f) {
  if ((e || f) && (!a && !b && !c && !d)) return false;
  long long det = a * d - b * c;
  if (det == 0) {
    return abs(f * a) == abs(c * e);
  } else {
    return abs(d * e - b * f) % det == 0 && abs(-c * e + a * f) % det == 0;
  }
}
int ax, ay, bx, by, cx, cy;
int main() {
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  bool flag = false;
  for (int i = 0; i < 4; i++) {
    if (solve(cx, -cy, cy, cx, bx - ax, by - ay)) flag = true;
    swap(ax, ay);
    ax = -ax;
  }
  printf("%s\n", flag ? "YES" : "NO");
}
