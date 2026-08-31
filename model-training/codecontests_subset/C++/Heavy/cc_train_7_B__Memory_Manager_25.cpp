#include <bits/stdc++.h>
using namespace std;
long long n, t = 0, m, tt, i, j, k, g, x, u = 0, nm = 0, tn;
string s;
struct sd {
  long long l, r, num;
} a[102] = {0};
bool cmp(sd x, sd y) { return x.l < y.l; }
int main() {
  scanf("%lld%lld", &tt, &m);
  for (g = 1; g <= tt; ++g) {
    cin >> s;
    if (s[0] == 'a') {
      scanf("%lld", &x);
      u = 0;
      tn = t;
      for (i = 0; i <= tn; ++i)
        if ((a[i].r + x < a[i + 1].l && i + 1 <= t) ||
            (a[i].r + x <= m && i + 1 > t)) {
          a[++t].l = a[i].r + 1;
          a[t].r = a[i].r + x;
          a[t].num = ++nm;
          printf("%lld\n", nm);
          sort(a + 1, a + t + 1, cmp);
          u = 1;
          break;
        }
      if (u == 0) printf("NULL\n");
    }
    if (s[0] == 'e') {
      scanf("%lld", &x);
      u = 0;
      for (i = 1; i <= t; ++i)
        if (a[i].num == x) {
          a[i].l = 1000000000;
          sort(a + 1, a + t + 1, cmp);
          u = 1;
          t--;
          break;
        }
      if (u == 0) printf("ILLEGAL_ERASE_ARGUMENT\n");
    }
    if (s[0] == 'd') {
      for (i = 1; i <= t; ++i) {
        a[i].r = a[i].r - a[i].l + a[i - 1].r + 1;
        a[i].l = a[i - 1].r + 1;
      }
    }
  }
  return 0;
}
