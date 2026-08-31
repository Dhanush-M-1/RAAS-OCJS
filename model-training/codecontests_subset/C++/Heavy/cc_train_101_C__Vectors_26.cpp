#include <bits/stdc++.h>
using namespace std;
long long A, B, x, y, Cx, Cy;
bool ok(long long x, long long y, long long A, long long B, long long Cx,
        long long Cy) {
  if (Cx * Cx + Cy * Cy == 0) {
    bool flg = 0;
    if (x == A && y == B) flg = 1;
    if (y == A && -x == B) flg = 1;
    if (-x == A && -y == B) flg = 1;
    if (-y == A && x == B) flg = 1;
    return flg;
  }
  bool flg = 0;
  if (x == A && y == B) flg = 1;
  if (y == A && -x == B) flg = 1;
  if (-x == A && -y == B) flg = 1;
  if (-y == A && x == B) flg = 1;
  if (flg == 1) {
    return 1;
  }
  long long M = Cx * Cx + Cy * Cy;
  long long tmp = (B - y) * Cx - Cy * (A - x);
  if (tmp % M == 0) {
    long long k2 = tmp / M;
    if (Cx) {
      if (Cx < 0) Cx = -Cx;
      long long ret = (A - x) % Cx + (k2 % Cx) * Cy % Cx;
      ret %= Cx;
      if (ret < 0) ret += Cx;
      if (ret == 0) flg = 1;
    }
    if (Cy) {
      if (Cy < 0) Cy = -Cy;
      long long ret = (B - y) % Cy - (k2 % Cy) * Cx % Cy;
      ret %= Cy;
      if (ret < 0) ret += Cy;
      if (ret == 0) flg = 1;
    }
    return flg;
  } else
    return 0;
}
int main() {
  while (cin >> x >> y >> A >> B >> Cx >> Cy) {
    bool flg = 0;
    flg |= ok(x, y, A, B, Cx, Cy);
    flg |= ok(x, y, -A, -B, Cx, Cy);
    flg |= ok(x, y, -B, A, Cx, Cy);
    flg |= ok(x, y, B, -A, Cx, Cy);
    puts(flg ? "YES" : "NO");
  }
  return 0;
}
