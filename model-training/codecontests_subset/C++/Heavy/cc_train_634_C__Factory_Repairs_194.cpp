#include <bits/stdc++.h>
using namespace std;
const int Nmax = 2e5 + 10;
int n, k, a, b, q, i;
int tip, d, p, lll;
pair<int, int> arb[4 * Nmax];
void update(int nod, int st, int dr, int val, int poz) {
  if (st >= dr) {
    arb[nod].first = min(b, arb[nod].first + val);
    arb[nod].second = min(a, arb[nod].second + val);
    return;
  }
  int mij = (st + dr) >> 1;
  if (poz <= mij)
    update((nod << 1), st, mij, val, poz);
  else
    update(((nod << 1) | 1), mij + 1, dr, val, poz);
  arb[nod].first = arb[(nod << 1)].first + arb[((nod << 1) | 1)].first;
  arb[nod].second = arb[(nod << 1)].second + arb[((nod << 1) | 1)].second;
}
int query(int nod, int st, int dr, int a, int b, int r) {
  if (a <= st && dr <= b)
    if (r == 0)
      return arb[nod].first;
    else
      return arb[nod].second;
  int mij = (st + dr) >> 1;
  int val1 = (a <= mij) ? query((nod << 1), st, mij, a, b, r) : 0;
  int val2 = (mij < b) ? query(((nod << 1) | 1), mij + 1, dr, a, b, r) : 0;
  return val1 + val2;
}
int main() {
  scanf("%d %d", &n, &k);
  scanf("%d %d", &a, &b);
  scanf("%d", &q);
  for (i = 1; i <= q; ++i) {
    scanf("%d", &tip);
    if (tip == 1) {
      scanf("%d %d", &d, &p);
      update(1, 1, n, p, d);
    } else {
      scanf("%d", &lll);
      int v = 0;
      if (lll > 1) v += query(1, 1, n, 1, lll - 1, 0);
      if (lll + k <= n) v += query(1, 1, n, lll + k, n, 1);
      printf("%d\n", v);
    }
  }
  return 0;
}
