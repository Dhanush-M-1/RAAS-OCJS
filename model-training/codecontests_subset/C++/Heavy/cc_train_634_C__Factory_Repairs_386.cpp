#include <bits/stdc++.h>
using namespace std;
long long bit[2][200010], n;
long long a1[200010], a2[200010];
void update(int i, int val, int f) {
  while (i <= n) {
    bit[f][i] += val;
    i = i + (i & (-i));
  }
}
long long query(int i, int f) {
  long long ret = 0;
  while (i) {
    ret += bit[f][i];
    i = i - (i & (-i));
  }
  return ret;
}
int main() {
  int k, a, b, q, ch, x, y;
  scanf("%lld", &n);
  scanf("%d", &k);
  scanf("%d", &a);
  scanf("%d", &b);
  scanf("%d", &q);
  memset(bit[0], 0, sizeof(bit[0]));
  memset(bit[1], 0, sizeof(bit[1]));
  memset(a1, 0, sizeof(a1));
  memset(a2, 0, sizeof(a2));
  while (q--) {
    scanf("%d", &ch);
    if (ch == 1) {
      scanf("%d", &x);
      scanf("%d", &y);
      update(x, min(y * 1ll, a - a1[x]), 0);
      update(x, min(y * 1ll, b - a2[x]), 1);
      a1[x] = min(a * 1ll, a1[x] + y);
      a2[x] = min(b * 1ll, a2[x] + y);
    } else {
      scanf("%d", &x);
      long long ans = query(x - 1, 1);
      ans = ans + query(n, 0) - query(x + k - 1, 0);
      printf("%lld\n", ans);
    }
  }
}
