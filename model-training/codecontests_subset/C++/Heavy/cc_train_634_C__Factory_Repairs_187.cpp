#include <bits/stdc++.h>
using namespace std;
const int N = 200100;
int n, k, a, b, q;
int val[4 * N], sma[4 * N], smb[4 * N];
void update(int nod, int pozx, int pozy, int poz, int el) {
  if (pozx == pozy) {
    val[nod] += el;
    sma[nod] = min(val[nod], a);
    smb[nod] = min(val[nod], b);
    return;
  }
  int mid = (pozx + pozy) / 2;
  if (mid >= poz)
    update(2 * nod, pozx, mid, poz, el);
  else
    update(2 * nod + 1, mid + 1, pozy, poz, el);
  sma[nod] = sma[2 * nod] + sma[2 * nod + 1];
  smb[nod] = smb[2 * nod] + smb[2 * nod + 1];
}
int query(int op, int nod, int pozx, int pozy, int poz1, int poz2) {
  if (poz2 == 0 || poz1 > n) return 0;
  if (pozx >= poz1 && poz2 >= pozy) {
    if (op == 2) return sma[nod];
    return smb[nod];
  }
  int mid = (pozx + pozy) / 2, r = 0;
  if (mid >= poz1) r = query(op, 2 * nod, pozx, mid, poz1, poz2);
  if (mid < poz2) r += query(op, 2 * nod + 1, mid + 1, pozy, poz1, poz2);
  return r;
}
int main() {
  int i;
  cin >> n >> k >> a >> b >> q;
  for (i = 1; i <= q; ++i) {
    int op, n1, n2;
    scanf("%d%d", &op, &n1);
    if (op == 1) {
      scanf("%d", &n2);
      update(1, 1, n, n1, n2);
    } else {
      printf("%d\n",
             query(1, 1, 1, n, 1, n1 - 1) + query(2, 1, 1, n, n1 + k, n));
    }
  }
  return 0;
}
