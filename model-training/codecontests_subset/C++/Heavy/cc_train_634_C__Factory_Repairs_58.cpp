#include <bits/stdc++.h>
using namespace std;
int n, m, o, p, q, re = 0;
long long res = 0;
int a[1000010], b[1000010];
bool chk[1000010];
struct fenwick {
  long long t[1000010];
  void add(int d, long long val) {
    for (; d < 1000010; d += d & -d) {
      t[d] += val;
    }
  }
  long long view(int d) {
    long long val = 0;
    for (; d > 0; d -= d & -d) {
      val += t[d];
    }
    return val;
  }
} fea, feb;
int main() {
  int i, j, k, l;
  long long ll = 0, rr = 9223372036854775807LL, mid;
  scanf("%d %d %d %d %d", &n, &m, &q, &p, &o);
  for (i = 0; i < o; i++) {
    scanf("%d", &j);
    if (j == 1) {
      scanf("%d %d", &j, &k);
      fea.add(j, min(p - (fea.view(j) - fea.view(j - 1)), (long long)k));
      feb.add(j, min(q - (feb.view(j) - feb.view(j - 1)), (long long)k));
    } else {
      scanf("%d", &j);
      printf("%I64d\n", fea.view(j - 1) + feb.view(n) - feb.view(j + m - 1));
    }
  }
  return 0;
}
