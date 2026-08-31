#include <bits/stdc++.h>
#pragma GCC optimize("O3")
int ii[(1000 * (1000 - 1) / 2)], jj[(1000 * (1000 - 1) / 2)],
    ww[(1000 * (1000 - 1) / 2)];
int compare(const void *a, const void *b) {
  int h1 = *(int *)a;
  int h2 = *(int *)b;
  return ww[h2] - ww[h1];
}
int dsu[1000 * 2];
int find(int i) { return dsu[i] < 0 ? i : (dsu[i] = find(dsu[i])); }
void join(int i, int j) {
  i = find(i);
  j = find(j);
  if (i == j) return;
  if (dsu[i] > dsu[j])
    dsu[i] = j;
  else {
    if (dsu[i] == dsu[j]) dsu[i]--;
    dsu[j] = i;
  }
}
int main() {
  static int hh[(1000 * (1000 - 1) / 2)];
  int n, m, q, h;
  scanf("%d%d%d", &n, &m, &q);
  for (h = 0; h < m; h++) {
    scanf("%d%d%d", &ii[h], &jj[h], &ww[h]), ii[h]--, jj[h]--;
    hh[h] = h;
  }
  qsort(hh, m, sizeof *hh, compare);
  while (q--) {
    int l, r, w;
    scanf("%d%d", &l, &r), l--, r--;
    memset(dsu, -1, n * 2 * sizeof *dsu);
    w = -1;
    for (h = 0; h < m; h++) {
      int h_ = hh[h];
      if (l <= h_ && h_ <= r) {
        int i = ii[h_];
        int j = jj[h_];
        int i0 = i << 1, i1 = i0 | 1;
        int j0 = j << 1, j1 = j0 | 1;
        join(i0, j1);
        join(i1, j0);
        if (find(i0) == find(i1) || find(j0) == find(j1)) {
          w = ww[h_];
          break;
        }
      }
    }
    printf("%d\n", w);
  }
  return 0;
}
