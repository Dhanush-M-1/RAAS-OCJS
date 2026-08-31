#include <bits/stdc++.h>
using namespace std;
const int MAXN = 5000, A = 1000000000;
const long long INF = 100000000000000000LL;
long long a[MAXN + 10];
struct pyt {
  int t, l, r, v;
};
pyt p[MAXN + 10];
long long sum[MAXN + 10];
int main(void) {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < (n); ++i) {
    a[i] = A;
  }
  for (int i = 0; i < (m); ++i) {
    scanf("%d%d%d%d", &p[i].t, &p[i].l, &p[i].r, &p[i].v);
    --p[i].l;
    --p[i].r;
  }
  for (int i = 0; i < (m); ++i) {
    if (p[i].t == 1) {
      for (int j = p[i].l; j <= p[i].r; ++j) {
        sum[j] += p[i].v;
      }
    } else {
      for (int j = p[i].l; j <= p[i].r; ++j) {
        a[j] = min(a[j], p[i].v - sum[j]);
      }
    }
  }
  for (int i = 0; i < (n); ++i) {
    sum[i] = 0;
  }
  for (int i = 0; i < (m); ++i) {
    if (p[i].t == 1) {
      for (int j = p[i].l; j <= p[i].r; ++j) {
        sum[j] += p[i].v;
      }
    } else {
      long long mx = -INF;
      for (int j = p[i].l; j <= p[i].r; ++j) {
        mx = max(mx, a[j] + sum[j]);
      }
      if (mx != p[i].v) {
        puts("NO");
        return 0;
      }
    }
  }
  for (int i = 0; i < (n); ++i) {
    if (a[i] < -A) {
      puts("NO");
      return 0;
    }
  }
  puts("YES");
  for (int i = 0; i < (n); ++i) {
    printf("%d ", (int)a[i]);
  }
  puts("");
  return 0;
}
