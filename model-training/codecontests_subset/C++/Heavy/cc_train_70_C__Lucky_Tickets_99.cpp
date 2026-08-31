#include <bits/stdc++.h>
using namespace std;
struct NUM {
  int x, y;
  void init(int i) {
    x = i;
    int t = 0;
    while (i) {
      t = t * 10 + (i % 10);
      i /= 10;
    }
    y = t;
  }
  bool operator<(const NUM &t) const { return 1LL * y * t.x <= 1LL * t.y * x; }
} num[100005];
int rev(int x) {
  int res = 0;
  while (x) {
    res = res * 10 + (x % 10);
    x /= 10;
  }
  return res;
}
int mx, my, w;
int a[100005];
void add(int x) {
  while (x <= my) {
    ++a[x];
    x += x & (-x);
  }
}
int getSum(int x) {
  int res = 0;
  while (x >= 1) {
    res += a[x];
    x -= x & (-x);
  }
  return res;
}
int main() {
  scanf("%d%d%d", &mx, &my, &w);
  for (int i = 1; i <= my; ++i) num[i].init(i);
  sort(num + 1, num + 1 + my);
  int x = -1, y = -1;
  long long mi;
  for (int i = 1; i <= mx; ++i) {
    int t = rev(i);
    int l = 1, r = my;
    while (l < r) {
      int m = (l + r) >> 1;
      if (1LL * num[m].y * t < 1LL * i * num[m].x)
        l = m + 1;
      else
        r = m;
    }
    while (l <= my && 1LL * num[l].y * t == 1LL * i * num[l].x) {
      add(num[l].x);
      ++l;
    }
    l = 1, r = my;
    while (l < r) {
      int m = (l + r) >> 1;
      if (getSum(m) < w)
        l = m + 1;
      else
        r = m;
    }
    if (getSum(l) >= w) {
      if (x == -1)
        x = i, y = l, mi = 1LL * x * y;
      else if (mi > 1LL * i * l)
        x = i, y = l, mi = 1LL * x * y;
    }
  }
  if (x != -1) {
    printf("%d %d\n", x, y);
  } else {
    puts("-1");
  }
  return 0;
}
