#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000;
const int MAXN = 1e7 + 5;
struct Vector {
  long long x, y;
};
Vector ta[4], a, b, c;
int f;
long long mu;
bool judge(Vector a) {
  Vector tmp;
  tmp.x = b.x - a.x, tmp.y = b.y - a.y;
  if (mu == 0) {
    if (tmp.x == 0 && tmp.y == 0) {
      return true;
    }
    return false;
  }
  if ((((tmp.x * c.y - tmp.y * c.x) % mu) == 0) &&
      (((tmp.x * c.x + tmp.y * c.y) % mu) == 0))
    return true;
  return false;
}
int main() {
  scanf("%lld%lld%lld%lld%lld%lld", &a.x, &a.y, &b.x, &b.y, &c.x, &c.y);
  ta[0] = a;
  ta[1].x = -a.x, ta[1].y = -a.y;
  ta[2].x = a.y, ta[2].y = -a.x;
  ta[3].x = -a.y, ta[3].y = a.x;
  mu = c.x * c.x + c.y * c.y;
  for (int i = 0; i < 4; i++)
    if (judge(ta[i])) {
      f = 1;
      break;
    }
  if (f)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
