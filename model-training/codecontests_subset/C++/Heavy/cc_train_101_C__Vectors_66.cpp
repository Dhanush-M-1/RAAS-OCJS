#include <bits/stdc++.h>
using namespace std;
struct coor {
  int x, y;
} a, b, c;
int gcd(int x, int y) { return !y ? x : gcd(y, x % y); }
bool jud(int Ax, int Ay) {
  long long x = b.x - Ax, y = b.y - Ay;
  if (c.x && c.y) {
    long long tx = x * c.y, ty = y * c.x;
    if ((tx - ty) % (1ll * c.x * c.x + 1ll * c.y * c.y)) return 0;
    long long t = (tx - ty) / (1ll * c.x * c.x + 1ll * c.y * c.y);
    int a = (x - t * c.y) % c.x;
    if (!a) return 1;
    return 0;
  } else if (!c.x && c.y) {
    if ((x % c.y == 0) && (y % c.y == 0)) return 1;
    return 0;
  } else if (!c.y && c.x) {
    if ((x % c.x == 0) && (y % c.x == 0)) return 1;
    return 0;
  } else
    return (!x) && (!y);
}
int main() {
  scanf("%d%d", &a.x, &a.y);
  scanf("%d%d", &b.x, &b.y);
  scanf("%d%d", &c.x, &c.y);
  bool cnt = 0;
  if (jud(a.x, a.y)) cnt = 1;
  if (jud(a.y, -a.x)) cnt = 1;
  if (jud(-a.y, a.x)) cnt = 1;
  if (jud(-a.x, -a.y)) cnt = 1;
  puts(cnt ? "YES" : "NO");
  return 0;
}
