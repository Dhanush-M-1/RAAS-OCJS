#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
int n, k, a, b, q;
class tree {
 public:
  int mn;
  int t[N << 1];
  void up(int x, int k) {
    x += N;
    t[x] = min(t[x] + k, mn);
    while (x > 1) {
      x >>= 1;
      t[x] = t[x + x] + t[x + x + 1];
    }
  }
  int get(int l, int r) {
    int sum = 0;
    for (l += N, r += N; l <= r; l = (l + 1) >> 1, r = (r - 1) >> 1) {
      if (l & 1) sum += t[l];
      if (~r & 1) sum += t[r];
    }
    return sum;
  }
} t[2];
int main() {
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  t[0].mn = b;
  t[1].mn = a;
  for (int i = 1; i <= q; i++) {
    int c;
    scanf("%d", &c);
    if (c == 1) {
      int x, k;
      scanf("%d %d", &x, &k);
      t[0].up(x, k);
      t[1].up(x, k);
    } else {
      int x;
      scanf("%d", &x);
      printf("%d\n", t[0].get(1, x - 1) + t[1].get(x + k, n));
    }
  }
  return 0;
}
