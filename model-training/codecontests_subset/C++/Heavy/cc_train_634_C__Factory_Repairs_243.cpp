#include <bits/stdc++.h>
using namespace std;
int n, a, b, k, tt;
int tree1[800000], tree2[800000];
void updata1(int L, int R, int ro, int x, int v) {
  if (x < L || x > R) return;
  if (L == R && L == x) {
    tree1[ro] = min(v + tree1[ro], b);
    return;
  }
  int Mid = (L + R) / 2;
  updata1(L, Mid, ro * 2, x, v);
  updata1(Mid + 1, R, ro * 2 + 1, x, v);
  tree1[ro] = tree1[ro * 2] + tree1[ro * 2 + 1];
}
void updata2(int L, int R, int ro, int x, int v) {
  if (x < L || x > R) return;
  if (L == R && L == x) {
    tree2[ro] = min(v + tree2[ro], a);
    return;
  }
  int Mid = (L + R) / 2;
  updata2(L, Mid, ro * 2, x, v);
  updata2(Mid + 1, R, ro * 2 + 1, x, v);
  tree2[ro] = tree2[ro * 2] + tree2[ro * 2 + 1];
}
int quary1(int ro, int L, int R, int l, int r) {
  if (r < L || l > R) return 0;
  if (l <= L && R <= r) return tree1[ro];
  int Mid = (L + R) / 2;
  int x1 = quary1(ro * 2, L, Mid, l, r),
      x2 = quary1(ro * 2 + 1, Mid + 1, R, l, r);
  return x1 + x2;
}
int quary2(int ro, int L, int R, int l, int r) {
  if (r < L || l > R) return 0;
  if (l <= L && R <= r) return tree2[ro];
  int Mid = (L + R) / 2;
  int x1 = quary2(ro * 2, L, Mid, l, r),
      x2 = quary2(ro * 2 + 1, Mid + 1, R, l, r);
  return x1 + x2;
}
int main() {
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &tt);
  for (int i = 1; i <= tt; i++) {
    int a1, b1, c1;
    scanf("%d", &a1);
    if (a1 == 1) {
      scanf("%d%d", &b1, &c1);
      updata1(1, n, 1, b1, c1);
      updata2(1, n, 1, b1, c1);
    } else if (a1 == 2) {
      scanf("%d", &b1);
      printf("%d\n", quary1(1, 1, n, 1, b1 - 1) + quary2(1, 1, n, b1 + k, n));
    }
  }
  return 0;
}
