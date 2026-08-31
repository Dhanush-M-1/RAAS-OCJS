#include <bits/stdc++.h>
const int MAXN = 2e5 + 10;
const long long inf = 1e17 + 10;
using namespace std;
struct Seg {
  long long v[MAXN * 4], lazy[MAXN * 4];
  int m(int l, int r) { return (l + r) / 2; }
  void updPoint(int pos, int l, int r, int x, long long val) {
    if (l == r) {
      v[pos] = val;
      return;
    }
    if (x <= m(l, r))
      updPoint(pos * 2, l, m(l, r), x, val);
    else
      updPoint(pos * 2 + 1, m(l, r) + 1, r, x, val);
    v[pos] = min(v[pos * 2], v[pos * 2 + 1]);
  }
  void refresh(int pos, int l, int r) {
    long long k = lazy[pos];
    lazy[pos] = 0;
    v[pos] -= k;
    if (l == r) return;
    for (int i = 0; i < 2; i++) lazy[pos * 2 + i] += k;
  }
  void updInterval(int pos, int l, int r, int beg, int en, long long val) {
    refresh(pos, l, r);
    if (l > en || r < beg) return;
    if (l >= beg && r <= en) {
      lazy[pos] += val;
      refresh(pos, l, r);
      return;
    }
    updInterval(pos * 2, l, m(l, r), beg, en, val);
    updInterval(pos * 2 + 1, m(l, r) + 1, r, beg, en, val);
    v[pos] = min(v[pos * 2], v[pos * 2 + 1]);
  }
  int buscab(int pos, int l, int r) {
    refresh(pos, l, r);
    if (l == r) return l;
    refresh(pos * 2, l, m(l, r));
    refresh(pos * 2 + 1, m(l, r) + 1, r);
    if (v[pos * 2] > 0) return buscab(pos * 2 + 1, m(l, r) + 1, r);
    return buscab(pos * 2, l, m(l, r));
  }
};
int n;
long long vet[MAXN];
int seq[MAXN];
Seg seg;
int main() {
  scanf("%d", &n);
  for (int i = 1; i < n + 1; i++) scanf("%lld", &vet[i]);
  reverse(vet + 1, vet + 1 + n);
  for (int i = 1; i < n + 1; i++) seg.updPoint(1, 1, n, i, vet[i]);
  for (int i = 1; i < n + 1; i++) {
    int t = seg.buscab(1, 1, n);
    seg.updInterval(1, 1, n, 1, t - 1, i);
    seg.updInterval(1, 1, n, t, t, -inf);
    seq[n - t + 1] = i;
  }
  for (int i = 1; i < n + 1; i++) printf("%d ", seq[i]);
  printf("\n");
}
