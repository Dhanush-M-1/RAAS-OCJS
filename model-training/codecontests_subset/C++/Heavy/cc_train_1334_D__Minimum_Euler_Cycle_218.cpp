#include <bits/stdc++.h>
using namespace std;
void display(int lvl, int lt, int rt) {
  for (int i = lt; i <= rt; i++)
    printf("%d ", ((i & 1) ? lvl : lvl + (i >> 1)));
}
int main() {
  int t, n, i, j, k;
  cin >> t;
  while (t--) {
    long long l, r, lvl, sz, sc, mx;
    scanf("%d %lld %lld", &n, &l, &r);
    mx = n * (n - 1ll) + 1;
    if (l == mx) {
      printf("1\n");
      continue;
    }
    for (lvl = 1, sz = 0; lvl < n; lvl++) {
      sc = 2 * (n - lvl);
      if (sz >= l) {
        display(lvl, 1, min(sc, r - sz));
      } else if (sz + sc >= l) {
        display(lvl, l - sz, min(sc, r - sz));
      }
      sz += sc;
      if (sz >= r) {
        puts("");
        break;
      }
    }
    if (r == mx) {
      printf("1\n");
    }
  }
}
