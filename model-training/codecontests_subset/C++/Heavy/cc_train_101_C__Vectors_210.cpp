#include <bits/stdc++.h>
using namespace std;
const int maxint = -1u >> 1;
struct node {
  long long x, y;
};
node A, B, C;
int gao2(long long ax, long long ay, long long bx, long long by, long long cx,
         long long cy) {
  if (cx == 0 && cy == 0) {
    if (ax != bx || ay != by)
      return 0;
    else
      return 1;
  }
  if (cx == 0) {
    if (ax == bx && (by - ay) % cy == 0 && (by - ay) / cy >= 0) return 1;
    if ((ax + by) % cy == 0 && (ax + by) / cy >= 0 && (bx - ay) % cy == 0 &&
        (bx - ay) / cy >= 0)
      return 1;
    return 0;
  }
  if (cy == 0) {
    if (ay == by && (bx - ax) % cx == 0 && (bx - ax) / cx >= 0) return 1;
    if ((bx - ay) % cx == 0 && (bx - ay) / cx >= 0 && (-by - ax) % cx == 0 &&
        (-ax - by) / cx >= 0)
      return 1;
    return 0;
  }
  long long a = ax + by;
  long long b = bx - ay;
  if ((bx - ax) % cx == 0 && (by - ay) % cy == 0 && (bx - ax) * cx >= 0 &&
      (by - ay) * cy >= 0 && (bx - ax) / cx == (by - ay) / cy)
    return 1;
  long long x = (b * cy - a * cx) / (cy * cy + cx * cx);
  long long y = (a * cy + b * cx) / (cy * cy + cx * cx);
  if (x < 0 || y < 0) return 0;
  if (y * cy - x * cx != a || x * cy + y * cx != b) return 0;
  return 1;
}
int gao(long long ax, long long ay, long long bx, long long by, long long cx,
        long long cy) {
  int ans = 0;
  ans |= gao2(ax, ay, bx, by, cx, cy);
  ans |= gao2(ax, ay, by, -bx, cx, cy);
  ans |= gao2(ax, ay, -bx, -by, cx, cy);
  ans |= gao2(ax, ay, -by, bx, cx, cy);
  return ans;
}
int main() {
  cin >> A.x >> A.y >> B.x >> B.y >> C.x >> C.y;
  int ans = 0;
  ans |= gao(A.x, A.y, B.x, B.y, C.x, C.y);
  ans |= gao(A.y, -A.x, B.x, B.y, C.x, C.y);
  ans |= gao(-A.x, -A.y, B.x, B.y, C.x, C.y);
  ans |= gao(-A.y, A.x, B.x, B.y, C.x, C.y);
  cout << (ans == 1 ? "YES" : "NO") << endl;
  return 0;
}
