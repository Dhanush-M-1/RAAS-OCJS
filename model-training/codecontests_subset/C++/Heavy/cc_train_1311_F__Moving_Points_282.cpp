#include <bits/stdc++.h>
int xx[200000], vv[200000];
int compare_v(const void *a, const void *b) {
  int i = *(int *)a;
  int j = *(int *)b;
  return vv[i] - vv[j];
}
int compare_x(const void *a, const void *b) {
  int i = *(int *)a;
  int j = *(int *)b;
  return xx[i] - xx[j];
}
void sort(int *ii, int n, int (*compare)(const void *, const void *)) {
  qsort(ii, n, sizeof *ii, compare);
}
void update(long long *ft, int i, int n, int x) {
  while (i < n) {
    ft[i] += x;
    i |= i + 1;
  }
}
long long query(long long *ft, int i) {
  long long x = 0;
  while (i >= 0) {
    x += ft[i];
    i &= i + 1, i--;
  }
  return x;
}
int main() {
  static long long ft_cnt[200000], ft_sum[200000];
  static int ii[200000];
  int n, n_, i;
  long long ans;
  scanf("%d", &n);
  for (i = 0; i < n; i++) scanf("%d", &xx[i]);
  for (i = 0; i < n; i++) scanf("%d", &vv[i]);
  for (i = 0; i < n; i++) ii[i] = i;
  sort(ii, n, compare_v);
  n_ = 0;
  for (i = 0; i < n; i++)
    vv[ii[i]] = i + 1 == n || vv[ii[i + 1]] != vv[ii[i]] ? n_++ : n_;
  sort(ii, n, compare_x);
  ans = 0;
  for (i = 0; i < n; i++) {
    int i_ = ii[i], x = xx[i_], v = vv[i_];
    ans += query(ft_cnt, v) * x - query(ft_sum, v);
    update(ft_cnt, v, n_, 1);
    update(ft_sum, v, n_, x);
  }
  printf("%lld\n", ans);
  return 0;
}
