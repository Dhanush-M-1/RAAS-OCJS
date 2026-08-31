#include <bits/stdc++.h>
using namespace std;
const int MOD(1000000007);
const int INF((1 << 30) - 1);
const int MAXN(200005);
int n;
int f[2][MAXN], sumA[MAXN], sumB[MAXN];
void update(int c, int i, int v) {
  for (i; i <= n; i += i & (-i)) f[c][i] += v;
}
int query(int c, int i) {
  int ret = 0;
  for (i; i; i -= i & (-i)) ret += f[c][i];
  return ret;
}
int main() {
  int k, A, B, q;
  scanf("%d%d%d%d%d", &n, &k, &A, &B, &q);
  while (q--) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int d, v;
      scanf("%d%d", &d, &v);
      update(0, d, min(v, A - sumA[d]));
      update(1, d, min(v, B - sumB[d]));
      sumA[d] = min(A, sumA[d] + v);
      sumB[d] = min(B, sumB[d] + v);
    } else {
      int d;
      scanf("%d", &d);
      printf("%d\n", query(1, d - 1) + query(0, n) - query(0, d + k - 1));
    }
  }
}
