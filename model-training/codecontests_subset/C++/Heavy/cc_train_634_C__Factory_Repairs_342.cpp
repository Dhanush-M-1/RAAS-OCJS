#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9 + 5;
const int nax = 2e5 + 5;
int n, k, a, b, q, d, x, poz, typ, res;
int d_pref[nax], d_suf[nax], val_pref[nax], val_suf[nax];
int magic(int x) { return x & -x; }
void insert_pref(int poz, int val) {
  int r = min(b, val_pref[poz] + val) - val_pref[poz];
  val_pref[poz] += r;
  while (poz <= n) {
    d_pref[poz] += r;
    poz += magic(poz);
  }
}
void insert_suf(int poz, int val) {
  if (poz == 0) return;
  int r = min(a, val_suf[poz] + val) - val_suf[poz];
  val_suf[poz] += r;
  while (poz) {
    d_suf[poz] += r;
    poz -= magic(poz);
  }
}
int query_pref(int poz) {
  if (poz == 0) return 0;
  int res = 0;
  while (poz) {
    res += d_pref[poz];
    poz -= magic(poz);
  }
  return res;
}
int query_suf(int poz) {
  int res = 0;
  while (poz <= n) {
    res += d_suf[poz];
    poz += magic(poz);
  }
  return res;
}
void insert(int poz, int val) {
  insert_pref(poz, val);
  insert_suf(poz, val);
}
int main() {
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  for (int i = (0); i <= ((q)-1); ++i) {
    scanf("%d", &typ);
    if (typ == 1) {
      scanf("%d%d", &d, &x);
      insert(d, x);
    } else {
      scanf("%d", &poz);
      res = query_pref(poz - 1) + query_suf(poz + k);
      printf("%d\n", res);
    }
  }
  return 0;
}
