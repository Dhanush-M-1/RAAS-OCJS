#include <bits/stdc++.h>
using namespace std;
int n;
int arr[2][200200];
int bit[2][200200];
inline void update(bool def, int idx, int val) {
  while (idx <= n) {
    bit[def][idx] += val;
    idx += idx & -idx;
  }
}
inline int getSum(bool def, int idx) {
  int sum = 0;
  while (idx > 0) {
    sum += bit[def][idx];
    idx -= idx & -idx;
  }
  return sum;
}
int main() {
  int k, a, b, q, t, d, x, pa, pb;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  while (q--) {
    scanf("%d", &t);
    if (t == 1) {
      scanf("%d %d", &d, &x);
      arr[0][d] = min(x + (pa = arr[0][d]), a);
      arr[1][d] = min(x + (pb = arr[1][d]), b);
      update(0, d, arr[0][d] - pa);
      update(1, d, arr[1][d] - pb);
    } else {
      scanf("%d", &x);
      printf("%d\n", getSum(1, x - 1) + getSum(0, n) - getSum(0, x + k - 1));
    }
  }
  return 0;
}
