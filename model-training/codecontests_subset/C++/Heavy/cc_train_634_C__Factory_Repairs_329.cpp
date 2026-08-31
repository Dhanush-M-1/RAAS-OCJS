#include <bits/stdc++.h>
using namespace std;
const int MXN = 256 * 1024;
int cnt[MXN];
int t1[MXN];
int t2[MXN];
int n, k, a, b, q;
static void init() {
  memset(cnt, 0, sizeof(cnt));
  memset(t1, 0, sizeof(t1));
  memset(t2, 0, sizeof(t2));
}
void update(int day, int v) {
  int addA = max(0, min(a - cnt[day], v));
  int addB = max(0, min(b - cnt[day], v));
  cnt[day] += v;
  for (int i = day; i < MXN; i |= (i + 1)) {
    t1[i] += addA;
    t2[i] += addB;
  }
}
int query(int p) {
  int ans = 0;
  for (int i = p - 1; i > 0; i = (i & (i + 1)) - 1) ans += t2[i];
  for (int i = MXN - 1; i > 0; i = (i & (i + 1)) - 1) ans += t1[i];
  for (int i = p + k - 1; i > 0; i = (i & (i + 1)) - 1) ans -= t1[i];
  return ans;
}
int main() {
  while (scanf("%d %d %d %d %d", &n, &k, &a, &b, &q) == 5) {
    init();
    for (int i = 0; i < q; i++) {
      int type;
      scanf("%d", &type);
      if (type == 1) {
        int day, v;
        scanf("%d %d", &day, &v);
        update(day, v);
      }
      if (type == 2) {
        int p;
        scanf("%d", &p);
        printf("%d\n", query(p));
      }
    }
  }
}
