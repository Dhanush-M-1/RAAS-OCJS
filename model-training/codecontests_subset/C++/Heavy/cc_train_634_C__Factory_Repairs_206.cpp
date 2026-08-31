#include <bits/stdc++.h>
using namespace std;
struct node {
  int L, R, sum, sum1, sum2;
  int Mid() { return (L + R) / 2; }
} a[210500 * 4];
int A, B;
void Build(int r, int L, int R) {
  a[r].L = L, a[r].R = R;
  a[r].sum = a[r].sum1 = a[r].sum2 = 0;
  if (L == R) return;
  Build(r << 1, L, a[r].Mid());
  Build(r << 1 | 1, a[r].Mid() + 1, R);
}
void Update(int r, int pos, int num) {
  if (a[r].L == a[r].R && a[r].L == pos) {
    a[r].sum += num;
    if (a[r].sum >= A) {
      a[r].sum1 = A;
      a[r].sum2 = B;
    } else if (a[r].sum < A && a[r].sum >= B) {
      a[r].sum1 = a[r].sum;
      a[r].sum2 = B;
    } else
      a[r].sum1 = a[r].sum2 = a[r].sum;
    return;
  }
  if (pos <= a[r].Mid())
    Update(r << 1, pos, num);
  else
    Update(r << 1 | 1, pos, num);
  a[r].sum = a[r << 1].sum + a[r << 1 | 1].sum;
  a[r].sum1 = a[r << 1].sum1 + a[r << 1 | 1].sum1;
  a[r].sum2 = a[r << 1].sum2 + a[r << 1 | 1].sum2;
}
int Query(int r, int L, int R, int op) {
  if (L > R) return 0;
  if (a[r].L == L && a[r].R == R) {
    if (op == 2) return a[r].sum1;
    return a[r].sum2;
  }
  if (R <= a[r].Mid())
    return Query(r << 1, L, R, op);
  else if (L > a[r].Mid())
    return Query(r << 1 | 1, L, R, op);
  else {
    int ans1 = Query(r << 1, L, a[r].Mid(), op);
    int ans2 = Query(r << 1 | 1, a[r].Mid() + 1, R, op);
    return ans1 + ans2;
  }
}
int main() {
  int n, k, q, op, x, y;
  while (scanf("%d %d %d %d %d", &n, &k, &A, &B, &q) != EOF) {
    Build(1, 1, n);
    while (q--) {
      scanf("%d", &op);
      if (op == 1) {
        scanf("%d %d", &x, &y);
        Update(1, x, y);
      } else {
        scanf("%d", &x);
        int ans1 = Query(1, 1, x - 1, 1);
        int ans2 = Query(1, x + k, n, 2);
        printf("%d\n", ans1 + ans2);
      }
    }
  }
  return 0;
}
