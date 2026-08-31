#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:100000000")
using namespace std;
const int BUCKET_SZ = 400;
int n, k, a, b, q;
int orders[300005];
int bad[300005 / BUCKET_SZ + 5], good[300005 / BUCKET_SZ + 5];
int main() {
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int d, cnt;
      scanf("%d %d", &d, &cnt);
      d--;
      if (orders[d] < b)
        bad[d / BUCKET_SZ] += min(orders[d] + cnt, b) - orders[d];
      if (orders[d] < a)
        good[d / BUCKET_SZ] += min(orders[d] + cnt, a) - orders[d];
      orders[d] += cnt;
    } else {
      int d;
      scanf("%d", &d);
      d--;
      int res = 0;
      int i = 0;
      while (i + BUCKET_SZ <= d) {
        res += bad[i / BUCKET_SZ];
        i += BUCKET_SZ;
      }
      while (i < d) {
        res += min(orders[i], b);
        i++;
      }
      i = d + k;
      while (i % BUCKET_SZ != 0) {
        res += min(orders[i], a);
        i++;
      }
      while (i < n) {
        res += good[i / BUCKET_SZ];
        i += BUCKET_SZ;
      }
      printf("%d\n", res);
    }
  }
  return 0;
}
