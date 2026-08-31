#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 5;
int stat[N << 2][2], cur[N];
int a, b;
void update(int s, int l, int r, int idx, int val) {
  if (l > idx or r < idx) {
    return;
  }
  if (l == r) {
    cur[l] += val;
    stat[s][0] = min(cur[l], a);
    stat[s][1] = min(cur[l], b);
    return;
  }
  int mid = (l + r) >> 1;
  update((s << 1) + 1, l, mid, idx, val);
  update((s << 1) + 2, mid + 1, r, idx, val);
  stat[s][0] = stat[(s << 1) + 1][0] + stat[(s << 1) + 2][0];
  stat[s][1] = stat[(s << 1) + 1][1] + stat[(s << 1) + 2][1];
}
int get(int s, int l, int r, int idx, int idy, int p) {
  if (l > idy or r < idx) {
    return 0;
  }
  if (l >= idx and r <= idy) {
    return stat[s][p];
  }
  int mid = (l + r) >> 1;
  return get((s << 1) + 1, l, mid, idx, idy, p) +
         get((s << 1) + 2, mid + 1, r, idx, idy, p);
}
int main() {
  int n, k, q;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  swap(a, b);
  while (q--) {
    int p;
    scanf("%d", &p);
    if (p == 1) {
      int c, d;
      scanf("%d %d", &c, &d);
      update(0, 0, n - 1, c - 1, d);
    } else {
      int c;
      scanf("%d", &c);
      int res =
          get(0, 0, n - 1, c + k - 1, n - 1, 1) + get(0, 0, n - 1, 0, c - 2, 0);
      printf("%d\n", res);
    }
  }
  return 0;
}
