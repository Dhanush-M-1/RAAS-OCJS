#include <bits/stdc++.h>
using namespace std;
const int N = int(5e5);
int ta[N], tb[N];
int n, k, a, b, q;
void upda(int v, int p) {
  v += n - 1;
  ta[v] = min(ta[v] + p, a);
  while (v > 1) {
    v /= 2;
    ta[v] = ta[2 * v] + ta[2 * v + 1];
  }
}
void updb(int v, int p) {
  v += n - 1;
  tb[v] = min(tb[v] + p, b);
  while (v > 1) {
    v /= 2;
    tb[v] = tb[2 * v] + tb[2 * v + 1];
  }
}
long long geta(int l, int r) {
  l += n - 1;
  r += n - 1;
  long long res = 0;
  while (l <= r) {
    if (l & 1) res += ta[l];
    if (!(r & 1)) res += ta[r];
    l = (l + 1) / 2;
    r = (r - 1) / 2;
  }
  return res;
}
long long getb(int l, int r) {
  l += n - 1;
  r += n - 1;
  long long res = 0;
  while (l <= r) {
    if (l & 1) res += tb[l];
    if (!(r & 1)) res += tb[r];
    l = (l + 1) / 2;
    r = (r - 1) / 2;
  }
  return res;
}
int main() {
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  for (int i = 1, t, d, p; i <= q; i++) {
    scanf("%d", &t);
    if (t == 1) {
      scanf("%d%d", &d, &p);
      upda(d, p);
      updb(d, p);
    } else {
      scanf("%d", &p);
      printf("%I64d\n", getb(1, p - 1) + geta(p + k, n));
    }
  }
  return 0;
}
