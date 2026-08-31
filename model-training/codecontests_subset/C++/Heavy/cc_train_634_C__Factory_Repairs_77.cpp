#include <bits/stdc++.h>
using namespace std;
struct tree {
  int suma, sumb;
  tree* l;
  tree* r;
  tree() : suma(0), sumb(0) {
    l = NULL;
    r = NULL;
  }
};
int n, a, b, st2 = 1;
void init(tree*& t, int l = 1, int r = st2) {
  if (l == r) return;
  int mid = (l + r) / 2;
  tree* lt = new tree();
  tree* rt = new tree();
  init(lt, l, mid);
  init(rt, mid + 1, r);
  t->l = lt;
  t->r = rt;
}
void add(tree*& t, int v, int z, int l = 1, int r = st2) {
  if ((l == v) && (r == v)) {
    t->suma = min(t->suma + z, a);
    t->sumb = min(t->sumb + z, b);
    return;
  }
  int mid = (l + r) / 2;
  if (v > mid) {
    int sa, sb;
    sa = t->r->suma;
    sb = t->r->sumb;
    add(t->r, v, z, mid + 1, r);
    t->suma -= sa;
    t->suma += t->r->suma;
    t->sumb -= sb;
    t->sumb += t->r->sumb;
  } else {
    int sa, sb;
    sa = t->l->suma;
    sb = t->l->sumb;
    add(t->l, v, z, l, mid);
    t->suma -= sa;
    t->suma += t->l->suma;
    t->sumb -= sb;
    t->sumb += t->l->sumb;
  }
}
int suma(tree* t, int l, int r, int lu = 1, int ru = st2) {
  if (lu > r) return 0;
  if (ru < l) return 0;
  if ((l <= lu) && (r >= ru)) return t->suma;
  int mid = (lu + ru) / 2;
  int q1 = suma(t->l, l, r, lu, mid);
  int q2 = suma(t->r, l, r, mid + 1, ru);
  return (q1 + q2);
}
int sumb(tree* t, int l, int r, int lu = 1, int ru = st2) {
  if (lu > r) return 0;
  if (ru < l) return 0;
  if ((l <= lu) && (r >= ru)) return t->sumb;
  int mid = (lu + ru) / 2;
  int q1 = sumb(t->l, l, r, lu, mid);
  int q2 = sumb(t->r, l, r, mid + 1, ru);
  return q1 + q2;
}
void dfs(tree* t, int l = 1, int r = st2) {
  if (t == NULL) return;
  cout << l << " " << r << " - " << t->suma << " " << t->sumb << "\n";
  int mid = (l + r) / 2;
  dfs(t->l, l, mid);
  dfs(t->r, mid + 1, r);
}
int main() {
  int k, q;
  cin >> n >> k >> a >> b >> q;
  while (st2 < n) st2 <<= 1;
  tree* t = new tree();
  init(t);
  for (int i = 0; i < q; i++) {
    int w;
    cin >> w;
    if (w == 1) {
      int cnt, d;
      cin >> d >> cnt;
      add(t, d, cnt);
    }
    if (w == 2) {
      int p;
      cin >> p;
      int pa = 0, pb = 0;
      if (p > 1) pa = sumb(t, 1, p - 1);
      if ((p + k - 1) <= n) pb = suma(t, p + k, n);
      cout << pa + pb << "\n";
    }
  }
  return 0;
}
