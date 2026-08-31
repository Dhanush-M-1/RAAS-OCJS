#include <bits/stdc++.h>
using namespace std;
int t[2][2 * 200000], N;
void modify(int n, int v, int a, int id) {
  n += N;
  t[id][n] = min(t[id][n] + v, a);
  while (n >>= 1) t[id][n] = t[id][n << 1] + t[id][n << 1 | 1];
}
int query(int l, int r, int id) {
  int ans = 0;
  for (l += N, r += N; l < r; l >>= 1, r >>= 1) {
    if (l & 1) ans += t[id][l++];
    if (r & 1) ans += t[id][--r];
  }
  return ans;
}
int main() {
  int K, a, b, Q, type, p, v;
  while (scanf("%d %d %d %d %d", &N, &K, &a, &b, &Q) != EOF) {
    memset(t, 0, sizeof(t));
    for (int i = int(0); i < int(Q); i++) {
      scanf("%d %d", &type, &p);
      p--;
      if (type & 1) {
        scanf("%d", &v);
        modify(p, v, b, 0);
        modify(p, v, a, 1);
      } else {
        printf("%d\n", query(0, p, 0) + query(p + K, N, 1));
      }
    }
  }
  return 0;
}
