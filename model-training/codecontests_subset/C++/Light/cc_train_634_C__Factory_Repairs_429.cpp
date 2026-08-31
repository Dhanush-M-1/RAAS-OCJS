#include <bits/stdc++.h>
using namespace std;
int n, k, q, a, b;
vector<int> ta, tb;
vector<int> orders;
int tsize;
void update(vector<int>& t, int i, int val) {
  i += tsize;
  t[i] = val;
  i >>= 1;
  while (i) {
    t[i] = t[i * 2] + t[i * 2 + 1];
    i >>= 1;
  }
}
int sum(vector<int>& t, int l, int r) {
  l += tsize;
  r += tsize;
  int ret = 0;
  while (l <= r) {
    if (l & 1) ret += t[l++];
    if (!(r & 1)) ret += t[r--];
    l /= 2;
    r /= 2;
  }
  return ret;
}
int main() {
  cin >> n >> k >> a >> b >> q;
  tsize = 1;
  while (tsize < n) tsize *= 2;
  ta = vector<int>(2 * tsize + 10);
  tb = vector<int>(2 * tsize + 10);
  orders = vector<int>(n);
  for (int i = 0; i < (int)(q); i++) {
    int ty;
    scanf("%d", &ty);
    if (ty == 1) {
      int d, cnt;
      scanf("%d %d", &d, &cnt);
      d--;
      orders[d] += cnt;
      update(ta, d, min(a, orders[d]));
      update(tb, d, min(b, orders[d]));
    } else {
      int p;
      scanf("%d", &p);
      p--;
      printf("%d\n", sum(tb, 0, p - 1) + sum(ta, p + k, n - 1));
    }
  }
  return 0;
}
