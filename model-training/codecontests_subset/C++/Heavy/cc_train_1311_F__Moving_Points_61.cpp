#include <bits/stdc++.h>
using namespace std;
const int N = 200000;
int x[N + 5], v[N + 5], _v[N + 5];
pair<int, int> point[N + 5];
template <typename T, int N>
struct Binary_Indexed_Tree {
  int n;
  T sumv[N + 5];
  void init(int _n) {
    n = _n;
    memset(sumv, 0, (n + 4) * sizeof(T));
  }
  void build(T A[], int _n) {
    init(_n);
    for (int i = 1; i <= n; ++i) {
      sumv[i] += A[i];
      int j = i + (i & -i);
      if (j <= n) sumv[j] += sumv[i];
    }
  }
  void add(int p, T k) {
    while (p <= n) {
      sumv[p] += k;
      p += p & -p;
    }
  }
  T sum(int p) {
    T res = 0;
    while (p) {
      res += sumv[p];
      p -= p & -p;
    }
    return res;
  }
};
Binary_Indexed_Tree<long long, N> bit, bitr, cbit, cbitr;
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%d", x + i);
  for (int i = 1; i <= n; ++i) scanf("%d", v + i);
  memcpy(_v, v, sizeof(v));
  sort(_v + 1, _v + n + 1);
  auto ed = unique(_v + 1, _v + n + 1);
  for (int i = 1; i <= n; ++i) {
    v[i] = lower_bound(_v + 1, ed, v[i]) - _v;
    point[i] = {x[i], v[i]};
  }
  sort(point + 1, point + n + 1);
  bit.init(n);
  bitr.init(n);
  cbit.init(n);
  cbitr.init(n);
  for (int i = 1; i <= n; ++i) {
    int xi = point[i].first, vi = point[i].second;
    bitr.add(vi, xi);
    cbitr.add(vi, 1);
  }
  long long ans = 0;
  for (int i = 1; i <= n; ++i) {
    int xi = point[i].first, vi = point[i].second;
    bitr.add(vi, -xi);
    cbitr.add(vi, -1);
    ans += xi * cbit.sum(vi) - bit.sum(vi) + bitr.sum(n) - bitr.sum(vi - 1) -
           (cbitr.sum(n) - cbitr.sum(vi - 1)) * xi;
    bit.add(vi, xi);
    cbit.add(vi, 1);
  }
  printf("%lld\n", ans / 2);
  return 0;
}
