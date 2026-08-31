#include <bits/stdc++.h>
using namespace std;
int c1[200005], c2[200005];
int a[200005], n, k, A, B, q;
inline void upd(int *c, int i, int w) {
  for (; i <= n; i += (i & -i)) c[i] += w;
}
inline int get(int *c, int i) {
  int sum = 0;
  for (; i; i -= (i & -i)) sum += c[i];
  return sum;
}
int main() {
  int i, p, d, w, op, q1, q2, ans;
  cin >> n >> k >> A >> B >> q;
  swap(A, B);
  for (i = 1; i <= q; i++) {
    scanf("%d", &op);
    if (op == 1) {
      scanf("%d%d", &d, &w);
      if (a[d] < A)
        q1 = min(a[d] + w, A) - a[d];
      else
        q1 = 0;
      if (a[d] < B)
        q2 = min(a[d] + w, B) - a[d];
      else
        q2 = 0;
      a[d] += w;
      upd(c1, d, q1);
      upd(c2, d, q2);
    } else {
      scanf("%d", &p);
      ans = (get(c1, p - 1) - get(c2, p + k - 1)) + get(c2, n);
      printf("%d\n", ans);
    }
  }
  return 0;
}
