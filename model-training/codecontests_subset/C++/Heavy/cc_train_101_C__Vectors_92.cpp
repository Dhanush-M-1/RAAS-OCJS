#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-10;
const int inf = 1 << 28;
int getint() {
  unsigned int c;
  int x = 0;
  while (((c = getchar()) - '0') >= 10) {
    if (c == '-') return -getint();
    if (!~c) exit(0);
  }
  do {
    x = (x << 3) + (x << 1) + (c - '0');
  } while (((c = getchar()) - '0') < 10);
  return x;
}
void rot90(int& rx, int& ry, int x, int y) { rx = -y, ry = x; }
int solve_le(long long& x, long long& y, const vector<long long>& v1,
             const vector<long long>& v2) {
  long long den = v1[0] * v2[1] - v2[0] * v1[1];
  if (den != 0) {
    x = (v1[2] * v2[1] - v2[2] * v1[1]) / den;
    y = (v1[0] * v2[2] - v2[0] * v1[2]) / den;
    return 1;
  }
  den = v1[2] * v2[1] - v1[1] * v2[2];
  if (den != 0) return 0;
  den = v1[0] * v2[2] - v1[2] * v2[0];
  if (den != 0) return 0;
  if (v1[0] == 0 and v1[1] == 0 and v1[2] != 0) return 0;
  if (v2[0] == 0 and v2[1] == 0 and v2[2] != 0) return 0;
  return 2;
}
bool solve(int xa, int ya, int xb, int yb, int xc, int yc) {
  vector<long long> v1(3), v2(3);
  v1[0] = xc, v1[1] = -yc, v1[2] = xb - xa;
  v2[0] = yc, v2[1] = xc, v2[2] = yb - ya;
  long long t, u;
  int k = solve_le(t, u, v1, v2);
  if (k == 2) return 1;
  if (k == 0) return 0;
  if (t * v1[0] + u * v1[1] == v1[2] and t * v2[0] + u * v2[1] == v2[2])
    return 1;
  return 0;
}
int main() {
  int i, j, k, tcc;
  int tc = inf;
  for (tcc = 0; tcc < tc; tcc++) {
    int xa = getint(), ya = getint();
    int xb = getint(), yb = getint();
    int xc = getint(), yc = getint();
    int x = xa, y = ya;
    bool res = 0;
    res = res or solve(x, y, xb, yb, xc, yc);
    rot90(x, y, x, y);
    res = res or solve(x, y, xb, yb, xc, yc);
    rot90(x, y, x, y);
    res = res or solve(x, y, xb, yb, xc, yc);
    rot90(x, y, x, y);
    res = res or solve(x, y, xb, yb, xc, yc);
    rot90(x, y, x, y);
    res = res or solve(x, y, xb, yb, xc, yc);
    rot90(x, y, x, y);
    if (res)
      puts("YES");
    else
      puts("NO");
  }
  return 0;
}
