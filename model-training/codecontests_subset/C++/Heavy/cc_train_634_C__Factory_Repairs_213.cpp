#include <bits/stdc++.h>
using namespace std;
struct node {
  int L, R, val, val1, val2;
  int Mid() { return (L + R) / 2; }
} a[200010 * 4];
int A, B;
void Build(int id, int L, int R) {
  a[id].L = L, a[id].R = R;
  a[id].val = a[id].val1 = a[id].val2 = 0;
  if (L == R) return;
  Build(id * 2, L, a[id].Mid());
  Build(id * 2 + 1, a[id].Mid() + 1, R);
}
void Update(int id, int x, int y) {
  if (a[id].L == a[id].R && a[id].L == x) {
    a[id].val += y;
    if (a[id].val >= A) {
      a[id].val1 = A;
      a[id].val2 = B;
    } else if (a[id].val < A && a[id].val >= B) {
      a[id].val1 = a[id].val;
      a[id].val2 = B;
    } else {
      a[id].val1 = a[id].val2 = a[id].val;
    }
    return;
  }
  if (x <= a[id].Mid())
    Update(id * 2, x, y);
  else
    Update(id * 2 + 1, x, y);
  a[id].val = a[id * 2].val + a[id * 2 + 1].val;
  a[id].val1 = a[id * 2].val1 + a[id * 2 + 1].val1;
  a[id].val2 = a[id * 2].val2 + a[id * 2 + 1].val2;
}
int Query(int id, int L, int R, int f) {
  if (L > R) return 0;
  if (a[id].L == L && a[id].R == R) {
    if (f == 1) {
      return a[id].val1;
    } else {
      return a[id].val2;
    }
  }
  if (R <= a[id].Mid())
    return Query(id * 2, L, R, f);
  else if (L > a[id].Mid())
    return Query(id * 2 + 1, L, R, f);
  else {
    int ans1 = Query(id * 2, L, a[id].Mid(), f);
    int ans2 = Query(id * 2 + 1, a[id].Mid() + 1, R, f);
    return ans1 + ans2;
  }
}
int main() {
  int n, k, q, t, x, y;
  scanf("%d %d %d %d %d", &n, &k, &A, &B, &q);
  Build(1, 1, n);
  while (q--) {
    scanf("%d", &t);
    if (t == 1) {
      scanf("%d %d", &x, &y);
      Update(1, x, y);
    } else {
      scanf("%d", &x);
      int ans1 = Query(1, 1, x - 1, 0);
      int ans2 = Query(1, x + k, n, 1);
      printf("%d\n", ans1 + ans2);
    }
  }
  return 0;
}
