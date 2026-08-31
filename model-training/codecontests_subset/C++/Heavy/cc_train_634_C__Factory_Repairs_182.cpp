#include <bits/stdc++.h>
using namespace std;
int arbbrk[4 * 200003], arbrep[4 * 200003], n, a, b, k, q, ans, z, x, p, d;
void update(int arb[], int nod, int left, int right, int val, int poz, int c) {
  int mij = (left + right) >> 1;
  if (left == right) {
    arb[nod] += val;
    arb[nod] = min(arb[nod], c);
    return;
  }
  if (poz <= mij)
    update(arb, 2 * nod, left, mij, val, poz, c);
  else
    update(arb, 2 * nod + 1, mij + 1, right, val, poz, c);
  arb[nod] = arb[2 * nod] + arb[2 * nod + 1];
}
void query(int arb[], int nod, int left, int right, int L, int R) {
  int mij = (left + right) >> 1;
  if (left > R || right < L) {
    return;
  }
  if (left >= L && right <= R) {
    ans += arb[nod];
    return;
  }
  query(arb, 2 * nod, left, mij, L, R);
  query(arb, 2 * nod + 1, mij + 1, right, L, R);
}
int main() {
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; ++i) {
    cin >> z;
    if (z == 1) {
      cin >> d >> p;
      update(arbbrk, 1, 1, n, p, d, b);
      update(arbrep, 1, 1, n, p, d, a);
    } else {
      cin >> x;
      ans = 0;
      query(arbbrk, 1, 1, n, 1, x - 1);
      query(arbrep, 1, 1, n, x + k, n);
      cout << ans << '\n';
    }
  }
  return 0;
}
