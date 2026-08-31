#include <bits/stdc++.h>
using namespace std;
long n, i, j, a, b, t, k, q, d, x, p;
struct ab {
  long a, b;
} A[600005];
void up(long nod, long a, long b) {
  A[nod].a += a;
  A[nod].b += b;
  if (nod != 1) up(nod / 2, a, b);
}
long querry(long nod, long a, long b, long st, long dr, long val) {
  long mij = (a + b) / 2;
  if (st > dr) return 0;
  if (st <= a && dr >= b) {
    if (val == 1)
      return A[nod].b;
    else
      return A[nod].a;
  }
  if (st > mij) return querry(nod * 2 + 1, mij + 1, b, st, dr, val);
  if (dr < mij) return querry(nod * 2, a, mij, st, dr, val);
  return querry(nod * 2, a, mij, st, mij, val) +
         querry(nod * 2 + 1, mij + 1, b, mij + 1, dr, val);
}
int main() {
  cin >> n >> k >> a >> b;
  cin >> q;
  p = 1;
  while (p < n) p = p << 1;
  for (i = 1; i <= q; i++) {
    cin >> t;
    if (t == 1) {
      cin >> d >> x;
      if (min(x + A[p + d - 1].a, a) - A[p + d - 1].a > 0 ||
          min(x + A[p + d - 1].b, b) - A[p + d - 1].b > 0) {
        up(p + d - 1, min(x + A[p + d - 1].a, a) - A[p + d - 1].a,
           min(x + A[p + d - 1].b, b) - A[p + d - 1].b);
      }
    } else {
      cin >> d;
      cout << querry(1, 1, p, 1, d - 1, 1) + querry(1, 1, p, d + k, n, 2)
           << '\n';
    }
  }
  return 0;
}
