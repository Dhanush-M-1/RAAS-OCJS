#include <bits/stdc++.h>
using namespace std;
const int sizet = 1 << 19;
int T[sizet];
int TT[sizet];
void posa_T(int p, int x) {
  T[p + sizet / 2] = x;
  for (p = (p + sizet / 2) / 2; p > 0; p /= 2) {
    T[p] = T[2 * p] + T[2 * p + 1];
  }
}
void posa_TT(int p, int x) {
  TT[p + sizet / 2] = x;
  for (p = (p + sizet / 2) / 2; p > 0; p /= 2) {
    TT[p] = TT[2 * p] + TT[2 * p + 1];
  }
}
int Suma_T(int a, int b, int p = 1, int i = 0, int j = sizet / 2) {
  if (a <= i && j <= b) return T[p];
  if (j <= a || b <= i) return 0;
  return Suma_T(a, b, 2 * p, i, (i + j) / 2) +
         Suma_T(a, b, 2 * p + 1, (i + j) / 2, j);
}
int Suma_TT(int a, int b, int p = 1, int i = 0, int j = sizet / 2) {
  if (a <= i && j <= b) return TT[p];
  if (j <= a || b <= i) return 0;
  return Suma_TT(a, b, 2 * p, i, (i + j) / 2) +
         Suma_TT(a, b, 2 * p + 1, (i + j) / 2, j);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, k, a, b, q;
  while (cin >> n >> k >> a >> b >> q) {
    for (int i = 0; i < sizet; i++) {
      T[i] = 0;
      TT[i] = 0;
    }
    vector<int> aux(n);
    for (int query = 0; query < q; query++) {
      int tipus;
      cin >> tipus;
      if (tipus == 1) {
        int d, upd;
        cin >> d >> upd;
        --d;
        aux[d] += upd;
        posa_T(d, min(b, aux[d]));
        posa_TT(d, min(a, aux[d]));
      } else {
        int d;
        cin >> d;
        --d;
        cout << Suma_T(0, d) + (d + k < n ? Suma_TT(d + k, n) : 0) << endl;
      }
    }
  }
}
