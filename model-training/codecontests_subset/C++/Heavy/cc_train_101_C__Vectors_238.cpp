#include <bits/stdc++.h>
using namespace std;
struct node {
  long long x, y;
};
node b, c;
bool Judge(long long x, long long y) {
  node a;
  a.x = x;
  a.y = y;
  if (c.x == 0 && c.y == 0) {
    if (a.x == b.x && a.y == b.y) return true;
    return false;
  }
  long long k, C;
  long long g, h;
  g = b.x - a.x;
  h = b.y - a.y;
  k = g * c.x + h * c.y;
  if (k % (c.x * c.x + c.y * c.y) == 0) {
    k /= (c.x * c.x + c.y * c.y);
    if (c.y != 0) {
      C = g - k * c.x;
      if (C % c.y == 0) {
        return true;
      }
      return false;
    } else {
      C = k * c.y - h;
      if (C % c.x == 0) {
        return true;
      }
      return false;
    }
  }
  return false;
}
int main() {
  node a;
  while (cin >> a.x >> a.y >> b.x >> b.y >> c.x >> c.y) {
    if (Judge(a.x, a.y) == true) {
      puts("YES");
    } else if (Judge(-a.y, a.x) == true) {
      puts("YES");
    } else if (Judge(a.y, -a.x) == true) {
      puts("YES");
    } else if (Judge(-a.x, -a.y) == true) {
      puts("YES");
    } else {
      puts("NO");
    }
  }
  return 0;
}
