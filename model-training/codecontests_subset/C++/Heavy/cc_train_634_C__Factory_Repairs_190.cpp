#include <bits/stdc++.h>
using namespace std;
int n, k, a, b, q, t, x, val;
long long A[4 * 200005], B[4 * 200005];
void update(long long *tree, int low, int high, int idx, int val, int limit,
            int pos) {
  if (low == high) {
    tree[pos] = min(tree[pos] + val, (long long)limit);
    return;
  }
  int mid = (low + high) / 2;
  if (idx <= mid)
    update(tree, low, mid, idx, val, limit, pos * 2);
  else
    update(tree, mid + 1, high, idx, val, limit, pos * 2 + 1);
  tree[pos] = tree[pos * 2] + tree[pos * 2 + 1];
}
long long query(long long *tree, int low, int high, int qlow, int qhigh,
                int pos) {
  if (qhigh < qlow) return 0;
  if (low >= qlow && high <= qhigh) {
    return tree[pos];
  }
  int mid = (low + high) / 2;
  if (qhigh <= mid)
    return query(tree, low, mid, qlow, qhigh, pos * 2);
  else if (qlow > mid)
    return query(tree, mid + 1, high, qlow, qhigh, pos * 2 + 1);
  else
    return query(tree, low, mid, qlow, qhigh, pos * 2) +
           query(tree, mid + 1, high, qlow, qhigh, pos * 2 + 1);
}
int main() {
  memset(A, 0, sizeof(A));
  memset(B, 0, sizeof(B));
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  while (q--) {
    scanf("%d", &t);
    if (t == 1) {
      scanf("%d %d", &x, &val);
      update(A, 1, n, x, val, b, 1);
      update(B, 1, n, x, val, a, 1);
    } else {
      scanf("%d", &x);
      long long res = query(A, 1, n, 1, x - 1, 1) + query(B, 1, n, x + k, n, 1);
      printf("%I64d\n", res);
    }
  }
}
