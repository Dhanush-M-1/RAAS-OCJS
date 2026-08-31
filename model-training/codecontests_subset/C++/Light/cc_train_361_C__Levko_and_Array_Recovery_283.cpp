#include <bits/stdc++.h>
using namespace std;
struct query {
  int t;
  int l;
  int r;
  int m;
} q[5010];
int N, M, L;
int D[5010];
int Sol[5010];
int main() {
  scanf("%d%d", &N, &M);
  for (int i = 1; i <= N; ++i) Sol[i] = 1000000000;
  while (M--) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int l, r, d;
      scanf("%d%d%d", &l, &r, &d);
      ++L;
      q[L].t = t;
      q[L].l = l;
      q[L].r = r;
      q[L].m = d;
      for (; l <= r; ++l) D[l] += d;
    } else {
      int l, r, m;
      scanf("%d%d%d", &l, &r, &m);
      ++L;
      q[L].t = t;
      q[L].l = l;
      q[L].r = r;
      q[L].m = m;
      for (int i = l; i <= r; ++i) {
        Sol[i] = min(Sol[i], m - D[i]);
      }
    }
  }
  memset(D, 0, sizeof(D));
  for (int i = 1; i <= L; ++i) {
    if (q[i].t == 1) {
      for (int j = q[i].l; j <= q[i].r; ++j) D[j] += q[i].m;
    } else {
      int m = Sol[q[i].l] + D[q[i].l];
      for (int j = q[i].l; j <= q[i].r; ++j) m = max(m, Sol[j] + D[j]);
      if (m != q[i].m) {
        printf("NO\n");
        return 0;
      }
    }
  }
  printf("YES\n");
  for (int i = 1; i <= N; ++i) printf("%d ", Sol[i]);
  printf("\n");
  return 0;
}
