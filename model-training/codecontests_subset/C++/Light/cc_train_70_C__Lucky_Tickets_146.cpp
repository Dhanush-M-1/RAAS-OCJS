#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100000 + 10;
int rev(int x) {
  int ret = 0;
  while (x != 0) {
    ret = ret * 10 + x % 10;
    x /= 10;
  }
  return ret;
}
int gcd(int x, int y) { return x == 0 ? y : gcd(y % x, x); }
pair<int, int> f[MAXN];
map<pair<int, int>, int> cnt, cntr;
void init() {
  for (int i = 1; i < MAXN; ++i) {
    int y = rev(i);
    int g = gcd(i, y);
    f[i] = make_pair(i / g, y / g);
  }
}
inline pair<int, int> rev(const pair<int, int> &p) {
  return make_pair(p.second, p.first);
}
int main() {
  int mx, my, mw;
  init();
  scanf("%d%d%d", &mx, &my, &mw);
  int x = mx + 1, y = my + 1;
  cnt.clear();
  cntr.clear();
  for (int i = 1; i <= my; ++i) {
    cnt[f[i]]++;
  }
  long long w = 0;
  for (int i = 1, j = my; i <= mx; ++i) {
    cntr[f[i]]++;
    w += cnt[rev(f[i])];
    if (w < mw) {
      continue;
    }
    while (j > 0 && w - cntr[rev(f[j])] >= mw) {
      w -= cntr[rev(f[j])];
      cnt[f[j]]--;
      j--;
    }
    if ((long long)i * j < (long long)x * y) {
      x = i;
      y = j;
    }
  }
  if (x != mx + 1) {
    printf("%d %d\n", x, y);
  } else {
    puts("-1");
  }
  return 0;
}
