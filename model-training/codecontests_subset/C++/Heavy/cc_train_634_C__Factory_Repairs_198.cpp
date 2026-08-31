#include <bits/stdc++.h>
using namespace std;
const int MAXN = (1 << 18);
long long tree1[2 * MAXN], tree2[2 * MAXN];
int n, a, k, q, b, t, di, ai, pi;
long long la, lb;
int main() {
  memset(tree1, 0, sizeof tree1);
  memset(tree2, 0, sizeof tree2);
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  la = a;
  lb = b;
  int NN = MAXN - 1;
  while (q--) {
    scanf("%d", &t);
    if (t == 1) {
      scanf("%d%d", &di, &ai);
      tree1[NN + di] = min(tree1[NN + di] + ai, la);
      for (int node = (NN + di) / 2; node; node /= 2)
        tree1[node] = tree1[2 * node] + tree1[2 * node + 1];
      tree2[NN + di] = min(tree2[NN + di] + ai, lb);
      for (int node = (NN + di) / 2; node; node /= 2)
        tree2[node] = tree2[2 * node] + tree2[2 * node + 1];
    } else {
      scanf("%d", &pi);
      long long res = 0;
      int l = NN + 1;
      int r = NN + pi - 1;
      while (l <= r) {
        if (l & 1) res += tree2[l];
        if (!(r & 1)) res += tree2[r];
        l = (l + 1) / 2;
        r = (r - 1) / 2;
      }
      l = NN + pi + k, r = NN + n;
      while (l <= r) {
        if (l & 1) res += tree1[l];
        if (!(r & 1)) res += tree1[r];
        l = (l + 1) / 2;
        r = (r - 1) / 2;
      }
      printf("%I64d\n", res);
    }
  }
  return 0;
}
