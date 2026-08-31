#include <bits/stdc++.h>
int compare(const void *a, const void *b) {
  int ia = *(int *)a;
  int ib = *(int *)b;
  return ia - ib;
}
int main() {
  static int aa[100000], bb[100000 - 1], cc[100000 - 2];
  int n, i;
  scanf("%d", &n);
  for (i = 0; i < n; i++) scanf("%d", &aa[i]);
  for (i = 0; i < n - 1; i++) scanf("%d", &bb[i]);
  for (i = 0; i < n - 2; i++) scanf("%d", &cc[i]);
  qsort(aa, n, sizeof *aa, compare);
  qsort(bb, n - 1, sizeof *bb, compare);
  qsort(cc, n - 2, sizeof *cc, compare);
  for (i = 0; i < n - 1; i++)
    if (bb[i] != aa[i]) break;
  printf("%d\n", aa[i]);
  for (i = 0; i < n - 2; i++)
    if (cc[i] != bb[i]) break;
  printf("%d\n", bb[i]);
  return 0;
}
