#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2 * (1e5 + 100);
int n, k, puno, malo, q;
int tur[2][MAXN * 5];
int off;
inline void Update(int pos, int val, int flag) {
  pos += off;
  tur[flag][pos] += val;
  if (flag == 0)
    tur[flag][pos] = min(tur[flag][pos], malo);
  else
    tur[flag][pos] = min(tur[flag][pos], puno);
  for (pos /= 2; pos; pos /= 2)
    tur[flag][pos] = tur[flag][pos * 2] + tur[flag][pos * 2 + 1];
}
inline int Query(int node, int a, int b, int lo, int hi, int flag) {
  if (a > hi || b < lo || a > b) return 0;
  if (a >= lo && b <= hi) return tur[flag][node];
  int mid = (a + b) / 2;
  int left = Query(node * 2, a, mid, lo, hi, flag);
  int right = Query(node * 2 + 1, mid + 1, b, lo, hi, flag);
  return left + right;
}
int main() {
  scanf("%d %d %d %d %d", &n, &k, &puno, &malo, &q);
  for (off = 1; off < n; off *= 2)
    ;
  for (int i = 0; i < q; i++) {
    int foo, dan, order;
    scanf("%d", &foo);
    if (foo == 1) {
      scanf("%d %d", &dan, &order);
      dan--;
      Update(dan, min(order, malo), 0);
      Update(dan, min(order, puno), 1);
    } else {
      scanf("%d", &dan);
      dan--;
      int mali, veliki;
      if (dan == 0)
        mali = 0;
      else
        mali = Query(1, 0, off - 1, 0, dan - 1, 0);
      if (dan + k - 1 == n - 1)
        veliki = 0;
      else
        veliki = Query(1, 0, off - 1, dan + k, n - 1, 1);
      printf("%d\n", mali + veliki);
    }
  }
  return 0;
}
