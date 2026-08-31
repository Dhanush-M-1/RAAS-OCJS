#include <bits/stdc++.h>

using namespace std;

const int INF = 1000000001;
int r[100002];

static inline int magic(int l, int x, int r) {
  return max(min(r, x), l);
}

static inline void slide(int h, int dist, int &mina, int &minb, int &maxa, int &maxb) {
  minb = magic(0, minb + dist, h);
  maxb = magic(0, maxb + dist, h);
  if(maxb - minb < maxa - mina) {
    int delta = (maxa - mina) - (maxb - minb);
    if(dist < 0)
      mina += delta;
    else
      maxa -= delta;
  }
}

int main() {
  int h, n, q, t, a, mina, maxa, minb, maxb, dist, j;
#ifdef DEBUG
  freopen("codeforces.in", "r", stdin);
  freopen("codeforces.out", "w", stdout);
#endif
  scanf("%d%d", &h, &n);
  for(int i = 1; i <= n; ++i)
    scanf("%d", &r[i]);
  r[n + 1] = INF;
  n = n + 2;
  j = 1;
  mina = minb = 0;
  maxa = maxb = h;
  scanf("%d", &q);
  for(int i = 0; i < q; ++i) {
    scanf("%d%d", &t, &a);
    while(r[j] < t) {
      dist = r[j] - r[j - 1];
      if(j % 2 == 1)
        dist = -dist;
      slide(h, dist, mina, minb, maxa, maxb);
      ++j;
    }
    dist = t - r[j - 1];
    if(j % 2 == 1)
      dist = -dist;
    slide(h, dist, mina, minb, maxa, maxb);
    r[j - 1] = t;
    a = magic(mina, a, maxa);
    printf("%d\n", maxb - (maxa - a));
  }
  return 0;
}
