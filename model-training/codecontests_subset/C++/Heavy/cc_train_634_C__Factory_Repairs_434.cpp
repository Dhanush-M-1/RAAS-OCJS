#include <bits/stdc++.h>
using namespace std;
long long inline gcd(long long x, long long y) {
  return !y ? (long long)abs(x) : gcd(y, x % y);
}
long long inline lcm(long long a, long long b) {
  return ((long long)abs((a / gcd(a, b)) * b));
}
double inline cartesian_dist(double x1, double y1, double x2, double y2) {
  return sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
}
long long bigmod(long long b, long long p, long long m) {
  if (!p)
    return 1 % m;
  else if (p & 1)
    return (((b % m) + m) % m * bigmod(b, p - 1, m)) % m;
  else {
    long long ret = bigmod(b, p / 2, m);
    return (ret * ret) % m;
  }
}
long long inverse(long long a, long long m) { return bigmod(a, m - 2, m); }
long long extended(long long a, long long m) {
  long long oldr = a, r = m, oldans = 1, ans = 0, quotient;
  while (r) {
    quotient = oldr / r;
    oldr = oldr - r * quotient;
    swap(oldr, r);
    oldans = oldans - ans * quotient;
    swap(oldans, ans);
  }
  return ((oldans % m) + m) % m;
}
const double PI = acos(-1.0);
const double eps = 10E-12;
int n, k, a, b, q;
struct node {
  int small, big;
  node() {
    small = 0;
    big = 0;
  }
} tree[5 * (int)2e5 + 9];
void update(int root, int bg, int en, int idx, int val) {
  if (bg > idx || en < idx) return;
  if (bg == en && idx == bg) {
    tree[root].small =
        (tree[root].small + val) > b ? b : (tree[root].small + val);
    tree[root].big = (tree[root].big + val) > a ? a : (tree[root].big + val);
    return;
  }
  int m = (bg + en) / 2;
  update(root * 2, bg, m, idx, val);
  update(root * 2 + 1, m + 1, en, idx, val);
  tree[root].small = tree[root * 2].small + tree[root * 2 + 1].small;
  tree[root].big = tree[root * 2].big + tree[root * 2 + 1].big;
}
int query(int root, int bg, int en, int l, int r, int id) {
  if (bg > r || en < l) return 0;
  if (bg >= l && en <= r) {
    if (id == 1)
      return tree[root].small;
    else
      return tree[root].big;
  }
  int m = (bg + en) / 2;
  return query(root * 2, bg, m, l, r, id) +
         query(root * 2 + 1, m + 1, en, l, r, id);
}
int main() {
  scanf("%d %d", &n, &k);
  scanf("%d %d %d", &a, &b, &q);
  while (q--) {
    int id;
    scanf("%d", &id);
    if (id == 1) {
      int day, order;
      scanf("%d %d", &day, &order);
      update(1, 1, n, day, order);
    } else {
      int day, ans = 0;
      scanf("%d", &day);
      if (day > 1) ans += query(1, 1, n, 1, day - 1, 1);
      if (day + k <= n) ans += query(1, 1, n, day + k, n, 2);
      printf("%d", ans);
      printf("\n");
    }
  }
  return 0;
}
