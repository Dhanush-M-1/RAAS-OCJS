#include <bits/stdc++.h>
using namespace std;
int requests[200005];
int read(int i, int *tree) {
  int ret = 0;
  while (i > 0) {
    ret += tree[i];
    i -= (i & -i);
  }
  return ret;
}
void add(int i, int v, int *tree, int maxi) {
  while (i <= maxi) {
    tree[i] += v;
    i += (i & -i);
  }
}
int readS(int i, int *tree) {
  int sum = tree[i];
  if (i > 0) {
    int z = i - (i & -i);
    i--;
    while (i != z) {
      sum -= tree[i];
      i -= (i & -i);
    }
  }
  return sum;
}
int arva[200005], arvb[200005];
int main() {
  int n, k, a, b, q, tmp, di, ai, pi;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  for (int query = 0; query < q; query++) {
    scanf("%d", &tmp);
    if (tmp == 1) {
      scanf("%d %d", &di, &ai);
      add(di, min(ai, max(0, b - requests[di])), arvb, n + 1);
      add(di, min(ai, max(0, a - requests[di])), arva, n + 1);
      requests[di] += ai;
    } else {
      scanf("%d", &pi);
      int ans = 0;
      if (pi > 1) ans += read(pi - 1, arvb);
      if (pi + k <= n) ans += read(n, arva) - read(pi + k - 1, arva);
      printf("%d\n", ans);
    }
  }
  return 0;
}
