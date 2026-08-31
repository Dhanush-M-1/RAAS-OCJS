#include <bits/stdc++.h>
using namespace std;
int vst[250005], vdr[250005];
int n, k, a, b, q, d, sol;
int adist[250005 * 4], adidr[250005 * 4];
void update(int a[], int nod, int st, int dr, int val, int poz) {
  a[nod] += val;
  if (st == dr) return;
  int mid = (st + dr) >> 1;
  if (poz <= mid)
    update(a, nod * 2, st, mid, val, poz);
  else
    update(a, nod * 2 + 1, mid + 1, dr, val, poz);
}
void query(int a[], int nod, int st, int dr, int p1, int p2) {
  if (p1 <= st && dr <= p2) {
    sol += a[nod];
    return;
  }
  if (st == dr) return;
  int mid = (st + dr) >> 1;
  if (p1 <= mid) query(a, nod * 2, st, mid, p1, p2);
  if (p2 >= mid + 1) query(a, nod * 2 + 1, mid + 1, dr, p1, p2);
}
int main() {
  int i, j, p, aux;
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  for (i = 1; i <= q; i++) {
    scanf("%d", &j);
    if (j == 1) {
      scanf("%d %d", &d, &p);
      aux = vst[d];
      vst[d] += p;
      if (vst[d] > b) vst[d] = b;
      update(adist, 1, 1, n, vst[d] - aux, d);
      aux = vdr[d];
      vdr[d] += p;
      if (vdr[d] > a) vdr[d] = a;
      update(adidr, 1, 1, n, vdr[d] - aux, d);
    } else {
      scanf("%d", &p);
      sol = 0;
      query(adist, 1, 1, n, 1, p - 1);
      query(adidr, 1, 1, n, p + k, n);
      printf("%d\n", sol);
    }
  }
}
