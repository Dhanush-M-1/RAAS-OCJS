#include <bits/stdc++.h>
using namespace std;
const bool print = false;
const int MAXN = 400111;
long long orders[MAXN];
long long tr1[MAXN];
long long tr2[MAXN];
void dod1(int pos1, long long val) {
  pos1++;
  for (; pos1 < MAXN; pos1 += (pos1 & (-pos1))) tr1[pos1] += val;
}
void dod2(int pos, long long val) {
  pos++;
  for (; pos > 0; pos -= (pos & (-pos))) tr2[pos] += val;
}
long long pyta1(int pos) {
  pos++;
  long long wyn = 0;
  for (; pos > 0; pos -= (pos & (-pos))) wyn += tr1[pos];
  return wyn;
}
long long pyta2(int pos1) {
  pos1++;
  long long wyn = 0;
  for (; pos1 < MAXN; pos1 += (pos1 & (-pos1))) wyn += tr2[pos1];
  return wyn;
}
int main() {
  int n, k;
  long long a, b;
  int q;
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    int typ;
    scanf("%d", &typ);
    if (typ == 1) {
      int d, aa;
      scanf("%d%d", &d, &aa);
      dod1(d, -min(b, orders[d]));
      dod2(d, -min(a, orders[d]));
      orders[d] += aa;
      dod1(d, min(b, orders[d]));
      dod2(d, min(a, orders[d]));
    } else {
      int p;
      scanf("%d", &p);
      long long wyn = pyta1(p - 1) + pyta2(p + k);
      printf("%I64d\n", wyn);
    }
  }
}
