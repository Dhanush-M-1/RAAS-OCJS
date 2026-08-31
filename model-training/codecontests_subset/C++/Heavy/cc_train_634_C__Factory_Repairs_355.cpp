#include <bits/stdc++.h>
using namespace std;
int n, k, a, b, Q;
int D[200020];
int T[2][2000020];
void Update(int v, int tl, int tr, int cur) {
  if (tl > cur || tr <= cur) return;
  if (tl == tr - 1) {
    T[0][v] = min(a, D[tl]);
    T[1][v] = min(b, D[tl]);
    return;
  }
  Update(2 * v, tl, (tl + tr) / 2, cur);
  Update(2 * v + 1, (tl + tr) / 2, tr, cur);
  T[0][v] = T[0][2 * v] + T[0][2 * v + 1];
  T[1][v] = T[1][2 * v] + T[1][2 * v + 1];
}
int Get(int v, int tl, int tr, int l, int r, int cur) {
  if (tl >= r || tr <= l) return 0;
  if (l <= tl && tr <= r) return T[cur][v];
  int A, B;
  A = Get(2 * v, tl, (tl + tr) / 2, l, r, cur);
  B = Get(2 * v + 1, (tl + tr) / 2, tr, l, r, cur);
  return A + B;
}
int main() {
  scanf("%d%d%d%d%d", &n, &k, &b, &a, &Q);
  while (Q--) {
    int indicator;
    scanf("%d", &indicator);
    if (indicator == 1) {
      int d, val;
      scanf("%d%d", &d, &val);
      D[d] += val;
      Update(1, 1, n + 1, d);
    } else {
      int d;
      scanf("%d", &d);
      int ans = 0;
      ans += Get(1, 1, n + 1, 1, d, 0);
      ans += Get(1, 1, n + 1, d + k, n + 1, 1);
      printf("%d\n", ans);
    }
  }
  return 0;
}
