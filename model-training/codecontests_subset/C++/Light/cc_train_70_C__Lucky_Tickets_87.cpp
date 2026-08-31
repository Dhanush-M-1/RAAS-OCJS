#include <bits/stdc++.h>
using namespace std;
struct rat {
  int x, y;
  rat() {}
  rat(int tx, int ty) {
    x = tx;
    y = ty;
  }
  rat flip() { return rat(y, x); }
  bool operator<(const rat& o) const {
    return (long long)x * o.y < (long long)o.x * y;
  }
  bool operator==(const rat& o) const {
    return (long long)x * o.y == (long long)o.x * y;
  }
};
int getrev(int a) {
  int t = 0;
  while (a) {
    t = (t * 10) + (a % 10);
    a /= 10;
  }
  return t;
}
int rev[100010];
multiset<rat> a, b;
int c = 0, ta = 0, tb = 0;
void inca() {
  ta++;
  rat t(ta, rev[ta]);
  a.insert(t);
  c += b.count(t.flip());
}
void incb() {
  tb++;
  rat t(tb, rev[tb]);
  b.insert(t);
  c += a.count(t.flip());
}
void decb() {
  rat t(tb, rev[tb]);
  if (b.find(t) == b.end()) {
    printf("ERR\n");
    fflush(stdout);
    exit(1);
  }
  b.erase(b.find(t));
  c -= a.count(t.flip());
  tb--;
}
int main() {
  for (int i = 1; i <= 100000; i++) rev[i] = getrev(i);
  int n, m, k;
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) incb();
  long long best = 99999999999999LL;
  int ba = 0, bb = 0;
  for (int i = 1; i <= n; i++) {
    inca();
    while (tb != 0 && c >= k) decb();
    if (tb < m) incb();
    if (c >= k) {
      long long t = ta;
      t *= tb;
      if (t < best) {
        best = t;
        ba = ta;
        bb = tb;
      }
    }
  }
  if (best != 99999999999999LL)
    printf("%d %d\n", ba, bb);
  else
    printf("-1\n");
}
